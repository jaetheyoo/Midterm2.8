package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class Main extends Application {

	final Label auth = new Label("");
	final Popup helpclicked = new Popup();

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 350, 80);
		stage.setScene(scene);
		stage.setTitle("Password Ex");
		
		helpclicked.setX(750);
		helpclicked.setY(370);
		helpclicked.getContent().add(new Text("Help was clicked"));
		
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));

		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER_LEFT);

		Label label = new Label("Password");
		final PasswordField pb = new PasswordField();

		Button OK = new Button("OK");
		HBox hbOK = new HBox(10);
		hbOK.setAlignment(Pos.CENTER_RIGHT);

		Button HELP = new Button("HELP");
		HBox hbHELP = new HBox(10);
		hbHELP.setAlignment(Pos.CENTER_RIGHT);

		pb.setOnAction(new EventHandler<ActionEvent>() { //EXTRA CREDIT
			@Override
			public void handle(ActionEvent e) {
				if (!pb.getText().equals("bugaboo")) {
					auth.setText("Incorrect PW");
				} else {
					auth.setText("Correct");
				}
				pb.setText("");
			}
		});

		OK.setOnAction(new EventHandler<ActionEvent>() { //OKAY IS PRESSED
			@Override
			public void handle(ActionEvent e) {
				if (!pb.getText().equals("bugaboo")) {
					auth.setText("Incorrect PW");
				} else {
					auth.setText("Correct");
				}
				pb.setText("");
			}
		});
		
		HELP.setOnAction(new EventHandler<ActionEvent>() { //HELP IS PRESSED
			@Override
			public void handle(ActionEvent e) {
				helpclicked.show(stage);
			}
		});

		hbOK.getChildren().add(OK); //SETUP LAYOUT
		hbHELP.getChildren().add(HELP);
		hb.getChildren().addAll(label, pb);
		grid.add(hbOK, 2, 0);
		grid.add(label, 0, 0);
		grid.add(hbHELP, 2, 1);
		grid.add(pb, 1, 0);
		grid.add(auth, 1, 1);

		scene.setRoot(grid);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}