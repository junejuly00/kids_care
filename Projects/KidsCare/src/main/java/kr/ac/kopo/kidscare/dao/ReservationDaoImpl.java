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
	public Integer add(Reservation rsvInfo) {
		return sql.insert("reservation.add", rsvInfo);
	}

	@Override
	public Integer delete(Long resId) {
		// 이건 만들지 않아도 될 수도 있다
		return sql.delete("reservation.delete", resId);
	}

}
