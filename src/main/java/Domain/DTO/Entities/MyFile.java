package Domain.DTO.Entities;

public class MyFile {

	 private String name;
	 private String path;
	 private String type;
	 private int id;
	 private int id_cat;


	 public String getName() {
		  return name;
	 }

	 public void setName(String name) {
		  this.name = name;
	 }

	 public String getPath() {
		  return path;
	 }

	 public void setPath(String path) {
		  this.path = path;
	 }

	 public String getType() {
		  return type;
	 }

	 public void setType(String type) {
		  this.type = type;
	 }

	 public int getId() {
		  return id;
	 }

	 public void setId(int id) {
		  this.id = id;
	 }

	 public int getId_cat() {
		  return id_cat;
	 }

	 public void setId_cat(int id_cat) {
		  this.id_cat = id_cat;
	 }
}
