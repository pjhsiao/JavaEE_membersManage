package com.membersManage.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.JsonDeserializer;
@Entity
@Table(name="member")
public class Member implements Serializable{
	private Integer mdSno;
	private String loginAccEMail;
	private String loginPwd;
	private String memberName;
	private String memberID;
	private Boolean memberSex;
	private Date memberBirthday;
	private String memberTel;
	private String memberMobilePhone;
	private String memberAddress;

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getMdSno() {
		return mdSno;
	}
	public void setMdSno(Integer mdSno) {
		this.mdSno = mdSno;
	}
	@Column(nullable=false)
	public String getLoginAccEMail() {
		return loginAccEMail;
	}
	public void setLoginAccEMail(String loginAccEMail) {
		this.loginAccEMail = loginAccEMail;
	}
	@Column(nullable=false)
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	@Column(nullable=false)
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Column(nullable=false)
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public Boolean getMemberSex() {
		return memberSex;
	}
	public void setMemberSex(Boolean memberSex) {
		this.memberSex = memberSex;
	}
	public Date getMemberBirthday() {
		return memberBirthday;
	}
	public void setMemberBirthday(Date memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberMobilePhone() {
		return memberMobilePhone;
	}
	public void setMemberMobilePhone(String memberMobilePhone) {
		this.memberMobilePhone = memberMobilePhone;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	@Override
	public String toString() {
		return "Member [loginAccEMail=" + loginAccEMail + ", loginPwd="
				+ loginPwd + ", memberName=" + memberName + ", memberID="
				+ memberID + ", memberSex=" + memberSex + ", memberBirthday="
				+ memberBirthday + ", memberTel=" + memberTel
				+ ", memberMobilePhone=" + memberMobilePhone
				+ ", memberAddress=" + memberAddress + "]";
	}

	
}
