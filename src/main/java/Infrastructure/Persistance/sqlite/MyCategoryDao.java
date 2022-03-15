package Infrastructure.Persistance.sqlite;

import Domain.DTO.Entities.MyCategory;
import Infrastructure.Connection.MyConnection;
import Infrastructure.Persistance.DaoInterface.Dao;


import java.util.List;
import java.util.Optional;

public class MyCategoryDao implements Dao<MyCategory> {
	 private  MyConnection connection ;
	 public MyCategoryDao(MyConnection connection){
	 	 this.connection = connection;
	 }
	 @Override
	 public Optional<MyCategory> getData(long id) {
		  return Optional.empty();
	 }

	 @Override
	 public List<MyCategory> getAllData() {
		  return null;
	 }

	 @Override
	 public boolean save(MyCategory data) {
		  return false;
	 }

	 @Override
	 public boolean update(MyCategory data, String[] params) {
		  return false;
	 }

	 @Override
	 public boolean delete(MyCategory todelete) {
		  return false;
	 }
}
