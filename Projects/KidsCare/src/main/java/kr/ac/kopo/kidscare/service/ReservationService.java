package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.Reservation;

public interface ReservationService {

	List<Reservation> totalList();

	void add(Reservation rsvInfo);

	Integer delete(Long resId);

	List<Reservation> parentList(String username);

	List<Reservation> parentPastList(String username);

	Integer count(String sittername);

	List<Reservation> sitterList(String sittername);

	List<Reservation> sitterPastList(String sittername);

}
