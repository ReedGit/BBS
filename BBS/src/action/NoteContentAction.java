package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Comment;
import model.Note;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.CommentDaoImp;
import dao.imp.NoteDaoImp;

public class NoteContentAction extends ActionSupport {
	private Note note;

	private List<Comment> allComment;

	private int totalPage;
	private int pageNumber;
	private int pageSize;
	private int commentAmount;

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

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public List<Comment> getAllComment() {
		return allComment;
	}

	public void setAllComment(List<Comment> allComment) {
		this.allComment = allComment;
	}

	public int getCommentAmount() {
		return commentAmount;
	}

	public void setCommentAmount(int commentAmount) {
		this.commentAmount = commentAmount;
	}

	public String allComment() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String pageNumberStr = request.getParameter("pageNumber");
		if (pageNumberStr == null || "".equals(pageNumberStr.trim())) {
			pageNumberStr = "1";
		}
		NoteDaoImp noteDaoImp = new NoteDaoImp();
		if(request.getParameter("noteId")!=null){
			note = noteDaoImp.findNote(Integer.parseInt(request
					.getParameter("noteId")));
			session.setAttribute("currentNote",note);
		}
		else {
			note=(Note) session.getAttribute("currentNote");
		}
		CommentDaoImp commentDaoImp = new CommentDaoImp();
		pageSize = 10;
		commentAmount = noteDaoImp.commentAmount(note);
		int[] paging = new int[2];
		paging = commentDaoImp.pageNumber(commentAmount, pageNumberStr,
				pageSize);
		pageNumber = paging[0];
		totalPage = paging[1];
		allComment = commentDaoImp.allComment(note, pageNumber, pageSize);
		return SUCCESS;
	}

}
