package de.tum.in.dbpra.model.bean;

import java.util.Date;

public class NoteBean {
	private int noteID;
	private String content;
	private Date creationTime;
	private boolean done;
	private PersonListBean attachedto;
	
	public PersonListBean getAttachedto() {
		return attachedto;
	}

	public void setAttachedto(PersonListBean attachedto) {
		this.attachedto = attachedto;
	}

	public NoteBean() {}

	/**
	 * @return the noteID
	 */
	public int getNoteID() {
		return noteID;
	}

	/**
	 * @param noteID the noteID to set
	 */
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}

	/**
	 * @param done the done to set
	 */
	public void setDone(boolean done) {
		this.done = done;
	}
	
}
