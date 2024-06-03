package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.Comment;

public interface CommentService {

	List<Comment> list();

	void add(Comment commentInfo);

	void update(Comment commentInfo);

	Comment CommentInfo(Integer commentId);


	List<Comment> filter(Integer userPostId);

	List<Comment> userComment(String username);

}
