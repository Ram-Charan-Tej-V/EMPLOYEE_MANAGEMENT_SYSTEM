package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Employee;

public class DataAccess {
	
	public void delete(int id)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","admin@2002");
			ps = con.prepareStatement("delete from employee where eno = ?");
			ps.setInt(1,id); 
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
		finally {
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void update (Employee em)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","admin@2002");
			ps = con.prepareStatement("update employee set ename = ?, email = ?, pw = ?, mobile = ? where eno = ?");
			ps.setString(1, em.getName());
			ps.setString(2, em.getEmail());
			ps.setString(3, em.getPassword());
			ps.setLong(4, em.getMobile());
			ps.setInt(5, em.getId());
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
		finally {
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Employee getEmployeeById(int id)
	{
		Employee em = new Employee();
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","admin@2002");
			ps = con.prepareStatement("select * from employee where eno = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				em.setId(id);
				em.setName(rs.getString("ename"));
				em.setEmail(rs.getString("email"));
				em.setPassword(rs.getString("pw"));
				em.setMobile(rs.getLong("mobile"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return em;
	}
	
	public void insert(Employee em) 
	{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","admin@2002");
			ps = con.prepareStatement("insert into employee(ename,email,pw,mobile) values(?,?,?,?)");
			ps.setString(1, em.getName());
			ps.setString(2, em.getEmail());
			ps.setString(3, em.getPassword());
			ps.setLong(4, em.getMobile());
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
		finally {
			if(ps != null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public ArrayList<Employee> getAllEmployees()
	{
		ArrayList<Employee> alEmps = new ArrayList<Employee>();
		
		Connection con = null;
		Statement s = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","admin@2002");

			s = con.createStatement();
			
			ResultSet rs = s.executeQuery("select * from employee");
			
			while(rs.next())
			{
				int i = rs.getInt("eno");
				String n = rs.getString("ename");
				String e = rs.getString("email");
				String p = rs.getString("pw");
				long m = rs.getLong("mobile");
				
				Employee empl = new Employee(i,n,e,p,m);
				
				alEmps.add(empl);
			}
		} 
		catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
		finally {
			if(s != null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return alEmps;
		
	}
}
