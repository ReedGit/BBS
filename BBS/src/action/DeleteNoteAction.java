package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Comment;
import model.Note;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.CommentDaoImp;
import dao.imp.NoteDaoImp;

public class DeleteNoteAction extends ActionSupport{
	
	private String pageNumber;

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String noteIdStr = request.getParameter("noteId");
		pageNumber = request.getParameter("pageNumber");
		if(pageNumber == null || "".equals(pageNumber.trim())){
			pageNumber = "1";
		}
		int noteId = Integer.parseInt(noteIdStr);
		NoteDaoImp noteDaoImp=new NoteDaoImp();
		Note note = noteDaoImp.findNote(noteId);
		CommentDaoImp commentDaoImp=new CommentDaoImp();
		commentDaoImp.deleteComment(note);
		noteDaoImp.deleteNote(note);
		return SUCCESS;
	}

}
