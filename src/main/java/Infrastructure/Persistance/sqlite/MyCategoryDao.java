package Infrastructure.Persistance.sqlite;

import Domain.DTO.Entities.MyCategory;
import Infrastructure.Connection.MyConnection;
import Infrastructure.Persistance.DaoInterface.ImyCategory;

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
public class MyCategoryDao implements ImyCategory {
	 private  MyConnection connection ;
	 public MyCategoryDao(MyConnection connection){
	 	 this.connection = connection;
	 }

	 /**
	  * This method return an optional of category type where the data is put in
	  * @param id of the object needed.
	  * @return the data.
	  */
	 @Override
	 public Optional<MyCategory> getData(int id) {
		Connection conn;
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
			   rs.close();
			   conn.close();
		  } catch (SQLException e) {
		  	 //loggin must go here
			   e.printStackTrace();
		  }
		  return Optional.ofNullable(cat);
	 }

	 /**
	  * This methods return all the rows that are in the database for this entity.
	  * @return a list of mycategory that are in the database.
	  */

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

	 /**
	  * Saves or adds new data in the database.
	  * @param data the data needed to be save
	  * @return
	  */
	 @Override
	 public boolean save(MyCategory data) {
	 	 boolean saved = false;
	 	 Connection conn;
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

	 /**
	  * This method updated data passed through the param and updates it to the database.
	  * @param data that needs to be updated
	  * @param params that data that's going to be new  data.
	  * @return
	  */
	 @Override
	 public boolean update(MyCategory data, String[] params) {
		  boolean IsUpdated = false;
		  Connection conn;
		  if(!Objects.isNull(data)) {
			   try {
					conn = this.connection.connect();
					String sql = "update MyCategory set title = ?, description = ? where idcat = ?";
					PreparedStatement preparedStatement = conn.prepareStatement(sql);
					preparedStatement.setString(1, data.getTitle());
					preparedStatement.setString(2, data.getDescription());
					preparedStatement.setInt(3, data.getId());
					int rows = preparedStatement.executeUpdate();
					if(rows>=1)
						 IsUpdated = true;
					conn.close();
			   } catch (SQLException e) {
			   	 //loggin must go here
					e.printStackTrace();
			   }
		  }
		  return IsUpdated;
	 }

	 /**
	  * this methos deletes the mycategory from the database passed from the param.
	  * @param todelete the data which is going to be deleted
	  * @return
	  */

	 @Override
	 public boolean delete(MyCategory todelete) {
		  boolean isdeleted = false;
		  Connection conn;
		  if(!Objects.isNull(todelete)) {
			   try {
					conn = this.connection.connect();
					String sql = "delete from MyCategory where idcat = ?";
					PreparedStatement preparedStatement = conn.prepareStatement(sql);
					preparedStatement.setInt(1, todelete.getId());
					int rows = preparedStatement.executeUpdate();
					if(rows>=1)
						 isdeleted = true;
					conn.close();
			   } catch (SQLException e) {
					//loggin must go here
					e.printStackTrace();
			   }
		  }
		  return isdeleted;
	 }

	 /**
	  * This method returns a list of Mycategory objects according to the search param.
	  * @param searched what is about to be search
	  * @param filter the filter, idk.
	  * @return
	  */

	 @Override
	 public List<MyCategory> searchby(String searched, String filter) {

	 	  String search = "%"+searched+"%";
	 	  String sql = getQueryforFilter(filter);
		  List<MyCategory> categoryList = new ArrayList<>();
		  MyCategory cat;
		  Connection conn;

	 	  try {
	 	  	 conn = this.connection.connect();
	 	  	 PreparedStatement prep = conn.prepareStatement(sql);
	 	  	 prep.setString(1, search);
	 	  	 ResultSet rs= prep.executeQuery();
	 	  	 while(rs.next()){
	 	  	 	 cat = new MyCategory();
	 	  	 	 cat.setId(rs.getInt("idcat"));
	 	  	 	 cat.setTitle(rs.getString("title"));
	 	  	 	 cat.setDescription(rs.getString("description"));
	 	  	 	 categoryList.add(cat);
			 }
			 rs.close();
	 	  	 conn.close();
		  }catch (SQLException ex){
	 	  	 //logging must go here
	 	  	 ex.printStackTrace();
		  }

		  return categoryList;
	 }

	 /**
	  * This method builds the right sql query according to the filter.
	  * @param filter the filter for the column
	  * @return the query needed
	  */
	 private String getQueryforFilter(String filter){
	 	 if(filter.isEmpty()){
	 	 	 return "select * from MyCategory where title like ?;";
		 }else{
	 	 	 return "select * from MyCategory where"+ filter +" like ?;";
		 }
	 }
}
