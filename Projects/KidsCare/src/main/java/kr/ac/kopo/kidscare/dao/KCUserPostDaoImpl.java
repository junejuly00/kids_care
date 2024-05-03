package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.KcUserPost;

@Repository
public class KCUserPostDaoImpl implements KCUserPostDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public KcUserPost item(Integer userPostId) {
		return sql.selectOne("mapper.kcuserpost.userPostId",userPostId);
	}

	@Override
	public void add(KcUserPost item) {
		sql.insert("mapper.kcuserpost.add",item);
	}

	@Override
	public void update(KcUserPost item) {
		sql.update("mapper.kcuserpost.update",item);
	}

	@Override
	public List<KcUserPost> list() {
		return sql.selectList("mapper.kcuserpost.list");
	}

}
