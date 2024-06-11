package kr.ac.kopo.kidscare.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.kidscare.model.BabySitter;
import kr.ac.kopo.kidscare.model.SitterAddress;
import kr.ac.kopo.kidscare.model.SitterPhoto;
import kr.ac.kopo.kidscare.pager.Pager;

@Repository
public class BabySitterDaoImpl implements BabySitterDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<BabySitter> list() {
		return sql.selectList("babysitter.list");
	}

	@Override
	public void add(BabySitter sitterInfo) {
		sql.insert("babysitter.add",sitterInfo);
	}

	@Override
	public BabySitter sitterInfo(String username) {
		return sql.selectOne("babysitter.item",username);
	}

	@Override
	public void update(BabySitter sitterInfo) {
		sql.update("babysitter.update",sitterInfo);
	}

	@Override
	public List<BabySitter> detail(String username) {
		return sql.selectList("babysitter.detail", username);
	}

	@Override
	public List<BabySitter> list(Pager pager) {
		switch (pager.getSearch()) {
		case 1:
			return sql.selectList("babysitter.salaryAscList", pager);
		case 2:
			return sql.selectList("babysitter.careerDescList", pager);
		default:
			return sql.selectList("babysitter.list", pager);
			
		}
		
	}

	@Override
	public void add(SitterPhoto sitterphoto) {
		sql.insert("babysitter.add_image", sitterphoto);
		
	}

	@Override
	public SitterAddress sitterAddressInfo(String username) {
		return sql.selectOne("sitteraddress.sitterAddressInfo", username);
	}

	@Override
	public void update(SitterAddress sitterAddressInfo) {
		sql.update("sitteraddress.sitterAddressUpdate", sitterAddressInfo);
		
	}

	@Override
	public SitterPhoto itemImage(Long code) {
		return sql.selectOne("babysitter.item_image", code);
	}

	@Override
	public int deleteImage(Long code) {
		return sql.delete("babysitter.delete_image", code);
	}

	@Override
	public void address(BabySitter sitterInfo) {
		sql.update("babysitter.update_address", sitterInfo);
		
	}

	@Override
	public void newAddr(BabySitter sitterInfo) {
		sql.insert("babysitter.new_address", sitterInfo);
		
	}

}
