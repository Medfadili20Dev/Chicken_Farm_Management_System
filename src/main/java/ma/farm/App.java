package ma.farm;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label with the quote
        Label quoteLabel = new Label("And believe me, a good piece of chicken\ncan make anybody believe in the existence of God.");
        quoteLabel.setFont(new Font("Arial", 18));
        quoteLabel.setTextAlignment(TextAlignment.CENTER);
        quoteLabel.setWrapText(true);

        // Create a VBox to center the quote
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(quoteLabel);
        root.setStyle("-fx-background-color: #f5f5f5;");

        // Create the scene
        Scene scene = new Scene(root, 800, 600);

        // Set the window title
        primaryStage.setTitle("Chicken Farm Management");

        // Set the logo icon
        try {
            Image logo = new Image(getClass().getResourceAsStream("/images/logo.png"));
            primaryStage.getIcons().add(logo);
        } catch (Exception e) {
            System.out.println("Logo not found: " + e.getMessage());
        }

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}