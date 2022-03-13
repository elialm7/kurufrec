package Infrastructure.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class SqliteConnection implements MyConnection {

	 private String link_connection = "jdbc:sqlite:";
	 private String db_location = null ;
	 private static SqliteConnection instance  = null;

	 /**
	  * this is singleton, returns the instantiated object. makes an instance of object if it is null.
	  * it's a synchronized method in case it is need from simultaneous threads
	  * @return  sqliteconnection object
	  */
	 public static synchronized SqliteConnection getInstance(){
	 	 if(!Objects.nonNull(instance)){
	 	 	 instance = new SqliteConnection();
		 }else{
	 	 	 return instance;
		 }

		 return instance;
	 }

	 /**
	  *  Creates a connection to the database.
	  * @return a connection to the database
	  * @throws SQLException in case the location is not specified, throws an exception.
	  */
	 public synchronized Connection connect() throws SQLException{
		  Connection conn = null;
	 	 if(Objects.nonNull(db_location)) {
			  try {
				    Class.forName("org.sqlite.JDBC");
			  		String final_location = this.link_connection + db_location;
			  		conn = DriverManager.getConnection(final_location);
			  } catch (ClassNotFoundException e) {
			  	 //logging must go here
				   e.printStackTrace();
			  }
		 }else{
	 	 	 throw new SQLException("The ddbb cannot be accessed with a null or empty dblocation");
		 }
		  return conn;
	 }

	 /**
	  * sets the location for the database connection
	  * @param location the path to the ddbb
	  */
	 public synchronized void setdb_location (String location ){
	 	 this.db_location = location;
	 }

	 /**
	  * returns the location of the database file
	  * @return a string of the location
	  */
	 public synchronized String getdb_location(){
	 	 return this.db_location;
	 }
}
