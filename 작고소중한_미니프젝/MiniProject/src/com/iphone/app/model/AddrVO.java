package com.iphone.app.model;

import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/************************************************
 * getter, setter 를 통해 오라클 테이블의 데이터를 관리해주는 클래스 
 * ***********************************************/
public class AddrVO  {
	private int		 id         			= 0;
    private String name      			= "";
    private String address        		= "";
    private String telephone      	= "";
    private String gender    			= "";
    private String relationship       = "";
    private String birthday			= "";
	private String comments       	= "";
    private Date 	registedate		= null;
 
    
    public AddrVO() {
    }
    
    // 새로고침에 사용할 생성자 
    public AddrVO (int id, String name) {
    	this.id = id;
    	this.name = name;
    }
    
    // 상세조회에 사용할 생성자 
	public AddrVO(String name, String address, String telephone, String gender, String relationship,
			String birthday, String comments) {
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.gender = gender;
		this.relationship = relationship;
		this.birthday = birthday;
		this.comments = comments;
	}
	
	// 수정에 사용할 생성자  
	public AddrVO(int id, String name, String address, String telephone, String gender, String relationship,
			String birthday, String comments) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.gender = gender;
		this.relationship = relationship;
		this.birthday = birthday;
		this.comments = comments;
	}
	
	public AddrVO(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getRegistedate() {
		return registedate;
	}

	public void setRegistedate(Date registedate) {
		this.registedate = registedate;
	}

}