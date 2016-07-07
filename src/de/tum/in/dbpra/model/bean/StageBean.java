package de.tum.in.dbpra.model.bean;

public class StageBean {
	private int stageID;
	private AreaBean isin;
	private String stageName;
	private int auditSize;
	private int stageSize;
	
	
	public StageBean() {}


	/**
	 * @return the stageID
	 */
	public int getStageID() {
		return stageID;
	}


	/**
	 * @param stageID the stageID to set
	 */
	public void setStageID(int stageID) {
		this.stageID = stageID;
	}


	/**
	 * @return the isin
	 */
	public AreaBean getIsin() {
		return isin;
	}


	/**
	 * @param isin the isin to set
	 */
	public void setIsin(AreaBean isin) {
		this.isin = isin;
	}


	/**
	 * @return the stageName
	 */
	public String getStageName() {
		return stageName;
	}


	/**
	 * @param stageName the stageName to set
	 */
	public void setStageName(String stageName) {
		this.stageName = stageName;
	}


	/**
	 * @return the auditSize
	 */
	public int getAuditSize() {
		return auditSize;
	}


	/**
	 * @param auditSize the auditSize to set
	 */
	public void setAuditSize(int auditSize) {
		this.auditSize = auditSize;
	}


	/**
	 * @return the stageSize
	 */
	public int getStageSize() {
		return stageSize;
	}


	/**
	 * @param stageSize the stageSize to set
	 */
	public void setStageSize(int stageSize) {
		this.stageSize = stageSize;
	}

	
}
