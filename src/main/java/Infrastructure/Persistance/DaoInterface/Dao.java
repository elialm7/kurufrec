package Infrastructure.Persistance.DaoInterface;

import java.util.List;
import java.util.Optional;

/**
 * this interface defines the methods for updating, deleting, getting data, saving.
 * @param <T> the dto type that needs to be work around.
 */
public interface Dao<T> {
	 /**
	  *
	  * @param id of the object needed.
	  * @return the objected asked
	  */
	 Optional<T> getData(int id );

	 /**
	  * return a list of objects asked
	  * @return list of the type of object needed
	  */
	 List<T> getAllData();

	 /**
	  * this method Saves the data.
	  * @param data the data needed to be save
	  * @return true if the data has been saved or false if not.
	  */
	 boolean save(T data);

	 /**
	  * this method updates that data.
	  * @param data that needs to be updated
	  * @param params that data that's going to be new  data.
	  * @return true if it is updated or false if not.
	  */
	 boolean update(T data, String[] params);


	 /**
	  * this method deletes the data
	  * @param todelete the data which is going to be deleted
	  * @return true if it si deleted. false if not.
	  */
	 boolean delete(T todelete);


	 /**
	  *  this method returns a list filter by the filter and what coincided with the searched
	  * @param searched what is about to be search
	  * @param filter the filter, idk.
	  * @return a list of t of T that coincided with the searched.
	  */
	 List<T> searchby(String searched, String filter);


}
