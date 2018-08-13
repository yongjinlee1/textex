package org.stu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.stu.dto.MemberDto;

public class MemberDao {

	private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "admin";
	private static final String PW ="1111";

	
	
	
	
	
	public Connection getconnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(URL, USER, PW);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	// 회원정보를 받아 member table 에 해당 정보를 저장
	public boolean insertMember(MemberDto dto) {
		
		
		Connection conn = getconnection();
		PreparedStatement pr =null;
		int result;
		if (conn != null && dto != null) {
			
			String sql ="insert into member (id,name,dob,email) values(?,?,?,?)"; 
			
			
			try {
				pr = conn.prepareStatement(sql);
				pr.setString(1, dto.getId());
				pr.setString(2, dto.getName());
				pr.setDate(3, dto.getDob());
				pr.setString(4, dto.getEmail());
				
				 result = pr.executeUpdate();
				
				 if (result != 0) {
					return true;
				}
				 else {
					 
					 return false;
				 }
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				
				if (pr != null) {
					try {
						pr.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		}
		return false;
		
		
	}
	
	
	public int idcheck(String id) {
		Connection conn = getconnection();
		PreparedStatement pr = null;
		ResultSet rs = null;
		
		
		if (conn != null) {
			
			String sql = "select id from MEMBER where ID = ?";
			
			try {
				pr = conn.prepareStatement(sql);
				
				pr.setString(1, id);
				
				rs = pr.executeQuery();
				
				if (rs.next()) {
					return 0;
				}else {
					
					return 1;
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (pr != null) {
					try {
						pr.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		return 0;
	}
	
	
	public MemberDto[] memberlist() {
		Connection conn = getconnection();
		PreparedStatement pr = null;
		ResultSet rs = null;
		List<MemberDto> list = new ArrayList<>();
		
		if (conn != null) {
			
			String sql = "select id , name ,dob ,email from member";
			
			try {
				pr = conn.prepareStatement(sql);
				 rs = pr.executeQuery();
				 
				 while (rs.next()) {
					 MemberDto dto = new MemberDto();
					 dto.setId(rs.getString(1)); 
					 dto.setName(rs.getString(2));
					 dto.setDob(rs.getDate(3));
					 dto.setEmail(rs.getString(4));
					 
					 list.add(dto); 
				}
				 
				 return list.toArray(new MemberDto[0]);
				 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (pr != null) {
					try {
						pr.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
		
		
		
		
		return null;
	}

	
	public boolean memberupdate(MemberDto dto)
	{
		Connection conn = getconnection();
		
		PreparedStatement pr = null;
		int result = 0;
		
		if (conn != null) {
			
			String sql ="update member set name =?,dob = ?,EMAIL =? where id = ?";
			
		
			try {
				pr = conn.prepareStatement(sql);
				pr.setString(1, dto.getName());
				pr.setDate(2, dto.getDob());
				pr.setString(3, dto.getEmail());
				pr.setString(4, dto.getId());
				result = pr.executeUpdate();
				
				if (result == 0) {
					return false;
				}else {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (pr != null) {
					try {
						pr.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
			
		}
		
		
		
		return false;
	}
	
	public MemberDto selectid(String id) {
	
		Connection conn = getconnection();
		PreparedStatement pr = null;
		ResultSet rs = null;
		MemberDto dto = new MemberDto();
		if (conn != null) {
			String sql ="select id ,name,dob,email from member where id =?";
			
			try {
				pr = conn.prepareStatement(sql);
				pr.setString(1, id);
				rs = pr.executeQuery();
				
				if (rs.next()) {
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setDob(rs.getDate(3));
				dto.setEmail(rs.getString(4));	
				}
				return dto;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (pr != null) {
					try {
						pr.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			
		}
		
		
		
		return null;
	}
	
	
}
