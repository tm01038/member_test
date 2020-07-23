package com.member.lib.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.lib.service.MemberService;
import com.member.lib.service.impl.MemberServiceImpl;

public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberServiceImpl();
	

	Map<String, Object> mapToMap(Map<String, String[]> map){
		Iterator<String> it = map.keySet().iterator();
		Map<String, Object> rMap = new HashMap<>();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key)[0];
			rMap.put(key,value);
		}
		return rMap;
	}
	
	
	protected void doProcess(HttpServletResponse response, String str) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(str);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String str = "";
		List<Map<String, Object>> memberList = new ArrayList<>();
		if("/member/list".equals(uri)) {
			memberList = memberService.selectMemberList(null);
			request.setAttribute("memberList", memberList);
			RequestDispatcher rd = request.getRequestDispatcher("/views/member/member-list");
			rd.forward(request, response);
		}else if("/member/view".equals(uri)) {
			String m_num = request.getParameter("m_num");
			if(m_num==null ||"".equals(m_num.trim())) {
				throw new ServletException("안됩나다");
			}
			int mNum = Integer.parseInt(m_num);
			Map<String, Object> member = memberService.selectMember(mNum);
			request.setAttribute("member", member);

			RequestDispatcher rd = request.getRequestDispatcher("/views/member/member-view");
			rd.forward(request, response);
			return;
		}else {
			str="잘못들어갔어 새꺄";
		}
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		if("/member/insert".equals(uri)) {
			memberService.insertMember(mapToMap(request.getParameterMap()));
		}
		if("/member/update".equals(uri)) {
			memberService.updateMember(mapToMap(request.getParameterMap()));
		}
		if("/member/delete".equals(uri)) {
			memberService.deleteMember(Integer.parseInt(request.getParameter("m_num")));
		}
		
	}
	
}
