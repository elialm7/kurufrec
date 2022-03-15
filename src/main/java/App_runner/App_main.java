package App_runner;

import Domain.DTO.ConfigurationEntity.Configuration;
import Domain.DTO.Entities.MyFile;
import Domain.FileManagement.MyFolder;
import Infrastructure.Persistance.Configuration.ConfigurationManager;
import Presentation.mainwindow.MainWindowController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App_main extends Application {
	 public static void main(String[] args){

	 }

	 @Override
	 public void start(Stage stage) throws Exception {
		  /**Platform.runLater(()->{
		  	 try {
				  Stage st = new Stage();
				  MainWindowController main = new MainWindowController();
				  FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI_FX/MainWindow/main_window_fx.fxml"));
				  loader.setController(main);
				  st.setScene(new Scene(loader.load()));
				  st.show();
			 }catch (IOException e) {
				  e.printStackTrace();
			 }

		  });**/



	 }
}
