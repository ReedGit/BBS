package dao;

import java.util.List;

import model.Note;

public interface NoteDao {
	
	public int noteAmount();//��ȡ������������
	public int[] pageNumber(int noteAmount,String pageNumberStr,int pageSize);//��ҳ,���ص�ǰҳ������ҳ��
	public List<Note> allNote(int pageNumber ,int pageSize);//��ѯ��������
	public Note findNote(int noteId);//��ѯһ��������Ϣ
	public void saveNote(Note note);//���һ������
	public void deleteNote(Note note);//ɾ��һ������
	public List<Note> classifyNote(String classify,int pageNumber ,int pageSize);//�����ѯ
	public int classifyAmount(String classify);//��ȡ������������
	public int commentAmount(Note note);//��ȡ��������

}
