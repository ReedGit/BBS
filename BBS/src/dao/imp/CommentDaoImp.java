package dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import model.Comment;
import model.Note;
import dao.CommentDao;

public class CommentDaoImp implements CommentDao {

	private Session session;
	private Query query;
	private Transaction transaction;

	@Override
	public int[] pageNumber(int commentAmount, String pageNumberStr,
			int pageSize) {
		int[] paging = new int[2];
		int pageNumber = 1;
		pageNumber = Integer.parseInt(pageNumberStr);
		if (pageNumber <= 0) {
			pageNumber = 1;
		}
		int totalPage = 1;
		if (commentAmount > 0) {
			totalPage = commentAmount % pageSize == 0 ? (commentAmount / pageSize)
					: (commentAmount / pageSize + 1);
		}
		if (pageNumber > totalPage) {
			pageNumber = totalPage;
		}
		paging[0] = pageNumber;
		paging[1] = totalPage;
		return paging;
	}

	@Override
	public List<Comment> allComment(Note note, int pageNumber, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<Comment> allComment = new ArrayList<Comment>();
		String hql = "from Comment as comment where comment.note.noteId = ? order by comment.commentTime asc";
		query = session.createQuery(hql);
		query.setString(0, note.getNoteId().toString());
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		allComment = query.list();
		session.close();
		return allComment;
	}

	@Override
	public void saveComment(Comment comment) {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		session.save(comment);
		transaction.commit();
		session.close();

	}

	@Override
	public void deleteComment(Note note) {
		session = HibernateSessionFactory.getSession();
		String hql = "delete from Comment as comment where comment.note.noteId= ? ";
		query = session.createQuery(hql);
		query.setString(0, Integer.toString(note.getNoteId()));
		query.executeUpdate();
		session.close();

	}

}
