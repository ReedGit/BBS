package dao;

import java.util.List;

import model.Comment;
import model.Note;


public interface CommentDao {
	
	public int[] pageNumber(int commentAmount,String pageNumberStr,int pageSize);//分页,返回当前页数和总页数
	public List<Comment> allComment(Note note,int pageNumber ,int pageSize);//查询所有评论
	public void saveComment(Comment comment);//添加一个评论
	public void deleteComment(Note note);//删除一个帖子评论

}
