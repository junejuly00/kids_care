package kr.ac.kopo.kidscare.model;

public class Comment {
	private Integer commentId;
	private String username;
	private Integer userPostId;
	private String substance;
	private Integer status;
	private String postDate;

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getUserPostId() {
		return userPostId;
	}

	public void setUserPostId(Integer userPostId) {
		this.userPostId = userPostId;
	}

	public String getSubstance() {
		return substance;
	}

	public void setSubstance(String substance) {
		this.substance = substance;
	}

}
