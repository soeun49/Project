package Phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PhonebookDAOimpl implements PhonebookDAO {
	
	private Connection getConnection() throws SQLException {
		Connection conn =null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn=DriverManager.getConnection(dburl,"C##bituser", "bituser");
		}catch (ClassNotFoundException e) { 
			System.err.println("드라이버 로드 실패!");
		}
		return conn;
		}

	@Override
	public List<PhonebookVO> getlist() {
		Connection conn= null;
		Statement stmt= null;
		ResultSet rs= null;
		
		List <PhonebookVO> list=new ArrayList<>();
		
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			
			String sql="SELECT id,name,hp,tel FROM phone_book";
			rs=stmt.executeQuery(sql);
			
			while (rs.next()) {
				Long id=rs.getLong(1);
				String name=rs.getString(2);
				String mobile=rs.getString(3);
				String phonehome=rs.getString(4);
				
				PhonebookVO vo=new PhonebookVO(id,name,mobile,phonehome);
				list.add(vo);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try { 
				rs.close();
				stmt.close();
				conn.close();
				
			}catch (Exception e) {
				
			}
		}
		
		return list;
	}

	@Override
	public List<PhonebookVO> search(String keyword) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		List<PhonebookVO> list = new ArrayList<>();
		String sql= "SELECT * FROM phone_book "+
					" WHERE name LIKE ?";
		 
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword +"%");
			
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				Long id= rs.getLong("id");
				String name=rs.getString("name");
				String mobile=rs.getString("hp");
				String phonehome=rs.getString("tel");
				
				PhonebookVO vo=new PhonebookVO(id,name,mobile,phonehome);
				list.add(vo);
						
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch (Exception e) {
				
			}
		}
				
		return list;
	}

	@Override
	public PhonebookVO get(Long id) {
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		
		PhonebookVO vo=null;
		
		try {
			conn=getConnection();
			String sql = "SELECT id,name,hp,tel FROM phone_book WHERE id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				String name=rs.getString(2);
				String mobile=rs.getString(3);
				String phonehome=rs.getString(4);
				
				vo=new PhonebookVO(id,name,mobile,phonehome);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();			
			}catch (Exception e) {
				
			}
		}
				
		return vo;
	}

	@Override
	public boolean insert(PhonebookVO vo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int insertedCount=0;
		
		try {
			conn=getConnection();
			String sql="INSERT INTO phone_book VALUES (seq_phone_book_pk.NEXTVAL,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getMobile());
			pstmt.setString(3, vo.getPhonehome());
			
			insertedCount=pstmt.executeUpdate();
	
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
				
			}catch (Exception e) {
				
			}
		}
		
		return 1 == insertedCount;
	}

	@Override
	public boolean delete(Long id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int deletedCount=0;
		
		try {
			conn=getConnection();
			String sql="DELETE FROM phone_book WHERE id = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			
			deletedCount=pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				pstmt.close();
				conn.close();
				
			}catch (Exception e) {
				
			}
			
		}
		return 1==deletedCount;
	}


	
	}

