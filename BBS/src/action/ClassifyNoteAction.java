package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.Note;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.NoteDaoImp;

public class ClassifyNoteAction extends ActionSupport{
	
	private List<Note> classifyNote;
	private int totalPage;
	private int pageNumber;
	private int pageSize;
	public List<Note> getClassifyNote() {
		return classifyNote;
	}
	public void setClassifyNote(List<Note> classifyNote) {
		this.classifyNote = classifyNote;
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
	
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("currentNote");
		String classify=request.getParameter("classify");
		String pageNumberStr = request.getParameter("pageNumber");
		if(pageNumberStr == null || "".equals(pageNumberStr.trim())){
			pageNumberStr = "1";
		}
		NoteDaoImp noteDaoImp = new NoteDaoImp();
		pageSize = 10;
		int noteAmount = noteDaoImp.classifyAmount(classify);
		int[] paging = new int[2];
		paging = noteDaoImp.pageNumber(noteAmount, pageNumberStr, pageSize);
		pageNumber = paging[0];
		totalPage = paging[1];
		classifyNote = noteDaoImp.classifyNote(classify,pageNumber, pageSize);
		return SUCCESS;
	}

}
