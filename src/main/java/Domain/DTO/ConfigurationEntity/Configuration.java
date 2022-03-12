package Domain.DTO.ConfigurationEntity;

import java.io.File;
import java.util.Objects;

public class Configuration{
	 private String disk = "C:";
	 private String parent_path = disk + File.separator + "kuru_indexer"+File.separator;
	 private String ddbb_path = parent_path + "ddbb" + File.separator;
	 private String watchable_folder = "";
	 private String files_copy_folder_path = parent_path + "files_backup" + File.separator;
	 private String file_configuration_path = parent_path + "conf"+ File.pathSeparator;
	 private String ddbb_file = "kuru_ddbb.db";
	 private String conf_file = "conf.properties";
	 private String first_time_running = "true";
	 private String jar_location = "";

	 public Configuration(){}



	 public String getDisk() {
		  return disk;
	 }

	 public void setDisk(String disk) {
		  this.disk = disk;
	 }

	 public String getParent_path() {
		  return parent_path;
	 }

	 public void setParent_path(String parent_path) {
		  this.parent_path = parent_path;
	 }

	 public String getDdbb_path() {
		  return ddbb_path;
	 }

	 public void setDdbb_path(String ddbb_path) {
		  this.ddbb_path = ddbb_path;
	 }

	 public String getWatchable_folder() {
		  return watchable_folder;
	 }

	 public void setWatchable_folder(String watchable_folder) {
		  this.watchable_folder = watchable_folder;
	 }

	 public String getFiles_copy_folder_path() {
		  return files_copy_folder_path;
	 }

	 public void setFiles_copy_folder_path(String files_copy_folder_path) {
		  this.files_copy_folder_path = files_copy_folder_path;
	 }

	 public String getFile_configuration_path() {
		  return file_configuration_path;
	 }

	 public void setFile_configuration_path(String file_configuration_path) {
		  this.file_configuration_path = file_configuration_path;
	 }

	 public String getDdbb_file() {
		  return ddbb_file;
	 }

	 public void setDdbb_file(String ddbb_file) {
		  this.ddbb_file = ddbb_file;
	 }

	 public String getConf_file() {
		  return conf_file;
	 }

	 public void setConf_file(String conf_file) {
		  this.conf_file = conf_file;
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

	 @Override
	 public boolean equals(Object o) {
		  if (this == o) return true;
		  if (o == null || getClass() != o.getClass()) return false;
		  Configuration that = (Configuration) o;
		  return Objects.equals(disk, that.disk) &&
				  Objects.equals(parent_path, that.parent_path) &&
				  Objects.equals(ddbb_path, that.ddbb_path) &&
				  Objects.equals(watchable_folder, that.watchable_folder) &&
				  Objects.equals(files_copy_folder_path, that.files_copy_folder_path) &&
				  Objects.equals(file_configuration_path, that.file_configuration_path) &&
				  Objects.equals(ddbb_file, that.ddbb_file) &&
				  Objects.equals(conf_file, that.conf_file) &&
				  Objects.equals(first_time_running, that.first_time_running);
	 }

	 @Override
	 public int hashCode() {

		  return Objects.hash(disk, parent_path, ddbb_path, watchable_folder, files_copy_folder_path, file_configuration_path,
				  ddbb_file, conf_file, first_time_running);
	 }
}
