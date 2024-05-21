package kr.ac.kopo.kidscare.pager;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int page = 1;
	private int perPage = 2;
	private float total;
	private int perGroup = 1;
	
	private int next;
	private int last;
	private int prev;
	private List<Integer> list;

	public void setNext(int next) {
		this.next = next;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getPerGroup() {
		return perGroup;
	}

	public void setPerGroup(int perGroup) {
		this.perGroup = perGroup;
	}
	
	public int getLast() {
		last = (int) Math.ceil(total / perPage);
		
		return last; 
	}
	
	public List<Integer> getList() {
		list = new ArrayList<>();
		
		int startPage = (((page - 1) / perGroup) + 0) * perGroup + 1;
		
		for(int i=startPage; i < (startPage + perGroup) && i <= getLast(); i++)
			list.add(i);
		
		if(list.isEmpty())
			list.add(1);
		
		return list;
	}
	
	public int getPrev() {
		prev = page <= perGroup ? 1 : (((page - 1) / perGroup) - 1) * perGroup + 1;
		
		return prev;
	}
	
	public int getNext() {
		next = (((page - 1) / perGroup) + 1) * perGroup + 1;
		int last = getLast();
		
		next = next < last ? next : last;
		
		return next;
	}

}
