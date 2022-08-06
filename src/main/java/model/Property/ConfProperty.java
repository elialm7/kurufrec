/*
 * Copyright (C)
 * This file is part of KuruFrec Tool  which is released under the MIT LICENSE.
 * See file LICENSE.TXT  for full license details.
 */

package model.Property;

public class ConfProperty {

	 private boolean wfile = true;
	 private boolean wfolder =true;
	 private boolean fromjar = true;
	 private String folderloc = "";
	 private String fileloc = "";
	 private String output = "";

	 public boolean isWfile() {
		  return wfile;
	 }

	 public void setWfile(boolean wfile) {
		  this.wfile = wfile;
	 }

	 public boolean isWfolder() {
		  return wfolder;
	 }

	 public void setWfolder(boolean wfolder) {
		  this.wfolder = wfolder;
	 }

	 public boolean isFromjar() {
		  return fromjar;
	 }

	 public void setFromjar(boolean fromjar) {
		  this.fromjar = fromjar;
	 }

	 public String getFolderloc() {
		  return folderloc;
	 }

	 public void setFolderloc(String folderloc) {
		  this.folderloc = folderloc;
	 }

	 public String getFileloc() {
		  return fileloc;
	 }

	 public void setFileloc(String fileloc) {
		  this.fileloc = fileloc;
	 }

	 public String getOutput() {
		  return output;
	 }

	 public void setOutput(String output) {
		  this.output = output;
	 }
}
