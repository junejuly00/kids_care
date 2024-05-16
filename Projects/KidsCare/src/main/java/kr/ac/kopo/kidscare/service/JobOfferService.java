package kr.ac.kopo.kidscare.service;

import java.util.List;

import kr.ac.kopo.kidscare.model.JobOffer;

public interface JobOfferService {

	List<JobOffer> list();

	void add(JobOffer offerInfo);

	JobOffer getOfferInfo(String offerid);

	void update(JobOffer offerInfo);

}
