package cn.itcast.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private String id;
	private String name;
	private int lft;
	private int rgt;
	private int depth;
	
	private List parents = new ArrayList();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLft() {
		return lft;
	}

	public void setLft(int lft) {
		this.lft = lft;
	}

	public int getRgt() {
		return rgt;
	}

	public void setRgt(int rgt) {
		this.rgt = rgt;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public List getParents() {
		return parents;
	}

	public void setParents(List parents) {
		this.parents = parents;
	}
	
	
	
	
	
}
