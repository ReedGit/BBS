package model;

import java.sql.Timestamp;

/**
 * Note entity. @author MyEclipse Persistence Tools
 */

public class Note implements java.io.Serializable {

	// Fields

	private Integer noteId;
	private String noteTitle;
	private String noteContent;
	private User user;
	private Timestamp noteTime;
	private String noteClassify;

	// Constructors

	/** default constructor */
	public Note() {
	}

	/** full constructor */
	public Note(Integer noteId, String noteTitle, String noteContent,
			User user, Timestamp noteTime, String noteClassify) {
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.user = user;
		this.noteTime = noteTime;
		this.noteClassify = noteClassify;
	}


	public Integer getNoteId() {
		return this.noteId;
	}

	public void setNoteId(Integer noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return this.noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return this.noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getNoteTime() {
		return this.noteTime;
	}

	public void setNoteTime(Timestamp noteTime) {
		this.noteTime = noteTime;
	}

	public String getNoteClassify() {
		return this.noteClassify;
	}

	public void setNoteClassify(String noteClassify) {
		this.noteClassify = noteClassify;
	}

}