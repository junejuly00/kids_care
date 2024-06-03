package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.Comment;

public interface CommentDao {

	List<Comment> list();

	void add(Comment commentInfo);

	void update(Comment commentInfo);

	Comment commentInfo(Integer commentId);

	List<Comment> filter(Integer userPostId);

	List<Comment> userComment(String username);



}
