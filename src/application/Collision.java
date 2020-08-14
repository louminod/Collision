package application;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Collision extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Controller controller = new Controller();
			controller.init();
			controller.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
