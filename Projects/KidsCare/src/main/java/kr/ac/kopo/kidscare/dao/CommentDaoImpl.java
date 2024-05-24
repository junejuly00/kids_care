package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.Comment;


@Repository
public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Comment> list() {
		return sql.selectList("comment.list");
	}

	@Override
	public void add(Comment commentInfo) {
		sql.insert("comment.add",commentInfo);
	}

	@Override
	public Comment commentInfo(Integer commentId) {
		return sql.selectOne("comment.item",commentId);
	}

	@Override
	public void update(Comment commentInfo) {
		sql.update("comment.update",commentInfo);
	}

	@Override
	public List<Comment> filter(Integer userPostId) {
		return sql.selectList("comment.filter",userPostId);
	}

}
