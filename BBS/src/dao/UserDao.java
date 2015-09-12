package dao;

import java.util.List;

import model.Note;
import model.User;


public interface UserDao {
	
	public void updateUser(User user);
	public User findUser(String userId);
	public List<Note> personalNote(User user,int pageNumber,int pageSize);
	public int personalNoteAmount(User user);

}
