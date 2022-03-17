package Domain.DTO.Entities;


/**
 * This class defines the dto entity for the MyCategory table in the database.
 */
public class MyCategory {

	private int id;
	private String title;
	private String description;

	 public int getId() {
		  return id;
	 }

	 public void setId(int id) {
		  this.id = id;
	 }

	 public String getTitle() {
		  return title;
	 }

	 public void setTitle(String title) {
		  this.title = title;
	 }

	 public String getDescription() {
		  return description;
	 }

	 public void setDescription(String description) {
		  this.description = description;
	 }
}
