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
        horse1GraphicsContext.setFill(Color.WHITE);
        drawHorse((horse1GraphicsContext));

        Canvas horse2 = new Canvas(500, 75);
        GraphicsContext horse2GraphicsContext = horse2.getGraphicsContext2D();
        horse2GraphicsContext.setFill(Color.WHITE);
        drawHorse((horse2GraphicsContext));

        Canvas horse3 = new Canvas(500, 75);
        GraphicsContext horse3GraphicsContext = horse3.getGraphicsContext2D();
        horse3GraphicsContext.setFill(Color.WHITE);
        drawHorse((horse3GraphicsContext));

        Canvas horse4 = new Canvas(500, 75);
        GraphicsContext horse4GraphicsContext = horse4.getGraphicsContext2D();
        horse4GraphicsContext.setFill(Color.WHITE);
        drawHorse((horse4GraphicsContext));

        Canvas horse5 = new Canvas(500, 75);
        GraphicsContext horse5GraphicsContext = horse5.getGraphicsContext2D();
        horse5GraphicsContext.setFill(Color.WHITE);
        drawHorse((horse5GraphicsContext));

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

        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }

    private void drawHorse(GraphicsContext gc)
    {
        drawBody(gc);
        drawFrontLegs(gc);
        drawBackLegs(gc);
        drawHead(gc);
    }
    private void drawBody(GraphicsContext gc)
    {
        gc.beginPath();
        gc.moveTo(5, 40);
        gc.lineTo(50, 40);
        gc.lineTo(50, 60);
        gc.lineTo(5, 60);
        gc.lineTo(5, 40);
        gc.stroke();
    }
    private void drawFrontLegs(GraphicsContext gc)
    {
        gc.beginPath();
        gc.moveTo(50, 60);
        gc.lineTo(50, 70);
        gc.lineTo(40, 70);
        gc.lineTo(40, 60);
        gc.stroke();
    }
    private void drawBackLegs(GraphicsContext gc)
    {
        gc.beginPath();
        gc.moveTo(5, 60);
        gc.lineTo(5, 70);
        gc.lineTo(15, 70);
        gc.lineTo(15, 60);
        gc.stroke();
    }
    private void drawHead(GraphicsContext gc)
    {
        gc.beginPath();
        gc.moveTo(45, 40);
        gc.lineTo(45, 30);
        gc.lineTo(65, 30);
        gc.lineTo(65, 40);
        gc.lineTo(45, 40);
        gc.stroke();
    }
}

