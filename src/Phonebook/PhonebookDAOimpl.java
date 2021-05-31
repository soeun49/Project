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
			
			String sql="SELECT 	 "
		}
		
		return null;
	}

	@Override
	public List<PhonebookVO> search(String keyword) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		
		return null;
	}

	@Override
	public PhonebookVO get(Long id) {
		Connection conn=null;
		PreparedStatement pstmt= null;
		
		return null;
	}

	@Override
	public boolean insert(PhonebookVO vo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		return false;
	}

	@Override
	public boolean delte(Long id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		return false;
	}


	
	}

