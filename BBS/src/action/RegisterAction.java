package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.ZcDaoImp;
import model.User;

public class RegisterAction extends ActionSupport{	
	
	private User user;
	private String imageFile;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String register(){
		this.clearErrorsAndMessages();
		ZcDaoImp zcDaoImp =new ZcDaoImp();
		boolean flag = zcDaoImp.judge(user.getUserId());
		if(flag){
			this.addActionMessage("用户名已经存在！");
			return INPUT;
		}
		else if(user!=null)
		{
			imageFile="upload/tp.jpg";
			user.setUserImage(imageFile);
			zcDaoImp.addUser(user);
			return SUCCESS;
		}
		else {
			return INPUT;
		}
		
	}

}
