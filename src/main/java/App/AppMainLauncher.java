package App;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AppMainLauncher {

	 private static Logger AppMainLauncherLogger = LogManager.getLogger(AppMainLauncher.class);
	 public static void main(String[] args){
		  AppMainLauncherLogger.info("Appmain is being called...");
		  Appmain.main(args);
	 }

}
