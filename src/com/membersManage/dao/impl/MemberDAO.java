package com.membersManage.dao.impl;

import com.membersManage.dao.BaseAbstractDAO;
import com.membersManage.dao.IMemberDAO;
import com.membersManage.domain.Member;

public class MemberDAO extends BaseAbstractDAO<Member, Integer> implements
IMemberDAO {

	public MemberDAO() {
		super(Member.class);
	}
}
