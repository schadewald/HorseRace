import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
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
public class Main extends Application
{
    GridPane gridPane = new GridPane();
    FlowPane flowPane = new FlowPane();

    Group horse1Group = new Group();
    Group horse2Group = new Group();
    Group horse3Group = new Group();
    Group horse4Group = new Group();
    Group horse5Group = new Group();

    Canvas track1 = new Canvas(500, 75);
    Canvas track2 = new Canvas(500, 75);
    Canvas track3 = new Canvas(500, 75);
    Canvas track4 = new Canvas(500, 75);
    Canvas track5 = new Canvas(500, 75);

    ParallelTransition parallelTransition;

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

//        GraphicsContext horse1GraphicsContext = track1.getGraphicsContext2D();
//        GraphicsContext horse2GraphicsContext = track2.getGraphicsContext2D();
//        GraphicsContext horse3GraphicsContext = track3.getGraphicsContext2D();
//        GraphicsContext horse4GraphicsContext = track4.getGraphicsContext2D();
//        GraphicsContext horse5GraphicsContext = track5.getGraphicsContext2D();

        Horse horse1 = new Horse();
        Horse horse2 = new Horse();
        Horse horse3 = new Horse();
        Horse horse4 = new Horse();
        Horse horse5 = new Horse();
//        Rectangle[] horse2Array = drawHorse((horse2GraphicsContext));
//        Rectangle[] horse3Array = drawHorse((horse3GraphicsContext));
//        Rectangle[] horse4Array = drawHorse((horse4GraphicsContext));
//        Rectangle[] horse5Array = drawHorse((horse5GraphicsContext));

        horse1Group.getChildren().add(track1);
        horse1Group.getChildren().add(horse1.getBody());
        horse1Group.getChildren().add(horse1.getHead());
        horse1Group.getChildren().add(horse1.getFrontLegs());
        horse1Group.getChildren().add(horse1.getBackLegs());

        horse2Group.getChildren().add(track2);
        horse2Group.getChildren().add(horse2.getBody());
        horse2Group.getChildren().add(horse2.getHead());
        horse2Group.getChildren().add(horse2.getFrontLegs());
        horse2Group.getChildren().add(horse2.getBackLegs());

        horse3Group.getChildren().add(track3);
        horse3Group.getChildren().add(horse3.getBody());
        horse3Group.getChildren().add(horse3.getHead());
        horse3Group.getChildren().add(horse3.getFrontLegs());
        horse3Group.getChildren().add(horse3.getBackLegs());

        horse4Group.getChildren().add(track4);
        horse4Group.getChildren().add(horse4.getBody());
        horse4Group.getChildren().add(horse4.getHead());
        horse4Group.getChildren().add(horse4.getFrontLegs());
        horse4Group.getChildren().add(horse4.getBackLegs());

        horse5Group.getChildren().add(track5);
        horse5Group.getChildren().add(horse5.getBody());
        horse5Group.getChildren().add(horse5.getHead());
        horse5Group.getChildren().add(horse5.getFrontLegs());
        horse5Group.getChildren().add(horse5.getBackLegs());

        flowPane.setVgap(8);
        flowPane.setHgap(4);
        flowPane.getChildren().add(startRace);
        flowPane.getChildren().add(resetRace);
        flowPane.getChildren().add(exitRace);

        TranslateTransition bodyTransition = new TranslateTransition();
        bodyTransition.setDuration(Duration.seconds(5));
        bodyTransition.setToX(420);
        bodyTransition.setNode(horse1.getBody());

        TranslateTransition headTransition = new TranslateTransition();
        headTransition.setDuration(Duration.seconds(5));
        headTransition.setToX(420);
        headTransition.setNode(horse1.getHead());

        TranslateTransition frontLegTransition = new TranslateTransition();
        frontLegTransition.setDuration(Duration.seconds(5));
        frontLegTransition.setToX(420);
        frontLegTransition.setNode(horse1.getFrontLegs());

        TranslateTransition backLegTransition = new TranslateTransition();
        backLegTransition.setDuration(Duration.seconds(5));
        backLegTransition.setToX(420);
        backLegTransition.setNode(horse1.getBackLegs());

        parallelTransition = new ParallelTransition
                (
                        bodyTransition,
                        headTransition,
                        frontLegTransition,
                        backLegTransition
                );
//        parallelTransition.play();

        gridPane.add(horse1Group, 1, 0);
        gridPane.add(horse2Group, 1, 1);
        gridPane.add(horse3Group, 1, 2);
        gridPane.add(horse4Group, 1, 3);
        gridPane.add(horse5Group, 1, 4);
        gridPane.add(flowPane, 1, 5);

        primaryStage.setTitle("Welcome to Horse Race!");
        Scene mainScene = new Scene(gridPane);
        primaryStage.setScene(mainScene);

        primaryStage.show();
    }
//    private Rectangle[] drawHorse(GraphicsContext gc)
//    {
//        Rectangle[] horse = new Rectangle[4];
//        horse[0] = drawBody(gc);
//        horse[1] = drawFrontLegs(gc);
//        horse[2] = drawBackLegs(gc);
//        horse[3] = drawHead(gc);
//        return horse;
//    }
//    private Rectangle drawBody(GraphicsContext gc)
//    {
////        gc.rect(5,40,45,20);
////        gc.stroke();
//        return new Rectangle(5, 40, 45, 20);
//    }
//    private Rectangle drawFrontLegs(GraphicsContext gc)
//    {
////        gc.rect(40,60,10,10);
////        gc.stroke();
//        return new Rectangle(40, 60, 10, 10);
//    }
//    private Rectangle drawBackLegs(GraphicsContext gc)
//    {
////        gc.rect(5,60,10,10);
////        gc.stroke();
//        return new Rectangle(5, 60, 10,10);
//    }
//    private Rectangle drawHead(GraphicsContext gc)
//    {
////        gc.rect(45,30,20,10);
////        gc.stroke();
//        return new Rectangle(45, 30, 20, 10);
//    }
    private class startRaceButtonListener implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            parallelTransition.play();
            System.out.println("Start Button Pressed");
        }
    }
    private class resetRaceButtonListener implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            track1.getGraphicsContext2D().restore();
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

