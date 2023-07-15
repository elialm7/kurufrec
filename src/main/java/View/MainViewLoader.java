package View;

import Controller.MainWindowController.MainWindowController;
import Model.Utilities.UIRepository.UITextRepository;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainViewLoader {

	 private String resourcepath = "/main/mainwindow.fxml";
	 private String iconpath = "/Images/mainicon.png";
	 private Stage MainWindowStage;
	 private MainWindowController controller;
	 public MainViewLoader(Stage stage, MainWindowController controller){
	 	 if(Objects.isNull(stage) || Objects.isNull(controller))
	 	 	 throw new NullPointerException("Controller nor stage cannot be null.");
	 	 this.MainWindowStage = stage;
	 	 this.controller = controller;
	 }
	 public void start(){
		  try {
		  	 FXMLLoader mainfxmlloader = new FXMLLoader(getClass().getResource(resourcepath));
		  	 mainfxmlloader.setController(controller);
		  	 controller.setStage(MainWindowStage);
		  	 MainWindowStage.setScene(new Scene(mainfxmlloader.load()));
		  	 MainWindowStage.setResizable(false);
		  	 MainWindowStage.setTitle(UITextRepository.AppName +" "+UITextRepository.AppVersion);
		  	 MainWindowStage.getIcons().add(new Image(iconpath));
		  	 MainWindowStage.show();
		  } catch (IOException e) {
			   e.printStackTrace();
		  }
	 }



}
