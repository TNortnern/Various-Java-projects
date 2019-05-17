package matchgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import static javafx.scene.layout.StackPane.setAlignment;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/*  Title: MatchingGame
 *  Purpose: This app builds a matching game
 *  Authors: Tray Northern(Game logic), Jae Ellis(Design), David Vert(Animation)
 *
 *
 */
public class MatchingGame extends Application {
	// Class field variables
	// the amount of pairs created
	private static int NUM_OF_PAIRS = 8;
	int check = 0;
	int score = 0;
	// this tracks how many rectangles have been selected
	int tracker = 0;
	int attempts = 0;
	int cos_attempts = 0;
	boolean isEqual = false;
	// amount of rectangles per row
	private static int NUM_PER_ROW = 4;
	Text gameEnd = new Text();
	// varibles to help handle click events
	private Tile selected = null;
	private int clickCount = 2;
	ArrayList<Rectangle> compare = new ArrayList<Rectangle>(2);

	// Method for building play field
	private Pane generatePlayField() {
		VBox tileHolder = new VBox(5);
		tileHolder.setAlignment(Pos.CENTER);
		tileHolder.getChildren().add(gameEnd);
		// setting font size to 0 so it doesn't affect the layout
		gameEnd.setStyle("-fx-font: 0 arial");
		// Create a list of play objects
		List<Tile> tiles = new ArrayList<>();
		// Use for loop to create at least two of the same object
		// for each iteration
		int colorSelector = 0;
		for (int i = 0; i < NUM_OF_PAIRS; i++) {
			tiles.add(new Tile(colorSelector));
			tiles.add(new Tile(colorSelector));
			if (colorSelector == 3) {
				colorSelector = 0;
			} else {
				colorSelector++;
			}
		}
		// for loop to only allow 2 rectangles to be selected at a time
		for (Tile tile : tiles) {
			tile.setOnMouseClicked(e -> {
				tile.ft.setNode(tile.rect);
				if (tile.rect.getOpacity() == 0) {
					// defining the first rectangle to be compared
					if (selected == null) {
						selected = tile;
						// selected or "first" gets opened here
						Fade(0, selected.rect);
						check++;
						// check handles the amount of rectangles that can be
						// selected
					} else if (check < 2) {
						// second rectangle opens here
						Fade(0, tile.rect);
						check++;
						if (check == 2) {
							// once there's 2 rectangles, go to the compare
							// method
							tile.hasSameColor(selected);
							if (!isEqual) {
								attempts++;
								System.out.println("You have " + attempts + " attempts!");
								cos_attempts++;
								// allows user to lose points of their memory is
								// bad and can't match after 3 tries
								if (cos_attempts == 3) {
									score--;
									System.out.println("You've reached " + cos_attempts
											+ " consecutive attempts, you lose 1 point!");
									cos_attempts = 0;
								}
								// closing of both rectangles if they aren't equal
								Fade(1, selected.rect);
								Fade(1, tile.rect);

							} else {
								// two rectangles matched
								score++;
								attempts++;
								tracker++;
								cos_attempts = 0;
								System.out.println("You've gained a point and now have " + score + " points on "
										+ attempts + " attempts");
							}
						}
						// resetting the first rectangles value to null so a new
						// "first" rectangle can be selected
						selected = null;
						hasWon();
					}
				}
			});
		}
		// Shuffle tiles
		Collections.shuffle(tiles);
		// Put tiles on field
		// Create a list of HBoxs for each row
		List<HBox> hboxList = new ArrayList<>();
		for (int i = 0; i < NUM_PER_ROW; i++) {
			hboxList.add(new HBox(5));
			hboxList.get(i).setAlignment(Pos.CENTER);
		}
		// Create a for loop at cycle list of tiles and put them in respective
		// hboxs
		int tileCount = 0;
		for (int i = 0; i < hboxList.size(); i++) {
			for (int j = 0; j < NUM_PER_ROW; j++) {
				hboxList.get(i).getChildren().add(tiles.get(tileCount));
				tileCount++;
			}
			tileHolder.getChildren().add(hboxList.get(i));
		}
		return tileHolder;
	}

	// game tracker
			public void hasWon() {
				int scoreTracker = NUM_OF_PAIRS - score;
				if (tracker == 8){
					gameEnd.setStyle("-fx-font: 15 arial");
				if (score == 8) {
					gameEnd.setFill(Color.GREEN);
					gameEnd.setText("Nice Job! You win!");
				}
				else{
					gameEnd.setFill(Color.RED);
					gameEnd.setText("Game over. You lose!");
				}
				} else {
					if (scoreTracker > 1) {
						System.out.println("You have " + scoreTracker + " more points to go!");
					} else {
						System.out.println("You have " + scoreTracker + " more point to go!");
					}
				}
				if (score < 0) {
					score = 0;
				}
			}

	@Override
	public void start(Stage main) {
		// Create Level selector
		main.setTitle("Match Game");
		main.setScene(new Scene(generatePlayField(), 250, 250)); // Calls method
																	// that
																	// handles
																	// creation
		main.show();
	}

	// Create inner class to handle how the playig objects are created and
	// handled
	private class Tile extends StackPane {
		// Create array of colors to pick from.
		FadeTransition ft = new FadeTransition(Duration.seconds(0.5));
		private Color[] colors = new Color[] { Color.RED, Color.BLUE, Color.THISTLE, Color.BLUEVIOLET };
		private Rectangle rect = new Rectangle(50, 50);

		// constructor
		public Tile(int colorSelector) {
			// ft.setNode(this.rect);
			this.setStyle("-fx-border-color: black;");
			rect.setFill(colors[colorSelector]);
			setAlignment(Pos.CENTER);
			getChildren().add(rect);
			this.rect.setOpacity(0);
		}



		// handles comparing the rectangles
		private void hasSameColor(Tile selected) {
			if (this.rect.getFill().equals(selected.rect.getFill())) {
				isEqual = true;
				// resetting the amount of rectangles selected back to 0
				check = 0;
			} else {
				isEqual = false;
				check = 0;
			}
			;
		}
	}

	// animation that handles hiding and showing
	private void Fade(int i, Rectangle e) {
		FadeTransition ft = new FadeTransition(Duration.millis(800), e);
		if (i == 0) {
			ft.setFromValue(0);
			ft.setToValue(1);
		} else if (i == 1) {
			ft.setFromValue(1);
			ft.setToValue(0);
		}
		ft.play();
	}

	public static void main(String[] args) {
		launch(args);
	}
}