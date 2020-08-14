package controller;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.HitBox;
import model.Player;

public class Controller {

	private AnchorPane pane;
	private Stage stage;
	private Scene scene;

	private Player player;
	private HitBox hitBox;
	private Line line;
	private Label distanceRestante;
	private Label hit;

	private double hitBoxRadius = 30;
	private double playerRadius = 30;

	public Controller() {

	}

	public void init() {
		this.buildFrame();
	}

	public void start() {
		this.buildPlayer();
		this.buildHiter();

		this.stage.show();
	}

	private void buildHiter() {

		this.hitBox = new HitBox();
		this.hitBox.setRadius(this.hitBoxRadius);

		this.line = new Line();

		this.distanceRestante = new Label();
		this.distanceRestante.setLayoutX(10);
		this.distanceRestante.setLayoutY(10);

		this.hit = new Label();
		this.hit.setLayoutX(10);
		this.hit.setLayoutY(25);

		this.scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				moveHitBox(event);
				updateLine();
				showDistance();
			}
		});

		this.pane.getChildren().addAll(this.hitBox, this.line, this.distanceRestante, this.hit);
	}

	private void moveHitBox(MouseEvent event) {
		this.hitBox.setLayoutX(event.getX());
		this.hitBox.setLayoutY(event.getY());
	}

	private void updateLine() {
		this.line.setStartX(this.hitBox.getLayoutX());
		this.line.setStartY(this.hitBox.getLayoutY());
		this.line.setEndX(this.player.getHitBox().getLayoutX());
		this.line.setEndY(this.player.getHitBox().getLayoutY());
	}

	private void showDistance() {
		double distance = this.hitBoxRadius + this.playerRadius - this.calculateDistance(this.hitBox.getLayoutX(),
				this.player.getHitBox().getLayoutX(), this.hitBox.getLayoutY(), this.player.getHitBox().getLayoutY());
		this.distanceRestante.setText("Distance restante : " + String.format("%.0f", Math.abs(distance)));
		boolean hitted = this.hitBoxRadius + this.playerRadius > this.calculateDistance(this.hitBox.getLayoutX(),
				this.player.getHitBox().getLayoutX(), this.hitBox.getLayoutY(), this.player.getHitBox().getLayoutY());
		this.hit.setText("Touche : " + hitted);
	}

	private void buildPlayer() {
		this.player = new Player(this.playerRadius);
		this.pane.getChildren().addAll(this.player.getHitBox(), this.player.getImageView());
	}

	private void buildFrame() {
		this.pane = new AnchorPane();
		this.scene = new Scene(this.pane, 400, 400);
		this.stage = new Stage();
		this.stage.setTitle("Collision detector");
		this.stage.setScene(this.scene);
		this.scene.setCursor(Cursor.NONE);
	}

	private double calculateDistance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	public Stage getStage() {
		return this.stage;
	}
}
