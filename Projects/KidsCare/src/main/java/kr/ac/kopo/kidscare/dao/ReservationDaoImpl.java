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
		
		return sql.selectList("mapper.reservation.totalList");
	}

}
