package com.membersManage.service;

import java.util.List;

import com.membersManage.domain.Member;

public interface IMemberService {
	public List<Member> getAll();
	public Member findById( Integer id);
	public List<Member> find( String hql,Object[] objArray );
	public Member save( Member member )throws Exception;
	public Member update( Member member )throws Exception;
	public List<Member> saveOrUpdateAll( List<Member> list )throws Exception;
	public void delete( Member member );
}
