import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Author Name: Xinhui Shi
 * Date: 8/25/2019 
 * Program Name: Shi_Drone
 * Purpose: Siomulation using button, drone movement in x,y,z locaiton
 *
 * Reminder: The drone will not start moving in directions until it's off the ground.
 *
 */
public class Shi_Drone extends Application {

	Pane pane;
	int boardX;
	int boardY;
	Text positionDataX;
	Text positionDataY;
	Text positionDataZ;
	int xAxis;
	int yAxis;
	int zAxis;
	int buttonSize;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		// ***********default variables***********//
		boardX = 300;
		boardY = 300;
		xAxis = 0;
		yAxis = 0;
		zAxis = 0;
		buttonSize = 70;

//		pane = new Pane();
//		pane.setPrefSize(boardX, boardY);

		// ***********top row ****** drone data ****************//
		HBox topHB = new HBox();
		topHB.setSpacing(0);
		topHB.setPadding(new Insets(0, 5, 5, 0));
		positionDataX = new Text(20, 20, "X: " + xAxis + "    ");
		positionDataY = new Text(50, 50, "Y: " + yAxis + "    ");
		positionDataZ = new Text(40, 20, "Z: " + zAxis + "    ");
		topHB.getChildren().addAll(positionDataX, positionDataY, positionDataZ);

		// ***********2nd row ********UP *****************//

		HBox secondHB = new HBox();
		Button upBtn = new Button("Up");
		upBtn.setPrefWidth(buttonSize);
		secondHB.getChildren().add(upBtn);

		// ***********3rd row ********forward**************//
		HBox thirdHB = new HBox();
		Button forwardBtn = new Button("Forward");
		forwardBtn.setPrefWidth(buttonSize);
		forwardBtn.setTranslateX(buttonSize * 2);
		thirdHB.getChildren().add(forwardBtn);

		// ***********4th row *******left and right********//
		HBox fourthHB = new HBox();
		Button leftBtn = new Button("Left");
		leftBtn.setPrefWidth(buttonSize);
		leftBtn.setTranslateX(buttonSize);

		Button rightBtn = new Button("Right");
		rightBtn.setPrefWidth(buttonSize);
		rightBtn.setTranslateX(buttonSize * 2);
		fourthHB.getChildren().addAll(leftBtn, rightBtn);

		// ***********5th row ********backward*************//
		HBox fifthHB = new HBox();

		Button backwardBtn = new Button("Backward");
		backwardBtn.setPrefWidth(buttonSize);
		backwardBtn.setTranslateX(buttonSize * 2);
		fifthHB.getChildren().add(backwardBtn);

		// ***********6th row ********down*****************//
		HBox sixthHB = new HBox();
		Button downBtn = new Button("Down");
		downBtn.setPrefWidth(buttonSize);
		sixthHB.getChildren().add(downBtn);

		// ***************Button actions*******************//

		forwardBtn.setOnAction((ActionEvent e) -> {
			if (zAxis > 0)
				yAxis++;
			positionDataY.setText("Y: " + yAxis + "    ");
		});
		leftBtn.setOnAction((ActionEvent e) -> {
			if (zAxis > 0)
				xAxis--;
			positionDataX.setText("X: " + xAxis + "    ");

		});
		rightBtn.setOnAction((ActionEvent e) -> {
			if (zAxis > 0)
				xAxis++;
			positionDataX.setText("X: " + xAxis + "    ");
		});
		backwardBtn.setOnAction((ActionEvent e) -> {
			if (zAxis > 0)
				yAxis--;
			positionDataY.setText("Y: " + yAxis + "    ");

		});
		upBtn.setOnAction((ActionEvent e) -> {
			zAxis++;
			positionDataZ.setText("Z: " + zAxis + "    ");
		});
		downBtn.setOnAction((ActionEvent e) -> {
			if (zAxis > 0)
				zAxis--;
			positionDataZ.setText("Z: " + zAxis + "    ");

		});

		VBox VB = new VBox();
		VB.setSpacing(0);
		VB.setPadding(new Insets(0, 0, 0, 0));
		VB.getChildren().addAll(topHB, secondHB, thirdHB, fourthHB, fifthHB, sixthHB);

		Scene scene = new Scene(VB);
		stage.setScene(scene);
		stage.setWidth(boardX);
		stage.setHeight(boardY);
		stage.setTitle("Xinhui Shi Drone");
		stage.show();
	}

}
