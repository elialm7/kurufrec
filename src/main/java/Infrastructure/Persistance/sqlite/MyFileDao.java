package Infrastructure.Persistance.sqlite;

import Domain.DTO.Entities.MyFile;
import Infrastructure.Connection.MyConnection;
import Infrastructure.Persistance.DaoInterface.Dao;

import java.util.List;
import java.util.Optional;

public class MyFileDao  implements Dao<MyFile> {
	 private MyConnection connection;
	 public MyFileDao(MyConnection connection){
	 	 this.connection = connection;
	 }

	 @Override
	 public Optional<MyFile> getData(long id) {
		  return Optional.empty();
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
}
