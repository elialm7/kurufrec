package app;
import controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{


    public static void main(String[] args){
    launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        MainViewController controller = new MainViewController();
        controller.setMainViewStage(stage);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxmlViews/kurufrecmainviev.fxml"));
        loader.setController(controller);
        stage.setScene(new Scene(loader.load()));
        stage.setResizable(false);
        stage.setTitle("Kuru frec v1.0.0");
        stage.show();
    }
}
