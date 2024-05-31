package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.Notice;
import kr.ac.kopo.kidscare.model.NoticeFile;
import kr.ac.kopo.kidscare.pager.Pager;

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

	@Override
	public void hide(Integer code) {
		sql.update("notice.hide",code);
	}

	@Override
	public List<Notice> mypost(String username) {
		return sql.selectList("notice.mypost",username);
	}

	@Override
	public int total(Pager pager) {
		return sql.selectOne("notice.total",pager);
	}

	@Override
	public List<Notice> list(Pager pager) {
		return sql.selectList("notice.list",pager);
	}

	@Override
	public void add(NoticeFile noticefile) {
		sql.insert("notice.add_image", noticefile);
	}

	@Override
	public NoticeFile itemImage(Integer noticeId) {
		return sql.selectOne("notice.item_image", noticeId);
	}

	@Override
	public int deleteImage(Integer noticeId) {
		return sql.delete("notice.delete_image", noticeId);
	}

}
