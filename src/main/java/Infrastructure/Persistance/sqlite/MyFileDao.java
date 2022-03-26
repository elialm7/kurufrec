package Infrastructure.Persistance.sqlite;

import Domain.DTO.Entities.MyFile;
import Infrastructure.Connection.MyConnection;
import Infrastructure.Persistance.DaoInterface.ImyFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	 	 	 String sql = "select * from Myfile where idfile = ?;";
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
	 	 Connection conn;
	 	 List<MyFile> myfiles = new ArrayList<>();
	 	 try{
	 	 	 conn = this.connection. connect();
	 	 	 String sql = "select * from Myfile";
	 	 	 PreparedStatement preparedStatement = conn.prepareStatement(sql);
	 	 	 ResultSet rs = preparedStatement.executeQuery();
	 	 	 MyFile file;
	 	 	 while(rs.next()){
	 	 	 	 file = new MyFile();
	 	 	 	 file.setId(rs.getInt("idfile"));
	 	 	 	 file.setType(rs.getString("type"));
	 	 	 	 file.setName(rs.getString("name"));
	 	 	 	 file.setPath(rs.getString("path"));
	 	 	 	 file.setId_cat(rs.getInt("id_category"));
	 	 	 	 myfiles.add(file);
			 }
			 rs.close();
	 	 	 conn.close();
		 }catch (SQLException sql){
	 	 	 //Logging must go here
			  sql.printStackTrace();
		 }
		  return myfiles;
	 }

	 @Override
	 public boolean save(MyFile data) {
		Connection conn;
		boolean saved  = false;
		try{
			 conn = this.connection.connect();
			 String sql = "insert into Myfile(name, path, type, idcategory)values(?,?,?,?);";
			 PreparedStatement preparedStatement = conn.prepareStatement(sql);
			 preparedStatement.setString(1, data.getName());
			 preparedStatement.setString(2, data.getPath());
			 preparedStatement.setString(3, data.getType());
			 preparedStatement.setInt(4, data.getId_cat());
			 saved = preparedStatement.execute();
			 conn.close();
			 preparedStatement.close();
		}catch (SQLException e){
			 //loggin must go here
			e.printStackTrace();
		}
		  return saved;
	 }

	 @Override
	 public boolean update(MyFile data, String[] params) {
	 	 //the file should not be updated.
		  return false;
	 }

	 @Override
	 public boolean delete(MyFile todelete){
	 	 boolean isdeleted = false;
	 	 Connection conn;
	 	 try{
	 	 	 conn = this.connection.connect();
	 	 	 String sql = "delete from Myfile where idfile=?";
	 	 	 PreparedStatement prep = conn.prepareStatement(sql);
	 	 	 prep.setInt(1, todelete.getId());
	 	 	 int rows = prep.executeUpdate();
	 	 	 if(rows>=1)
	 	 	 	 isdeleted = true;
			 conn.close();
	 	 	 prep.close();
		 }catch (SQLException e){
	 	 	 e.printStackTrace();
		 }
		  return isdeleted;
	 }

	 @Override
	 public List<MyFile> searchby(String searched, String filter) {

	 	 String search = "select * from Myfile where name like ?";
	 	 List<MyFile> files = new ArrayList<>();
	 	 Connection conn;
	 	 try{
	 	 	 conn = this.connection.connect();
	 	 	 PreparedStatement prep = conn.prepareStatement(search);
	 	 	 prep.setString(1, "%"+searched +"%");
	 	 	 ResultSet rs = prep.executeQuery();
	 	 	 MyFile afile;
	 	 	 while(rs.next()){
	 	 	 	 afile = new MyFile();
	 	 	 	 afile.setId(rs.getInt("idfile"));
	 	 	 	 afile.setId_cat(rs.getInt("idcategory"));
	 	 	 	 afile.setName(rs.getString("name"));
	 	 	 	 afile.setPath(rs.getString("path"));
	 	 	 	 afile.setType(rs.getString("type"));
	 	 	 	 files.add(afile);
			 }
			 conn.close();
	 	 	 rs.close();
		 }catch (SQLException e){
	 	 	 e.printStackTrace();
		 }
		  return files;
	 }

}
