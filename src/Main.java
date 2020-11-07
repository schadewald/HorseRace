import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
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
        FlowPane flowPane = new FlowPane();
        Scene mainScene = new Scene(gridPane);

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(0, 10, 0, 10));

        Button startRace = new Button("Start Race");
        Button resetRace = new Button("Reset Race");
        Button exitRace = new Button("Exit Race");

        Canvas horse1 = new Canvas(500, 75);
        GraphicsContext horse1GraphicsContext = horse1.getGraphicsContext2D();
        horse1GraphicsContext.fillRect(0, 0, 600,75 );

        Canvas horse2 = new Canvas(500, 75);
        GraphicsContext horse2GraphicsContext = horse2.getGraphicsContext2D();
        horse2GraphicsContext.fillRect(0, 0, 600,75 );

        Canvas horse3 = new Canvas(500, 75);
        GraphicsContext horse3GraphicsContext = horse3.getGraphicsContext2D();
        horse3GraphicsContext.fillRect(0, 0, 600,75 );

        Canvas horse4 = new Canvas(500, 75);
        GraphicsContext horse4GraphicsContext = horse4.getGraphicsContext2D();
        horse4GraphicsContext.fillRect(0, 0, 600,75 );

        Canvas horse5 = new Canvas(500, 75);
        GraphicsContext horse5GraphicsContext = horse5.getGraphicsContext2D();
        horse5GraphicsContext.fillRect(0, 0, 600,75 );

        flowPane.setVgap(8);
        flowPane.setHgap(4);
        flowPane.getChildren().add(startRace);
        flowPane.getChildren().add(resetRace);
        flowPane.getChildren().add(exitRace);

        gridPane.add(horse1, 1, 0);
        gridPane.add(horse2, 1, 1);
        gridPane.add(horse3, 1, 2);
        gridPane.add(horse4, 1, 3);
        gridPane.add(horse5, 1, 4);
        gridPane.add(flowPane, 1, 5);

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
