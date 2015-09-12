package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ExitAction extends ActionSupport{

	public String userExit(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null){
			session.removeAttribute("loginUser");
		}
		return SUCCESS;
	}
	public String managerExit(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("loginManager") != null){
			session.removeAttribute("loginManager");
		}
		return SUCCESS;
	}
}
