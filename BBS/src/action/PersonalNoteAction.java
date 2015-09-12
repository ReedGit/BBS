package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.Comment;
import model.Note;
import model.User;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.CommentDaoImp;
import dao.imp.NoteDaoImp;
import dao.imp.UserDaoImp;

public class PersonalNoteAction extends ActionSupport {

	private List<Note> personalNote;
	private int totalPage;
	private int pageNumber;
	private int pageSize;

	public List<Note> getPersonalNote() {
		return personalNote;
	}

	public void setPersonalNote(List<Note> personalNote) {
		this.personalNote = personalNote;
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String loginNote() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("currentNote");
		if(session.getAttribute("loginUser")==null){
			return ERROR;
		}
		User user = (User) session.getAttribute("loginUser");
		String pageNumberStr = request.getParameter("pageNumber");
		if (pageNumberStr == null || "".equals(pageNumberStr.trim())) {
			pageNumberStr = "1";
		}
		UserDaoImp userDaoImp = new UserDaoImp();
		NoteDaoImp noteDaoImp = new NoteDaoImp();
		pageSize = 10;
		int noteAmount = userDaoImp.personalNoteAmount(user);
		int[] paging = new int[2];
		paging = noteDaoImp.pageNumber(noteAmount, pageNumberStr, pageSize);
		pageNumber = paging[0];
		totalPage = paging[1];
		personalNote = userDaoImp.personalNote(user, pageNumber, pageSize);
		return SUCCESS;
	}
	
	public String authorNote() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("currentNote");
		String pageNumberStr = request.getParameter("pageNumber");
		if (pageNumberStr == null || "".equals(pageNumberStr.trim())) {
			pageNumberStr = "1";
		}
		UserDaoImp userDaoImp = new UserDaoImp();
		User user = userDaoImp.findUser(request.getParameter("userId"));
		NoteDaoImp noteDaoImp = new NoteDaoImp();
		pageSize = 10;
		int noteAmount = userDaoImp.personalNoteAmount(user);
		int[] paging = new int[2];
		paging = noteDaoImp.pageNumber(noteAmount, pageNumberStr, pageSize);
		pageNumber = paging[0];
		totalPage = paging[1];
		personalNote = userDaoImp.personalNote(user, pageNumber, pageSize);
		return SUCCESS;
	}
	


}
