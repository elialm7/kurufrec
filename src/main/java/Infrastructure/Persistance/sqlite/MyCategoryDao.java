package Infrastructure.Persistance.sqlite;

import Domain.DTO.Entities.MyCategory;
import Infrastructure.Connection.MyConnection;
import Infrastructure.Persistance.DaoInterface.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 *This class is the dao implementation for the Mycategory table.
 */
public class MyCategoryDao implements Dao<MyCategory> {
	 private  MyConnection connection ;
	 public MyCategoryDao(MyConnection connection){
	 	 this.connection = connection;
	 }
	 @Override
	 public Optional<MyCategory> getData(int id) {
		Connection conn = null;
		MyCategory cat = null;
		  try {
			   conn = this.connection.connect();
			   String sql = "select * from MyCategory where idcat = ?; ";
			   PreparedStatement preparedStatement = conn.prepareStatement(sql);
			   preparedStatement.setInt(1, id);
			   ResultSet rs = preparedStatement.executeQuery();
			   if(rs.next()){
			   	 cat = new MyCategory();
			   	 cat.setId(rs.getInt("idcat"));
			   	 cat.setDescription(rs.getString("descritpion"));
			   	 cat.setTitle(rs.getString("title"));
			   }else{
			   	 return Optional.empty();
			   }
			   conn.close();
		  } catch (SQLException e) {
		  	 //loggin must go here
			   e.printStackTrace();
		  }
		  return Optional.of(cat);
	 }

	 @Override
	 public List<MyCategory> getAllData() {

		  Connection conn = null;
		  List<MyCategory> myCategoryList = new ArrayList<>();
		  try {
			   conn = this.connection.connect();
			   String sql = "select * from MyCategory; ";
			   PreparedStatement preparedStatement = conn.prepareStatement(sql);
			   ResultSet rs = preparedStatement.executeQuery();
			   MyCategory cat = new MyCategory();
			   while(rs.next()){
					cat.setId(rs.getInt("idcat"));
					cat.setDescription(rs.getString("descritpion"));
					cat.setTitle(rs.getString("title"));
					myCategoryList.add(cat);
			   }
			   conn.close();
		  } catch (SQLException e) {
			   //loggin must go here
			   e.printStackTrace();
		  }
		  return myCategoryList;
	 }

	 @Override
	 public boolean save(MyCategory data) {
	 	 boolean saved = false;
	 	 Connection conn = null;
	 	 if(!Objects.isNull(data)) {
			  try {
				   conn = this.connection.connect();
				   String sql = "insert into MyCategory(title, description) values (?,?);";
				   PreparedStatement preparedStatement = conn.prepareStatement(sql);
				   preparedStatement.setString(1, data.getTitle());
				   preparedStatement.setString(2, data.getDescription());
				   saved = preparedStatement.execute();
				   conn.close();
			  } catch (SQLException e) {
				   e.printStackTrace();
			  }
		 }
		  return saved;
	 }

	 @Override
	 public boolean update(MyCategory data, String[] params) {

	 	 //
		  return false;
	 }

	 @Override
	 public boolean delete(MyCategory todelete) {
		  return false;
	 }

	 @Override
	 public List<MyCategory> searchby(String searched, String filter) {
		  return null;
	 }
}
