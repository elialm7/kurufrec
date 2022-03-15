package Domain.DTO.ConfigurationEntity;




public class Configuration{

	 public static String FULL_CONF_LOCATION = "kuru_indexer\\conf\\conf.properties";
	 public static String DIR_CONF_LOCATION = "kuru_indexer\\conf";
	 private String monitored_location = "";
	 private String full_db_location = "kuru_indexer\\bbdd\\ddbb.db";
	 private String dir_db_location = "kuru_indexer\\bbdd";
	 private String first_time_running = "true";
	 private String jar_location = "";
	 private String Lang = "en";

	 public Configuration(){}


	 public String getFull_db_location() {
		  return full_db_location;
	 }

	 public void setFull_db_location(String full_db_location) {
		  this.full_db_location = full_db_location;
	 }

	 public String getDir_db_location() {
		  return dir_db_location;
	 }

	 public void setDir_db_location(String dir_db_location) {
		  this.dir_db_location = dir_db_location;
	 }

	 public String getFirst_time_running() {
		  return first_time_running;
	 }

	 public void setFirst_time_running(String first_time_running) {
		  this.first_time_running = first_time_running;
	 }

	 public String getJar_location() {
		  return jar_location;
	 }

	 public void setJar_location(String jar_location) {
		  this.jar_location = jar_location;
	 }

	 public void setLang(String lang) {
		  Lang = lang;
	 }

	 public String getLang() {
		  return Lang;
	 }

	 public String getMonitored_location() {
		  return monitored_location;
	 }

	 public void setMonitored_location(String monitored_location) {
		  this.monitored_location = monitored_location;
	 }
}
