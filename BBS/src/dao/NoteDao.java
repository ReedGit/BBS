package dao;

import java.util.List;

import model.Note;

public interface NoteDao {
	
	public int noteAmount();//获取所有帖子总数
	public int[] pageNumber(int noteAmount,String pageNumberStr,int pageSize);//分页,返回当前页数和总页数
	public List<Note> allNote(int pageNumber ,int pageSize);//查询所有帖子
	public Note findNote(int noteId);//查询一个帖子信息
	public void saveNote(Note note);//添加一个帖子
	public void deleteNote(Note note);//删除一个帖子
	public List<Note> classifyNote(String classify,int pageNumber ,int pageSize);//分类查询
	public int classifyAmount(String classify);//获取分类帖子总数
	public int commentAmount(Note note);//获取评论总数

}
