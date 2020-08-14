package model;

import javafx.scene.shape.Circle;

public class HitBox extends Circle {

	public HitBox() {

	}

	public HitBox(double layoutX, double layoutY, double radius) {
		setLayoutX(layoutX);
		setLayoutY(layoutY);
		setRadius(radius);
	}
}
