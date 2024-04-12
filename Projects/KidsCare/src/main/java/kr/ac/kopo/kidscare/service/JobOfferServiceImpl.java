package kr.ac.kopo.kidscare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.kidscare.dao.JobOfferDao;
import kr.ac.kopo.kidscare.model.JobOffer;

@Service
public class JobOfferServiceImpl implements JobOfferService {

	@Autowired
	JobOfferDao dao;
	
	@Override
	public List<JobOffer> list() {
		return dao.list();
	}

	@Override
	public void add(JobOffer item) {
		dao.add(item);
	}

	@Override
	public JobOffer item(String offerId) {
		return dao.item(offerId);
	}

	@Override
	public void update(JobOffer item) {
		dao.update(item);
	}

}
