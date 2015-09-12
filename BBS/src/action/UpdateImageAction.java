package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.User;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.imp.UserDaoImp;

public class UpdateImageAction extends ActionSupport {

	private String userImage;
	private File file;
	private String fileFileName;

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		String lastString=fileFileName.substring(fileFileName.lastIndexOf(".")).toLowerCase();
/*		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		*/
		String root1="D:/Windows8.1/apache-tomcat-8.0.21/webapps/BBS/upload";
		String root="F:/myeclipse/BBS/WebRoot/upload";
		InputStream is;
		OutputStream os;
		OutputStream os1;
		try {
			is = new FileInputStream(file);
			os = new FileOutputStream(new File(root, user.getUserId()+lastString));
			os1 = new FileOutputStream(new File(root1, user.getUserId()+lastString));
			byte[] buffer = new byte[500];
			int length = 0;
			while (-1 != (length = is.read(buffer, 0, buffer.length))) {
				os.write(buffer);
				os1.write(buffer);
			}
			os.flush();
			os1.flush();
			os1.close();
			os.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		userImage="upload/"+user.getUserId()+lastString.toLowerCase();
		user.setUserImage(userImage);
		UserDaoImp userDaoImp = new UserDaoImp();
		userDaoImp.updateUser(user);
		return SUCCESS;
	}



}
