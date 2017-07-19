package com.ls.ltc.security.data;

import java.util.Arrays;
import java.util.List;

public class User {

	private int id;
	private String userid;
	private String role;
	private List<Integer> permissions = Arrays.asList(1, 2, 3);
	
	public User(int id, String userid, String role) {
		super();
		this.id = id;
		this.userid = userid;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Integer> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Integer> permissions) {
		this.permissions = permissions;
	}


}
