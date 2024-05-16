package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.Reservation;

public interface ReservationService {

	List<Reservation> totalList();

	Integer add(Reservation rsvInfo);

	Integer delete(Long resId);

}
