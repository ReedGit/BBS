package action;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.apache.struts2.ServletActionContext;

import model.Note;
import model.User;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.NoteDaoImp;


public class AddNoteAction extends ActionSupport{
	private Note note;

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}
	
	public String execute(){
		this.clearErrorsAndMessages();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");	
		if(request.getParameter("note.noteTitle").isEmpty()||request.getParameter("note.noteContent").isEmpty()||request.getParameter("note.noteClassify")==null){
			this.addActionMessage("标题或内容不能为空");
			return INPUT;
		}
		else {
			NoteDaoImp noteDaoImp = new NoteDaoImp();
			note.setNoteTime(new Timestamp(new Date().getTime()));
			note.setUser(user);
			noteDaoImp.saveNote(note);
			return SUCCESS;
		}
	} 

}
