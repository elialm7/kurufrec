

package core.App_runner;
import core.controller.MainWinController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

public class App_main extends Application {

	 private static Logger log = Logger.getLogger(App_main.class);


	 public static void main(String[] args){
	 	 launch(args);
	 }

	 @Override
	 public void start(Stage stage) throws Exception {
		  Platform.runLater(() -> {
			   try {
			   FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/windows/main_fx.fxml"));
			   MainWinController controller = new MainWinController(stage);
			   fxmlLoader.setController(controller);
			   stage.setScene(new Scene(fxmlLoader.load()));
			   stage.setTitle("KuruFrec tool beta");
			   stage.getIcons().add(new Image("/img/logo.png"));
			   stage.setResizable(false);
			   stage.show();
			   } catch (IOException e) {
					log.debug(e);
			   }
		  });
	 }
}
