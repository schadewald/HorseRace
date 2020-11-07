import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane gridPane = new GridPane();
        Scene mainScene = new Scene(gridPane);

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0, 10, 0, 10));

        Button startRace = new Button("Start Race");
        Button resetRace = new Button("Reset Race");
        Button exitRace = new Button("Exit Race");

        Text testHorse1 = new Text("Horse1");
        gridPane.add(testHorse1, 1, 0);

        Text testHorse2 = new Text("Horse2");
        gridPane.add(testHorse2, 1, 1);

        Text testHorse3 = new Text("Horse3");
        gridPane.add(testHorse3, 1, 2);

        Text testHorse4 = new Text("Horse4");
        gridPane.add(testHorse4, 1, 3);

        Text testHorse5 = new Text("Horse5");
        gridPane.add(testHorse5, 1, 4);

        gridPane.add(startRace, 1,5);
        gridPane.add(resetRace, 2, 5);
        gridPane.add(exitRace, 3, 5);

        Group root = new Group();
        primaryStage.setTitle("Welcome to Horse Race!");
        primaryStage.setScene(mainScene);

        final Canvas canvas = new Canvas(150,250);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillRect(75,75,100,100);
        root.getChildren().add(canvas);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
