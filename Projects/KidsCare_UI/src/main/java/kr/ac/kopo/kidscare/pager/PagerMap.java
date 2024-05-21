package kr.ac.kopo.kidscare.pager;

import java.util.List;

public class PagerMap<T> {
	private List<T> list;
	private Pager pager;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

}
