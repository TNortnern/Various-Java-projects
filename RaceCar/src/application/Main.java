/**
 * Assignment: Excercise 15.29 Racing Car
 * Date: 2/21/2019
 * Developer: Tray Northern
 * Purpose: Create an animation to make a group of objects move to the end of the parent's pane
 */


package application;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		// ** Parent Object that holds the car objects **
		BorderPane car = new BorderPane();
		Text warning = new Text();

		//Pseudo Centering the Text
		warning.setX(100);
		warning.setY(150);


		// ** Parent for Play/Pause buttons **
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER);

		//** Creation of Play/Pause buttons
		Button play = new Button("Play");
		Button pause = new Button("Pause");

		// ** Adds the play and pause buttons **
		hBox.getChildren().addAll(play, pause);

		// ** Parent Object, adds the car, buttons, and text as children **
		Pane root = new Pane(car, hBox, warning);


		// ** Car Objects
		Rectangle body = new Rectangle(5, 200, 140, 60);
		Circle backWheel = new Circle(40, 275, 20);
		Circle frontWheel = new Circle(100, 275, 20);
		body.setFill(Color.BLUE);
		backWheel.setFill(Color.RED);
		backWheel.setStroke(Color.BLACK);
		frontWheel.setFill(Color.RED);
		frontWheel.setStroke(Color.BLACK);

		// ** Adds the objects to form a car so they can be moved simultaneously **
		car.getChildren().addAll(body, backWheel, frontWheel);
		Scene scene = new Scene(root, 400, 300);

		// ** Skinning the pane **
		root.setStyle("-fx-background-color:#ff6600");

		// ** Gets the car object and animates it to drive from 0 to the end of the pane(Not scalable yet) **
		PathTransition move = new PathTransition(Duration.seconds(3), new Line(0, 0, root.getWidth(), 0), car);
		move.setCycleCount(Animation.INDEFINITE);
		move.play();

		//** Play button **
		play.setOnAction(e -> move.play());
		// ** Pause Button **
		pause.setOnAction(e -> move.pause());


		// ** Checks to see if a key is pressed **
		scene.setOnKeyPressed(e -> {
			// ** If the key is up **
			if (e.getCode() == KeyCode.UP) {
				if (move.getRate() < 7) {
					move.setRate(move.getRate() + 1); // If the rate isn't higher then 7, then increase it
					if (move.getRate() == 7) {
						warning.setText("You've reached the highest speed!"); // Displays after reaching the rate of 7
					}
				}

			}
			// ** If down arrow is pressed **
			if (e.getCode() == KeyCode.DOWN) {
				/** This stops the car from going backwards
				 * e.g. anything under the rate of 0 cause a reverse animation
				 */
				if (move.getRate() >= 1) {
					move.setRate(move.getRate() - 1); // if the rate is higher than 0 basically
					if (move.getRate() == 0) {
						warning.setText("You've stopped!"); // if the rate is 0 display this message

					}

				}
			}
		});

		// ** Scene Creation **
		primaryStage.setScene(scene);
		primaryStage.setTitle("Race Car");
		primaryStage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}
}
