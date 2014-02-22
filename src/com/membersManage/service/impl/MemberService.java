package com.membersManage.service.impl;

import java.util.List;

import com.membersManage.dao.IMemberDAO;
import com.membersManage.domain.Member;
import com.membersManage.service.IMemberService;

public class MemberService implements IMemberService {
	IMemberDAO memberDAO;
	@Override
	public List<Member> getAll() {
		return memberDAO.find("from Member a");
	}

	@Override
	public Member findById(Integer id) {
		return memberDAO.findById(id);
	}

	@Override
	public List<Member> find(String hql, Object[] objArray) {
		return memberDAO.find(hql, objArray);
	}

	@Override
	public Member save(Member member) throws Exception {
		try{
			memberDAO.save(member);
		}catch(Exception e){
			e.toString();
			throw new RuntimeException("save fail");
		}
		return member;
	}

	@Override
	public Member update(Member member) throws Exception {
		try{
			memberDAO.save(member);
		}catch(Exception e){
			throw new RuntimeException("update fail");
		}
		return member;
	}

	@Override
	public List<Member> saveOrUpdateAll(List<Member> list) throws Exception {
		return memberDAO.saveOrUpdateAll(list);
	}

	@Override
	public void delete(Member member) {
		try{
			memberDAO.delete(member);
		}catch(Exception e){
			throw new RuntimeException("delete fail");
		}
	}

	public IMemberDAO getMemberDAO() {
		return memberDAO;
	}

	public void setMemberDAO(IMemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

}
