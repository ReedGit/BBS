package action;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.CommentDaoImp;
import dao.imp.NoteDaoImp;
import model.Comment;
import model.Note;
import model.User;

public class AddCommentAction extends ActionSupport{
	
	private Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	public String execute(){
		this.clearErrorsAndMessages();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		Note note = (Note) session.getAttribute("currentNote");
		CommentDaoImp commentDaoImp = new CommentDaoImp();
		comment.setCommentTime(new Timestamp(new Date().getTime()));
		comment.setNote(note);
		comment.setUser(user);
		commentDaoImp.saveComment(comment);
		return SUCCESS;
	}

}
