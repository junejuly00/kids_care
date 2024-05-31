package kr.ac.kopo.kidscare.dao;

import java.util.List;

import kr.ac.kopo.kidscare.model.Reservation;

public interface ReservationDao {

	List<Reservation> totalList();

	void add(Reservation rsvInfo);

	Integer delete(Long resId);

	List<Reservation> parentList(String username);

}
