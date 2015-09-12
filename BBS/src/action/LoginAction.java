package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import model.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.imp.DlDaoImp;

public class LoginAction extends ActionSupport {
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() {
		this.clearErrorsAndMessages();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String kaptchaExpected = (String)ActionContext.getContext().getSession()
				.get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String kaptcha=request.getParameter("kaptcha");
		DlDaoImp dlDaoImp = new DlDaoImp();
		if (user != null) {
			User user2 = dlDaoImp.judgeUser(user);
			if (user2 != null) {
				if (session.getAttribute("loginUser") != null) {
					session.removeAttribute("loginUser");
				}
				session.setAttribute("loginUser", user2);
				if(kaptchaExpected.equals(kaptcha)){
					return SUCCESS;
				}else{
					this.addActionMessage("验证码错误！");
					return INPUT;
				}
			} else {
				this.addActionMessage("用户名或密码有误！");
				return INPUT;
			}
		} else {
			this.addActionMessage("用户名或密码不能为空");
			return INPUT;
		}

	}
}
