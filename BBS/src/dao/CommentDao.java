package dao;

import java.util.List;

import model.Comment;
import model.Note;


public interface CommentDao {
	
	public int[] pageNumber(int commentAmount,String pageNumberStr,int pageSize);//��ҳ,���ص�ǰҳ������ҳ��
	public List<Comment> allComment(Note note,int pageNumber ,int pageSize);//��ѯ��������
	public void saveComment(Comment comment);//���һ������
	public void deleteComment(Note note);//ɾ��һ����������

}
