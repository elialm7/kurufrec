package Infrastructure.Persistance.Configuration;

import Domain.DTO.ConfigurationEntity.Configuration;
import Domain.FileManagement.MyFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;
import java.util.Properties;

public class ConfigurationManager {


	 private static ConfigurationManager conf_manager = null;
	 private Configuration currentconfiguration;
	 private String root;
	 private ConfigurationManager() {
			this.currentconfiguration = new Configuration();
			this.root = MyFolder.getDriveRoots()[0].getAbsolutePath();
	 }

	 public static ConfigurationManager getInstance(){
	 	 if(Objects.isNull(conf_manager)){
	 	 	 conf_manager = new ConfigurationManager();
		 }
	 	 return conf_manager;
	 }


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
