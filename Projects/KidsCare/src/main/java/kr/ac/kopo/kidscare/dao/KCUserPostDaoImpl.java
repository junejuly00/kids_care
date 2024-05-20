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
		return sql.selectOne("kcuserpost.search",userPostId);
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
	public List<KcUserPost> mypost(String username) {
		
		return sql.selectList("kcuserpost.mypost", username);
	}

	@Override
	public void add(UserFile userFile) {
		sql.insert("kcuserpost.add_image", userFile);
	}

	@Override
	public void hide(Integer userPostId) {
		sql.update("kcuserpost.hide",userPostId);
	}

}
