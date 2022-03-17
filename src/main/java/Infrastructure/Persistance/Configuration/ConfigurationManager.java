package Infrastructure.Persistance.Configuration;

import Domain.DTO.ConfigurationEntity.Configuration;
import Domain.FileManagement.MyFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * If we want to write and read a file where the configuration. ConfigurationManager class should be instanced.
 * it's been built under the singleton pattern. which suits very well for this purpose of saving and reading the configuration file.
 *
 */
public class ConfigurationManager {

	 private static ConfigurationManager conf_manager = null;
	 private Configuration currentconfiguration;
	 private String root;

	 /**
	  * A private constructor for designing the singleton
	  */
	 private ConfigurationManager() {
			this.currentconfiguration = new Configuration();
			this.root = MyFolder.getDriveRoots()[0].getAbsolutePath();
	 }


	 /**
	  * when we want to instance this class, we should call this static method which will instance the class.
	  * @return the instance of this class.
	  */
	 public static ConfigurationManager getInstance(){
	 	 if(Objects.isNull(conf_manager)){
	 	 	 conf_manager = new ConfigurationManager();
		 }
	 	 return conf_manager;
	 }


	 /**
	  *
	  * when we have already instanced this class and we want to save a configuration file,
	  * we should call this method, which requires a Configuration object for the saving process.
	  * @param conf the configuration object needed for the saving method to work.
	  * @return false if the configuration wasn't saved or true if it was saved
	  */
	 public boolean saveConfiguration(Configuration conf){
	 	 boolean issaved = false;
		if(!Objects.isNull(conf)){
			 try {
				  File conf_path = new File(root + Configuration.FULL_CONF_LOCATION);
				  FileOutputStream output = new FileOutputStream(conf_path);
				  Properties prop = new Properties();
				  prop.setProperty("monitored_location", conf.getMonitored_location());
				  prop.setProperty("db_location", conf.getFull_db_location());
				  prop.setProperty("jar_location", conf.getJar_location());
				  prop.setProperty("lang", conf.getLang());
				  prop.setProperty("first_time", conf.getFirst_time_running());
				  prop.store(output, "properties");
				  output.close();
				  this.currentconfiguration = conf;
				  issaved = true;
			 }catch (java.io.IOException e) {
			 	 //loggin must go here
				  e.printStackTrace();
			 }
		}

	 	 return issaved;
	 }


	 /**
	  * when we have already instanced this class and we want to get the configuration loaded or to load the configuration,
	  * we call this method which returns a Configuration reference where the configuration is loaded.
	  * @return a configuration object.
	  */
	 public Configuration getConfiguration(){
			  try {
				   File conf_path = new File(root + Configuration.FULL_CONF_LOCATION);
				   FileInputStream input = new FileInputStream(conf_path);
				   Properties prop = new Properties();
				   prop.load(input);
				   currentconfiguration.setMonitored_location(prop.getProperty("monitored_location"));
				   currentconfiguration.setFull_db_location(prop.getProperty("db_location"));
				   currentconfiguration.setJar_location(prop.getProperty("jar_location"));
				   currentconfiguration.setLang(prop.getProperty("lang"));
				   currentconfiguration.setFirst_time_running(prop.getProperty("first_time"));
				   input.close();
			  } catch (java.io.IOException e) {
				   //loggin must go here
				   e.printStackTrace();
			  }
	 	 return currentconfiguration;
	 }


}
