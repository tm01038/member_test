package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.MemberDAO;
import com.member.lib.dao.impl.MemberDAOImpl;
import com.member.lib.service.MemberService;

public class MemberServiceImpl implements MemberService {

	private MemberDAO memberDAO = new MemberDAOImpl();

	public Map<String, Object> insertMember(Map<String, Object> member) {
		Map<String, Object> rMap = new HashMap<>();
		int result = memberDAO.insertMember(member);
		rMap.put("msg : ", "성공");
		if(result == 0) {
			rMap.put("msg : ", "실패");
		}
		rMap.put("result", result);
		return rMap;
	}

	public Map<String, Object> updateMember(Map<String, Object> member) {
		Map<String, Object> rMap = new HashMap<>();
		int result = memberDAO.updateMember(member);
		rMap.put("msg : ", "성공");
		if(result == 0) {
			rMap.put("msg : ", "실패");
		}
		rMap.put("result", result);
		return rMap;
	}

	public Map<String, Object> deleteMember(int mNum) {
		Map<String, Object> rMap = new HashMap<>();
		int result = memberDAO.deleteMember(mNum);
		rMap.put("msg : ", "성공");
		if(result == 0) {
			rMap.put("msg : ", "실패");
		}
		rMap.put("result", result);
		return rMap;
	}

	public List<Map<String, Object>> selectMemberList(Map<String, Object> member) {
		Map<String, Object> rMap = new HashMap<>();
		return memberDAO.selectMemberList(rMap);
	}

	public Map<String, Object> selectMember(int mNum) {
		return memberDAO.selectMember(mNum);
	}

}
