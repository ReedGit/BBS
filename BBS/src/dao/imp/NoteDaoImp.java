package dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateSessionFactory;
import model.Note;
import dao.NoteDao;

public class NoteDaoImp implements NoteDao{
	
	private Session session;
	private Query query;
	private Transaction transaction;

	@Override
	public int noteAmount() {
		int noteAmount = 0;
		session = HibernateSessionFactory.getSession();
		String hql = "select count(*) from Note";
		query = session.createQuery(hql);
		long  l = (Long)query.uniqueResult();
		noteAmount = (int)l;
		session.close();
		return noteAmount;
	}

	@Override
	public int[] pageNumber(int noteAmount, String pageNumberStr, int pageSize) {
		int[] paging = new int[2];
		int pageNumber = 1;
		pageNumber = Integer.parseInt(pageNumberStr);
		if(pageNumber <= 0){
			pageNumber = 1;
		}
		int totalPage = 1;
		if(noteAmount > 0){
			totalPage = noteAmount%pageSize==0?(noteAmount/pageSize):(noteAmount/pageSize+1);
		}
		if(pageNumber > totalPage){
			pageNumber = totalPage;
		}
		paging[0] = pageNumber;
		paging[1] = totalPage;
		return paging;
	}

	@Override
	public List<Note> allNote(int pageNumber, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<Note> allNote = new ArrayList<Note>();
		String hql = "from Note as note order by note.noteTime desc";
		query = session.createQuery(hql);
		query.setFirstResult((pageNumber - 1)*pageSize);
		query.setMaxResults(pageSize);
		allNote = query.list();
		session.close();
		return allNote;
	}

	@Override
	public Note findNote(int noteId) {
		session = HibernateSessionFactory.getSession();
		Note note = (Note) session.get("model.Note", noteId);
		session.close();
		return note;
	}

	@Override
	public void saveNote(Note note) {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		session.save(note);
		transaction.commit();
		session.close();			
	}

	@Override
	public void deleteNote(Note note) {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		session.delete(note);
		transaction.commit();
		session.close();
		
	}

	@Override
	public List<Note> classifyNote(String classify,int pageNumber, int pageSize) {
		session = HibernateSessionFactory.getSession();
		List<Note> classifyNote = new ArrayList<Note>();
		String hql = "from Note as note where note.noteClassify = ? order by note.noteTime desc";
		query = session.createQuery(hql);
		query.setString(0, classify);
		query.setFirstResult((pageNumber - 1)*pageSize);
		query.setMaxResults(pageSize);
		classifyNote = query.list();
		session.close();
		return classifyNote;
	}

	@Override
	public int classifyAmount(String classify) {
		int noteAmount = 0;
		session = HibernateSessionFactory.getSession();
		String hql = "select count(*) from Note as note where note.noteClassify = ?";
		query = session.createQuery(hql);
		query.setString(0, classify);
		long  l = (Long)query.uniqueResult();
		noteAmount = (int)l;
		session.close();
		return noteAmount;
	}

	@Override
	public int commentAmount(Note note) {
		int commentAmount = 0;
		session = HibernateSessionFactory.getSession();
		String hql = "select count(*) from Comment as comment where comment.note.noteId = ?";
		query = session.createQuery(hql);
		query.setString(0, Integer.toString(note.getNoteId()));
		long  l = (Long)query.uniqueResult();
		commentAmount = (int)l;
		session.close();
		return commentAmount;
	}

}
