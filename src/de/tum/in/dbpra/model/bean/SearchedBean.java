package de.tum.in.dbpra.model.bean;

public class SearchedBean {
	private String search;
	private String column;
	private String like;
	private String bsl;
	
	/**
	 * @return the bsl
	 */
	public String getBsl() {
		return bsl;
	}

	/**
	 * @param bsl the bsl to set
	 */
	public void setBsl(String bsl) {
		this.bsl = bsl;
	}

	public SearchedBean() {}

	/**
	 * @return the column
	 */
	public String getColumn() {
		return column;
	}

	/**
	 * @param column the column to set
	 */
	public void setColumn(String column) {
		this.column = column;
	}

	/**
	 * @return the like
	 */
	public String getLike() {
		return like;
	}

	/**
	 * @param like the like to set
	 */
	public void setLike(String like) {
		this.like = like;
	}


	/**
	 * @return the s
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @param s the s to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}
	
	
}