package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.NoteDaoImp;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Note;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class AllNoteAction extends ActionSupport{

	private List<Note> allNote;
	private int totalPage;
	private int pageNumber;
	private int pageSize;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	public List<Note> getAllNote() {
		return allNote;
	}

	public void setAllNote(List<Note> allNote) {
		this.allNote = allNote;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("currentNote");
		String pageNumberStr = request.getParameter("pageNumber");
		if(pageNumberStr == null || "".equals(pageNumberStr.trim())){
			pageNumberStr = "1";
		}
		NoteDaoImp noteDaoImp = new NoteDaoImp();
		pageSize = 10;
		int noteAmount = noteDaoImp.noteAmount();
		int[] paging = new int[2];
		paging = noteDaoImp.pageNumber(noteAmount, pageNumberStr, pageSize);
		pageNumber = paging[0];
		totalPage = paging[1];
		allNote = noteDaoImp.allNote(pageNumber, pageSize);
		return SUCCESS;
	}
		
}
