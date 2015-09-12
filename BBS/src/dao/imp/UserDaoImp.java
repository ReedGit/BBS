package dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import model.Note;
import model.User;
import dao.UserDao;

public class UserDaoImp implements UserDao{
	
	private Session session;
	private Query query;
	private Transaction transaction;

	@Override
	public void updateUser(User user) {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		session.update(user);
		transaction.commit();
		session.close();
		
	}

	@Override
	public User findUser(String userId) {
		session = HibernateSessionFactory.getSession();
		User user = (User) session.get("model.User", userId);
		session.close();
		return user;
	}

	@Override
	public List<Note> personalNote(User user, int pageNumber, int pageSize) {
		List<Note> personalNote = new ArrayList<Note>();
		session = HibernateSessionFactory.getSession();
		String hql = "from Note as note where note.user.userId = ? order by note.noteTime desc";
		query = session.createQuery(hql);
		query.setString(0, user.getUserId());
		query.setFirstResult((pageNumber - 1)*pageSize);
		query.setMaxResults(pageSize);
		personalNote = query.list();
		session.close();
		return personalNote;
	}

	@Override
	public int personalNoteAmount(User user) {
		int personalNoteAmount = 0;
		session = HibernateSessionFactory.getSession();
		String hql = "select count(*) from Note as note where note.user.userId = ?";
		query = session.createQuery(hql);
		query.setString(0, user.getUserId());
		long  l = (Long)query.uniqueResult();
		personalNoteAmount = (int)l;
		session.close();
		return personalNoteAmount;
	}

}
