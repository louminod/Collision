package model;

import javafx.scene.image.ImageView;

public class Player {

	private HitBox hitBox;

	private ImageView imageView;

	public Player(double hitBoxRadius) {
		this.imageView = new ImageView("application/resources/compass.png");
		this.imageView.setFitHeight(100);
		this.imageView.setFitWidth(100);
		this.imageView.setLayoutX(200 - this.imageView.getFitWidth() / 2);
		this.imageView.setLayoutY(200 - this.imageView.getFitHeight() / 2);

		this.hitBox = new HitBox();
		this.hitBox.setLayoutX(this.imageView.getLayoutX() + this.imageView.getFitWidth() / 2);
		this.hitBox.setLayoutY(this.imageView.getLayoutY() + this.imageView.getFitHeight() / 2);
		this.hitBox.setRadius(hitBoxRadius);
	}

	public ImageView getImageView() {
		return this.imageView;
	}

	public HitBox getHitBox() {
		return this.hitBox;
	}
}
