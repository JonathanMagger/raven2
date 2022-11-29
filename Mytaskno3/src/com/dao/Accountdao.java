package com.dao;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.model.Model;






public class Accountdao {
	private static final String INSERT_SHOP = "insert into product (name, image, cost, product) values (?,?,?,?);";
	private static final String SELECT_PRODUCT = "select id, name, image, cost, product from product where product =?;";
	private static final String SELECT_PRODUCT_BY_ID = "select id, name, image, cost, product from product where id=?;";
	private static final String UPDATE_PRODUCT_BY_ID = "update product set name =?, image =?, cost =?, product =? where id=?;";
	private static final String SELECT_SHOP_BY_ID = "select id, fname, lname, address, email, uname, pass, phone from shop where id=?; ";
	private static final String DELETE_SHOP = "delete from shop where id = ?;";
	private static final String DELETE_PRODUCT = "delete from product where id = ?;";
	private static final String UPDATE_SHOP = "update shop set fname =?, lname =?, address =?, email =?, uname =?, pass =?, phone =? where id=?;";
	private static final String VIEW_SHOP_LIST = "select id, uname from shop;";
	public Accountdao() {
	}
	
	public List<Model> viewList() {
		List<Model> shop = new ArrayList<>();
		try (Connection connection = Connect.Database();
				PreparedStatement statement = connection.prepareStatement(VIEW_SHOP_LIST);) {
			System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id"); //id, name, date, city
				String username = rs.getString("uname");
				shop.add(new Model(id, username));
			}
		}catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return shop;
	}
	
	public List<Model> proList(String product) {
		List<Model> shop = new ArrayList<>();
		try (Connection connection = Connect.Database();
				PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT);) {
			statement.setString(1, product);
			System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name"); //name, image, cost, product
				String cost = rs.getString("cost");
				String photo = rs.getString("image");
				shop.add(new Model(id, name, cost, product, photo));
			}
		}catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return shop;
	}
	
	public List<Model> PLList(String a) {
		List<Model> shop = new ArrayList<>();
		try (Connection connection = Connect.Database();
				PreparedStatement statement = connection.prepareStatement("SELECT * from product WHERE id IN("+ a +")");) {
			System.out.println(statement);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name"); //name, image, cost, product
				String cost = rs.getString("cost");
				String photo = rs.getString("image");
				String product = rs.getString("product");
				shop.add(new Model(id, name, cost, product, photo));
			}
		}catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return shop;
	}
	
	public void insertPro(Model shop) throws FileNotFoundException  {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = Connect.Database();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHOP)) {
			preparedStatement.setString(1, shop.getName());
			String img = shop.getPhoto();
			File file = new File (img);
			FileInputStream fis = new FileInputStream(file);
			int len = (int)file.length();
			preparedStatement.setBinaryStream(2, (InputStream)fis, len);
			preparedStatement.setString(3, shop.getCost());
			preparedStatement.setString(4, shop.getProduct());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Model viewacc (int id) {
		Model shop = null;
		try (Connection connection = Connect.Database();
				PreparedStatement statement = connection.prepareStatement(SELECT_SHOP_BY_ID);) {
			statement.setInt(1, id);
			System.out.println(statement);
			ResultSet rs = statement.executeQuery();//id, fname, lname, address, email, uname, pass, phone
			while (rs.next()) {
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				String address = rs.getString("address");
				String email = rs.getString("email");
				String uname = rs.getString("uname");
				String pass = rs.getString("pass");
				String phone = rs.getString("phone");
				shop = new Model(id, fname, lname, address, email, uname, pass, phone);
			}
			}catch (SQLException e) {
				printSQLException(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return shop;
}
	
	public Model viewpro (int id) {
		Model shop = null;
		try (Connection connection = Connect.Database();
				PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
			statement.setInt(1, id);
			System.out.println(statement);
			ResultSet rs = statement.executeQuery();//id, fname, lname, address, email, uname, pass, phone
			while (rs.next()) {
				String name = rs.getString("name"); //name, image, cost, product
				String cost = rs.getString("cost");
				String photo = rs.getString("image");
				String product = rs.getString("product");
				shop = new Model(id, name, cost, product, photo);
			}
			}catch (SQLException e) {
				printSQLException(e);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return shop;
}
	
	public boolean updatepro (Model shop) throws SQLException, FileNotFoundException {
		boolean rowUpdate = false;
		try (Connection connection = Connect.Database();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);){
			statement.setString(1, shop.getName()); //name =?, image =?, cost =?, product =?
			String img = shop.getPhoto();
			File file = new File (img);
			FileInputStream fis = new FileInputStream(file);
			int len = (int)file.length();
			statement.setBinaryStream(2, (InputStream)fis, len);
			statement.setString(3, shop.getCost());
			statement.setString(4, shop.getProduct());
			statement.setInt(5, shop.getId());
			rowUpdate = statement.executeUpdate() > 0;
		}catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdate;
	}

	public boolean updateacc (Model shop) throws SQLException, FileNotFoundException {
		boolean rowUpdate = false;
		try (Connection connection = Connect.Database();
				PreparedStatement statement = connection.prepareStatement(UPDATE_SHOP);){
			statement.setString(1, shop.getFname()); 
			statement.setString(2, shop.getLname());
			statement.setString(3, shop.getAddress());
			statement.setString(4, shop.getEmail());
			statement.setString(5, shop.getUname());
			statement.setString(6, shop.getPass());
			statement.setString(7, shop.getPhone());
			statement.setInt(8, shop.getId());
			rowUpdate = statement.executeUpdate() > 0;
		}catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdate;
	}
	
	public boolean deletepro (int id) throws SQLException {
		boolean rowDeleted = false;
		try (Connection connection = Connect.Database();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	public boolean deleteacc (int id) throws SQLException {
		boolean rowDeleted = false;
		try (Connection connection = Connect.Database();
				PreparedStatement statement = connection.prepareStatement(DELETE_SHOP);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;
	}
	
	private void printSQLException(SQLException ex) {
		// TODO Auto-generated method stub
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
