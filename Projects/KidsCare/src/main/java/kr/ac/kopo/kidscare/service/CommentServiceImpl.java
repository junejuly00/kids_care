package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.CommentDao;
import kr.ac.kopo.kidscare.model.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentDao dao;

	@Override
	public List<Comment> list() {
		return dao.list();
	}

	@Override
	public void add(Comment commentInfo) {
		dao.add(commentInfo);
	}

	@Override
	public Comment CommentInfo(Integer commentId) {
		return dao.commentInfo(commentId);
	}

	@Override
	public void update(Comment commentInfo) {
		dao.update(commentInfo);
	}

	@Override
	public List<Comment> filter(Integer userPostId) {
		return dao.filter(userPostId);
	}

}
