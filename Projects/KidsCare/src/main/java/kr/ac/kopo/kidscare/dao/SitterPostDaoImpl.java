package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.SitterPost;

@Repository
public class SitterPostDaoImpl implements SitterPostDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<SitterPost> list() {
		return sql.selectList("mapper.sitterpost.list");
	}

	@Override
	public void add(SitterPost item) {
		sql.insert("mapper.sitterpost.add",item);
	}

	@Override
	public SitterPost item(Integer sitterpostid) {
		return sql.selectOne("mapper.sitterpost.sitterpostid",sitterpostid);
	}

	@Override
	public void update(SitterPost item) {
		sql.update("mapper.sitterpost.update",item);
	}

}
