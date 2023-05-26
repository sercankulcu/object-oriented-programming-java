
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a new Label to display text
        Label label = new Label("Welcome to JavaFX!");

        // Create a new Button
        Button button = new Button("Click Me!");
        button.setOnAction(e -> {
            // Action to be performed when button is clicked
            label.setText("Button Clicked!");
        });

        // Create a new VBox (container)
        VBox vbox = new VBox();
        vbox.getChildren().addAll(label, button);

        // Create a new Scene with the VBox as the root node
        Scene scene = new Scene(vbox, 300, 200);

        // Set the Scene on the Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
