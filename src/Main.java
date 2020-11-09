import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * Chad Schadewald
 * Main.java
 * Project 3
 */

/** I can't figure out how to move the horse, so I didn't even get close to working on threading.*/

public class Main extends Application
{
    GridPane gridPane = new GridPane();
    FlowPane flowPane = new FlowPane();

    Group horse1Group = new Group();
    Group horse2Group = new Group();
    Group horse3Group = new Group();
    Group horse4Group = new Group();
    Group horse5Group = new Group();

    Canvas horse1 = new Canvas(500, 75);
    Canvas horse2 = new Canvas(500, 75);
    Canvas horse3 = new Canvas(500, 75);
    Canvas horse4 = new Canvas(500, 75);
    Canvas horse5 = new Canvas(500, 75);

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(0, 10, 0, 10));

        Button startRace = new Button("Start Race");
        Button resetRace = new Button("Reset Race");
        Button exitRace = new Button("Exit Race");

        startRace.setOnAction(new startRaceButtonListener());
        resetRace.setOnAction(new resetRaceButtonListener());
        exitRace.setOnAction(new exitRaceButtonListener());

        GraphicsContext horse1GraphicsContext = horse1.getGraphicsContext2D();
        GraphicsContext horse2GraphicsContext = horse2.getGraphicsContext2D();
        GraphicsContext horse3GraphicsContext = horse3.getGraphicsContext2D();
        GraphicsContext horse4GraphicsContext = horse4.getGraphicsContext2D();
        GraphicsContext horse5GraphicsContext = horse5.getGraphicsContext2D();

        Rectangle[] horse1Array = drawHorse((horse1GraphicsContext));
        Rectangle[] horse2Array = drawHorse((horse2GraphicsContext));
        Rectangle[] horse3Array = drawHorse((horse3GraphicsContext));
        Rectangle[] horse4Array = drawHorse((horse4GraphicsContext));
        Rectangle[] horse5Array = drawHorse((horse5GraphicsContext));

        horse1Group.getChildren().add(horse1);
        horse1Group.getChildren().add(horse1Array[0]);
        horse1Group.getChildren().add(horse1Array[1]);
        horse1Group.getChildren().add(horse1Array[2]);
        horse1Group.getChildren().add(horse1Array[3]);

        horse2Group.getChildren().add(horse2);
        horse2Group.getChildren().add(horse2Array[0]);
        horse2Group.getChildren().add(horse2Array[1]);
        horse2Group.getChildren().add(horse2Array[2]);
        horse2Group.getChildren().add(horse2Array[3]);

        horse3Group.getChildren().add(horse3);
        horse3Group.getChildren().add(horse3Array[0]);
        horse3Group.getChildren().add(horse3Array[1]);
        horse3Group.getChildren().add(horse3Array[2]);
        horse3Group.getChildren().add(horse3Array[3]);

        horse4Group.getChildren().add(horse4);
        horse4Group.getChildren().add(horse4Array[0]);
        horse4Group.getChildren().add(horse4Array[1]);
        horse4Group.getChildren().add(horse4Array[2]);
        horse4Group.getChildren().add(horse4Array[3]);

        horse5Group.getChildren().add(horse5);
        horse5Group.getChildren().add(horse5Array[0]);
        horse5Group.getChildren().add(horse5Array[1]);
        horse5Group.getChildren().add(horse5Array[2]);
        horse5Group.getChildren().add(horse5Array[3]);

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

        primaryStage.setTitle("Welcome to Horse Race!");
        Scene mainScene = new Scene(gridPane);
        primaryStage.setScene(mainScene);

        primaryStage.show();
    }
    private Rectangle[] drawHorse(GraphicsContext gc)
    {
        Rectangle[] horse = new Rectangle[4];
        horse[0] = drawBody(gc);
        horse[1] = drawFrontLegs(gc);
        horse[2] = drawBackLegs(gc);
        horse[3] = drawHead(gc);
        return horse;
    }
    private Rectangle drawBody(GraphicsContext gc)
    {
        gc.rect(5,40,45,20);
        gc.stroke();
        return new Rectangle(5, 40, 45, 20);
    }
    private Rectangle drawFrontLegs(GraphicsContext gc)
    {
        gc.rect(40,60,10,10);
        gc.stroke();
        return new Rectangle(40, 60, 10, 10);
    }
    private Rectangle drawBackLegs(GraphicsContext gc)
    {
        gc.rect(5,60,10,10);
        gc.stroke();
        return new Rectangle(5, 60, 10,10);
    }
    private Rectangle drawHead(GraphicsContext gc)
    {
        gc.rect(45,30,20,10);
        gc.stroke();
        return new Rectangle(45, 30, 20, 10);
    }
    private class startRaceButtonListener implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {   horse1 = new Canvas(500, 75);
            horse1.getGraphicsContext2D().rect(55,30,20,10);
            horse1.getGraphicsContext2D().stroke();
            System.out.println("Start Button Pressed");
        }
    }
    private class resetRaceButtonListener implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            horse1.getGraphicsContext2D().restore();
            System.out.println("Reset Button Pressed");
        }
    }
    private class exitRaceButtonListener implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            System.out.println("Exit Button Pressed");
        }
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}

