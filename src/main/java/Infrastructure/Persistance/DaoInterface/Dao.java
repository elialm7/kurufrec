package Infrastructure.Persistance.DaoInterface;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
	 Optional<T> getData(long id );
	 List<T> getAllData();
	 boolean save(T data);
	 boolean update(T data, String[] params);
	 boolean delete(T todelete);
}
