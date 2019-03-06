package com.nyist.cn.model;

import java.io.Serializable;

public class Tree implements Serializable{
	private String id;
	private String name;
	private int lft;
	private int rgt;
	private int depth;
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
	public Tree(String id, String name, int lft, int rgt, int depth) {
		super();
		this.id = id;
		this.name = name;
		this.lft = lft;
		this.rgt = rgt;
		this.depth = depth;
	}
	protected Tree() {
		super();
	}
}
