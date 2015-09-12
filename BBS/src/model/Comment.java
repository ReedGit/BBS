package model;

import java.sql.Timestamp;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Note note;
	private String commentContent;
	private User user;
	private Timestamp commentTime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Note note, String commentContent,
			User user, Timestamp commentTime) {
		this.note = note;
		this.commentContent = commentContent;
		this.user = user;
		this.commentTime = commentTime;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Note getNote() {
		return this.note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

}