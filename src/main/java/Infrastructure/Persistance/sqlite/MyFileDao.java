package Infrastructure.Persistance.sqlite;

import Domain.DTO.Entities.MyFile;
import Infrastructure.Connection.MyConnection;
import Infrastructure.Persistance.DaoInterface.ImyFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * this class is the implementation of dao for the Myfile entity.
 */

public class MyFileDao implements ImyFile {
	 private MyConnection connection;
	 public MyFileDao(MyConnection connection){
	 	 this.connection = connection;
	 }

	 @Override
	 public Optional<MyFile> getData(int id) {


	 	 Connection conn;
	 	 MyFile file = null;
	 	 try{
	 	 	 conn = this.connection.connect();
	 	 	 String sql = "select * from MyFile where idfile = ?;";
			  PreparedStatement preparedStatement = conn.prepareStatement(sql);
			  preparedStatement.setInt(1, id);
			  ResultSet rs = preparedStatement.executeQuery();
			  if(rs.next()){
			  	 file = new MyFile();
			  	 file.setId(rs.getInt("idfile"));
			  	 file.setId_cat(rs.getInt("idcategory"));
			  	 file.setName(rs.getString("name"));
			  	 file.setPath(rs.getString("path"));
			  	 file.setType(rs.getString("type"));
			  }else {
				   return Optional.empty();
			  }
			  rs.close();
			  conn.close();
		 }catch (SQLException ex ){
	 	 	 //loggin must go here
	 	 	 ex.printStackTrace();
		 }
		  return Optional.ofNullable(file);
	 }

	 @Override
	 public List<MyFile> getAllData() {



		  return null;
	 }

	 @Override
	 public boolean save(MyFile data) {



		  return false;
	 }

	 @Override
	 public boolean update(MyFile data, String[] params) {



		  return false;
	 }

	 @Override
	 public boolean delete(MyFile todelete) {




		  return false;
	 }

	 @Override
	 public List<MyFile> searchby(String searched, String filter) {




		  return null;
	 }
}
