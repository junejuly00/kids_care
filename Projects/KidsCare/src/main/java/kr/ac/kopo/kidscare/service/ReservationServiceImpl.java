package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.ReservationDao;
import kr.ac.kopo.kidscare.model.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservationDao dao;

	@Override
	public List<Reservation> totalList() {
		return dao.totalList();
	}

	@Override
	public void add(Reservation rsvInfo) {
		dao.add(rsvInfo);
	}

	@Override
	public Integer delete(Long resId) {
		return dao.delete(resId);
	}

	@Override
	public List<Reservation> parentList(String username) {
		return dao.parentList(username);
	}

	@Override
	public List<Reservation> parentPastList(String username) {
		return dao.parentPastList(username);
	}

	@Override
	public Integer count(String sittername) {
		return dao.count(sittername);
	}

}
