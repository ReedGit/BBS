package dao.imp;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import model.User;
import dao.DlDao;

public class DlDaoImp implements DlDao {
	
	private Session session;
	private Query query;
	private Transaction transaction;

	@Override
	public User judgeUser(User user){
		User user2 = null;
		session = HibernateSessionFactory.getSession();
		String hql = "from User as user where user.userId = ? and user.userPassword = ?";
		query = session.createQuery(hql);
		query.setString(0, user.getUserId());
		query.setString(1, user.getUserPassword());
		Iterator<User> iterator = query.list().iterator();
		if(iterator.hasNext()){
			user2 = iterator.next();
		}
		session.close();
		return user2;
	}
	

}
