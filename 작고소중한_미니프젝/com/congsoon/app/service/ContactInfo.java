package com.congsoon.app.service;

import java.sql.Date;

/************************************************
 * getter, setter 를 통해 오라클 테이블의 데이터를 관리해주는 클래스 
 * ***********************************************/
public class ContactInfo {
	private int		 info_num         	= 0;
    private String info_name      	= "";
    private String info_tel        		= "";
    private String info_email      	= "";
    private String info_relation    	= "";
    private String info_loc         	= "";
    private String info_gender		="";
	private String info_memo       	= "";
    private Date info_regdate		= null;
 
    
    public ContactInfo() {
    }
    // 조회에 사용할 생성자 
    public ContactInfo (int info_num,String info_name) {
    	this.info_num = info_num;
    	this.info_name = info_name;
    }
    
    public ContactInfo (int info_num, String info_name, String info_tel, String info_email, String info_relation,
			String info_loc, String info_gender, String info_memo, Date info_regdate) {
	
			this.info_num = info_num;
			this.info_name = info_name;
			this.info_tel = info_tel;
			this.info_email = info_email;
			this.info_relation = info_relation;
			this.info_loc = info_loc;
			this.info_gender = info_gender;
			this.info_memo = info_memo;
			this.info_regdate = info_regdate;
		
		
	}

//    public ContactIInfo(
//    		int info_num,
//    	    String info_name,
//    	    String info_tel,
//    	    String info_email,
//    	    String info_relation,
//    	    String info_loc,
//    	    String info_memo,
//    	    Date info_regdate,
//    	    int owner_no) {
//										    
//										    	this.info_num = info_num;
//										    	this.info_name = info_name;
//										    	this.info_tel = info_tel;
//										    	this.info_email = info_email;
//										    	this.info_relation = info_relation;
//										    	this.info_loc = info_loc;
//										    	this.info_memo = info_memo;
//										    	this.owner_no = owner_no;
//									}
    
    
	public int getInfo_num() {
		return info_num;
	}
	public String getInfo_name() {
		return info_name;
	}
	public String getInfo_tel() {
		return info_tel;
	}
	public String getInfo_email() {
		return info_email;
	}
	public String getInfo_relation() {
		return info_relation;
	}
	public String getInfo_loc() {
		return info_loc;
	}
	 public String getInfo_gender() {
			return info_gender;
	}
	public String getInfo_memo() {
		return info_memo;
	}
	public Date getInfo_regdate() {
		return info_regdate;
	}
	
	public void setInfo_num(int info_num) {
		this.info_num = info_num;
	}
	public void setInfo_name(String info_name) {
		this.info_name = info_name;
	}
	public void setInfo_tel(String info_tel) {
		this.info_tel = info_tel;
	}
	public void setInfo_email(String info_email) {
		this.info_email = info_email;
	}
	public void setInfo_relation(String info_relation) {
		this.info_relation = info_relation;
	}
	public void setInfo_loc(String info_loc) {
		this.info_loc = info_loc;
	}
	public void setInfo_gender(String info_gender) {
		this.info_gender = info_gender;
	}
	public void setInfo_memo(String info_memo) {
		this.info_memo = info_memo;
	}
	public void setInfo_regdate(Date info_regdate) {
		this.info_regdate = info_regdate;
	}
    
    
}
