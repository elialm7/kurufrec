/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package model.Property;

import model.Folder.MyFolder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	 private File propertyLoc;
	 private Properties prop;
	 public PropertyLoader (String file){
		  this.propertyLoc = new File(MyFolder.getJarFile(), file);

		  prop = new Properties();
	 }
	 public PropertyLoader(){
		  prop = new Properties();
	 }

	 public ConfProperty loadproperty() throws IOException {
		  ConfProperty property = new ConfProperty();
		  prop.load(new FileReader(propertyLoc));
		  property.setWfile(Boolean.parseBoolean(prop.getProperty("wfile")));
		  property.setWfolder(Boolean.parseBoolean(prop.getProperty("wfolder")));
		  property.setFromjar(Boolean.parseBoolean(prop.getProperty("fromJar")));
		  property.setFileloc(prop.getProperty("fileloc"));
		  property.setFolderloc(prop.getProperty("folderloc"));
		  property.setOutput(prop.getProperty("out"));
		  return property;
	 }

	 public void createDefaulProperty() throws IOException {
		  ConfProperty def = new ConfProperty();
		  prop.clear();
		  prop.setProperty("wfile",String.valueOf(def.isWfile()));
		  prop.setProperty("wfolder",String.valueOf(def.isWfolder()));
		  prop.setProperty("fromJar",String.valueOf(def.isFromjar()));
		  prop.setProperty("fileloc",def.getFileloc());
		  prop.setProperty("folderloc",def.getFolderloc());
		  prop.setProperty("out", def.getOutput());
		  File fi = new File(MyFolder.getJarFile(), "conf.properties");
		  fi.createNewFile();
		  prop.store(new FileWriter(fi), "");
	 }
}
