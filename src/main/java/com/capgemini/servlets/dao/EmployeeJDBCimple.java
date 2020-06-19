package com.capgemini.servlets.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.servlets.dto.EmployeeInfoBeans;

public class EmployeeJDBCimple implements EmployeeDAO {
	EmployeeInfoBeans bean = new EmployeeInfoBeans();

	@Override
	public EmployeeInfoBeans getEmployeeDetailsById(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// load the driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// get db connection via Driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false", "aparna", "route");

			// issue the sql query via connection
			stmt = conn.prepareStatement("select * from employeeinfo where id = ?");

			// set parameters
			stmt.setInt(1, id);

			// process the result "returned by sql queries"
			rs = stmt.executeQuery();

			if (rs.next()) {
				bean.setId(rs.getInt("eid"));
				bean.setName(rs.getString("name"));
				bean.setAge(rs.getInt("age"));
				bean.setSalary(rs.getInt("salary"));
				bean.setDesignation(rs.getString("designation"));
			} else {
				System.out.println("Employee details not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// close connection
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return bean;
	}

	@Override
	public boolean deleteEmployeeInfo(int id) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try { 
			//load the driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//get db connection via Driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","root","root");
			
			//issue the sql query via connection
			stmt = conn.prepareStatement("delete from employeeinfo where id = ?");
			
			//set parameters
			stmt.setInt(1,id);
			
			//process the result "returned by sql queries"
			int rowsAffected= stmt.executeUpdate();
			
			if(rowsAffected != 0) {
				return true;
			
			} else {
				return false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close connection
		finally {
			try {
				if(conn != null) {
				conn.close();
				} 
				if(stmt != null) {
				stmt.close();
				}
				if(rs != null) {
				rs.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		
		}
		return false;
	}


	@Override
	public boolean updateEmployeeInfo(EmployeeInfoBeans bean) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try { 
			//load the driver
			String query = "update employees set name=? where id=?";	
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false","aparna","route");
				stmt = conn.prepareStatement(query);
				stmt.setString(1, bean.getName());
				stmt.setInt(2, bean.getId());
				 int rowsAffected= stmt.executeUpdate();
				if (rowsAffected != 0) {
					return true;
				} else {
					return false;
				}
			} catch(Exception e) {
				e.printStackTrace();
		    }
		//close connection
			finally {
				try {
					if(conn != null) {
						conn.close();
					} 
					if(stmt != null) {
						stmt.close();
					}
					if(rs != null) {
						rs.close();
					}	
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		return false;
	}

	@Override
	public boolean createEmployeeInfo(EmployeeInfoBeans bean) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			// load the driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// get db connection via Driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false", "aparna", "route");

			// issue the sql query via connection
			stmt = conn.prepareStatement("insert into employeeinfo(id,name) values (?,?)");

			// set parameters
			stmt.setInt(1, bean.getId());
			stmt.setString(2, bean.getName());

			// process the result "returned by sql queries"
			int rowsaffected = stmt.executeUpdate();
			if (rowsaffected != 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// close connection
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}

	@Override
	public List<EmployeeInfoBeans> getAllEmployeeDetail() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// load the driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// get db connection via Driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false", "aparna", "route");

			// issue the sql query via connection
			stmt = conn.createStatement();

			// process the result "returned by sql queries"
			rs = stmt.executeQuery("select * from employeeinfo");
			List<EmployeeInfoBeans> list = new ArrayList<EmployeeInfoBeans>();
			while (rs.next()) {
				EmployeeInfoBeans beans = new EmployeeInfoBeans();
				beans.setId(rs.getInt("id"));
				beans.setName(rs.getString("name"));
				beans.setSalary(rs.getDouble("salary"));
				beans.setDesignation("designation");
				beans.setPassword("password");
				list.add(beans);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// close connection
		finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	@Override
	public EmployeeInfoBeans authentication(int id, String password) {
		// TODO Auto-generated method stub
		EmployeeInfoBeans employeeInfoBean = getEmployeeDetailsById(id);
	if(!(employeeInfoBean !=null && employeeInfoBean.getPassword().equals(password))) {
		  employeeInfoBean = null;
	}
	return null;
	}
}

