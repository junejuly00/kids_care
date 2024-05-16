package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.KcUserPost;
import kr.ac.kopo.kidscare.model.UserFile;

@Repository
public class KCUserPostDaoImpl implements KCUserPostDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public KcUserPost item(Integer userPostId) {
		return sql.selectOne("kcuserpost.userPostId",userPostId);
	}

	@Override
	public void add(KcUserPost item) {
		sql.insert("kcuserpost.add",item);
	}

	@Override
	public void update(KcUserPost item) {
		sql.update("kcuserpost.update",item);
	}

	@Override
	public List<KcUserPost> list() {
		return sql.selectList("kcuserpost.list");
	}

	@Override
	public void add(UserFile userFile) {
		sql.insert("kcuserpost.add_image", userFile);
		
	}

}
