package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.Notice;

@Repository
public class NoticeDaoImpl implements NoticeDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Notice> list() {
		return sql.selectList("notice.list");
	}

	@Override
	public void add(Notice item) {
		sql.insert("notice.add", item);

	}

	@Override
	public Notice item(Integer code) {
		return sql.selectOne("notice.item", code);
	}

	@Override
	public void update(Notice item) {
		sql.update("notice.update", item);

	}

}
