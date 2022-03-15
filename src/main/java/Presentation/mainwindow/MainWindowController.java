package Presentation.mainwindow;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {


	 @FXML
	 private MenuItem about_app;

	 @FXML
	 private MenuItem add_category;

	 @FXML
	 private ListView<?> category_list_view;

	 @FXML
	 private MenuItem copy_selected_file_to;

	 @FXML
	 private TextArea detail_area;

	 @FXML
	 private MenuItem edit_current_category;

	 @FXML
	 private MenuItem export_category;

	 @FXML
	 private MenuItem import_category;

	 @FXML
	 private Label left_side_status;

	 @FXML
	 private MenuItem open_folder;

	 @FXML
	 private MenuItem quite_app;

	 @FXML
	 private Label right_side_status;

	 @FXML
	 private Button search_button;

	 @FXML
	 private TextField search_field;

	 @FXML
	 private MenuItem settings;

	 @FXML
	 private TableColumn<?, ?> table_column_id;

	 @FXML
	 private TableColumn<?, ?> table_column_name;

	 @FXML
	 private TableColumn<?, ?> table_column_path;

	 @FXML
	 private TableColumn<?, ?> table_column_type;

	 @FXML
	 private TableView<?> table_view;

	 @FXML
	 private Font x1;

	 @FXML
	 private Font x3;

	 @Override
	 public void initialize(URL url, ResourceBundle resourceBundle) {

	 }
}
