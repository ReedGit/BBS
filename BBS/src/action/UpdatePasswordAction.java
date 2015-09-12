package action;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.UserDaoImp;

public class UpdatePasswordAction extends ActionSupport {

	private String userPassword;
	private String userNewPassword;
	private String userRePassword;

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNewPassword() {
		return userNewPassword;
	}

	public void setUserNewPassword(String userNewPassword) {
		this.userNewPassword = userNewPassword;
	}

	public String getUserRePassword() {
		return userRePassword;
	}

	public void setUserRePassword(String userRePassword) {
		this.userRePassword = userRePassword;
	}

	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		if (!userPassword.equals(user.getUserPassword())) {
			this.addActionMessage("���벻��ȷ��");
			return INPUT;
		}
		else if (!Pattern.matches("\\w{6,12}", userNewPassword)) {
			this.addActionMessage("������ʹ��6-12λ��ĸ�����֣�");
			return INPUT;
		}
		else if (!userRePassword.equals(userNewPassword)) {
			this.addActionMessage("������������벻һ�£�");
			return INPUT;
		}
		user.setUserPassword(userNewPassword);
		UserDaoImp userDaoImp = new UserDaoImp();
		userDaoImp.updateUser(user);
		session.setAttribute("loginUser", null);
		return SUCCESS;
	}
}
