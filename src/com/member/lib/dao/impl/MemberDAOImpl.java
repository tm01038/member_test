package com.member.lib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO {

	private static Connection conn = null;
	private static PreparedStatement ps = null;

	public int insertMember(Map<String, Object> member) {

		int result = 0;
		if (conn == null) {
			String sql = "insert into member(m_num,m_name,m_id,m_pw,m_credate)\r\n" + "values(\r\n"
					+ "SEQ_MEMBER_M_NUM.nextval,?,?,?,sysdate\r\n" + ")";

			conn = Connector.open();
			try {

				ps = conn.prepareStatement(sql);
				ps.setString(1, member.get("m_name").toString());
				ps.setString(2, member.get("m_id").toString());
				ps.setString(3, member.get("m_pw").toString());
				result = ps.executeUpdate();
				return result;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				ps = null;
				conn = null;
			}
		}
		return 0;
	}

	public int updateMember(Map<String, Object> member) {
		int result = 0;
		if (conn == null) {
			String sql = "update member set m_name =?,m_id =?,m_pw =? where m_num = ?";

			conn = Connector.open();
			try {

				ps = conn.prepareStatement(sql);
				ps.setString(1, member.get("m_name").toString());
				ps.setString(2, member.get("m_id").toString());
				ps.setString(3, member.get("m_pw").toString());
				ps.setInt(4, (int) member.get("m_num"));
				result = ps.executeUpdate();
				return result;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				ps = null;
				conn = null;
			}
		}
		return 0;
	}

	public int deleteMember(int mNum) {
		int result = 0;
		if (conn == null) {
			String sql = "delete from member where m_num=?";

			conn = Connector.open();
			try {

				ps = conn.prepareStatement(sql);
				ps.setInt(1, mNum);
				result = ps.executeUpdate();
				return result;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				ps = null;
				conn = null;
			}
		}
		return 0;
	}

	public List<Map<String, Object>> selectMemberList(Map<String, Object> member) {
		List<Map<String, Object>> listMember = new ArrayList<Map<String, Object>>();
		ResultSet rs = null;
		if (conn == null) {
			String sql = "select *from member";

			conn = Connector.open();
			try {

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Map<String, Object> rMap = new HashMap<>();
					rMap.put("m_num", rs.getInt("m_num"));
					rMap.put("m_id", rs.getString("m_id"));
					rMap.put("m_name", rs.getString("m_name"));
					rMap.put("m_pw", rs.getString("m_pw"));
					rMap.put("m_credate", rs.getString("m_credate"));
					listMember.add(rMap);
				}

				return listMember;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				ps = null;
				conn = null;
			}
		}
		return null;
	}

	public Map<String, Object> selectMember(int mNum) {

		Map<String, Object> rMap = new HashMap<>();		
		conn = Connector.open();
		ResultSet rs =null;
		try {
			String sql = "SELECT *FROM MEMBER WHERE m_num=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mNum);
			rs = ps.executeQuery();
			rs.next();
			rMap.put("m_num",rs.getInt("m_num"));
			rMap.put("m_name",rs.getString("m_name"));
			rMap.put("m_id",rs.getString("m_id"));
			rMap.put("m_pw",rs.getString("m_pw"));
			rMap.put("m_credate",rs.getString("m_credate"));
			
			return rMap;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ps = null;
			conn = null;
		}
		return null;

	}

}
