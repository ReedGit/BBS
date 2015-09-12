package dao.imp;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import model.User;
import dao.ZcDao;

public class ZcDaoImp implements ZcDao {
	
	private Session session;
	private Query query;
	private Transaction transaction;

	@Override
	public boolean judge(String userId) {
		boolean flag = true;
		session = HibernateSessionFactory.getSession();
		String hql = "from User as user where user.userId = ?";
		query = session.createQuery(hql);
		query.setString(0, userId);
		Iterator<User> iterator = query.list().iterator();
		if(!iterator.hasNext()){
			flag = false;
		}
		session.close();
		return flag;
	}

	@Override
	public void addUser(User user) {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

}
