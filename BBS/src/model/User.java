package model;


/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String userId;
	private String userPassword;
	private String userImage;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId, String userPassword) {
		this.userId = userId;
		this.userPassword = userPassword;
	}

	/** full constructor */
	public User(String userId, String userPassword, String userImage) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userImage = userImage;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserImage() {
		return this.userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

}