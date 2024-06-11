package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.Reservation;

@Repository
public class ReservationDaoImpl implements ReservationDao {
	
	@Autowired
	SqlSession sql;
	
	@Override
	public List<Reservation> totalList() {
		
		return sql.selectList("reservation.totalList");
	}

	@Override
	public void add(Reservation rsvInfo) {
		sql.insert("reservation.add", rsvInfo);
	}

	@Override
	public Integer delete(Long resId) {
		// 이건 만들지 않아도 될 수도 있다
		return sql.delete("reservation.delete", resId);
	}

	@Override
	public List<Reservation> parentList(String username) {
		return sql.selectList("reservation.parent", username);
	}

	@Override
	public List<Reservation> parentPastList(String username) {
		return sql.selectList("reservation.pastparent", username);
	}

	@Override
	public Integer count(String sittername) {
		return sql.selectOne("reservation.count");
	}

	@Override
	public List<Reservation> sitterList(String sittername) {
		return sql.selectList("reservation.sitter", sittername);
	}

	@Override
	public List<Reservation> sitterPastList(String sittername) {
		return sql.selectList("reservation.pastsitter", sittername);
	}

}
