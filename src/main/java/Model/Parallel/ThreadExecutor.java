package Model.Parallel;

import javafx.concurrent.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExecutor {

	 public static void execute(Task task){
		  ExecutorService threadservice = Executors.newSingleThreadExecutor();
		  threadservice.submit(task);
		  threadservice.shutdown();
	 }

}
