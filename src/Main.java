import javafx.animation.ParallelTransition;
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
import javafx.stage.Stage;
/**
 * Chad Schadewald
 * Main.java
 * Project 3
 */
public class Main extends Application
{
    GridPane gridPane = new GridPane();
    FlowPane flowPane = new FlowPane();

    Button startRace = new Button("Start Race");
    Button resetRace = new Button("Reset Race");
    Button exitRace = new Button("Exit Race");

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

    ParallelTransition track1Transition;
    ParallelTransition track2Transition;
    ParallelTransition track3Transition;
    ParallelTransition track4Transition;
    ParallelTransition track5Transition;

    Horse horse1 = new Horse();
    Horse horse2 = new Horse();
    Horse horse3 = new Horse();
    Horse horse4 = new Horse();
    Horse horse5 = new Horse();

    Transition horse1Transition = new Transition(horse1);
    Transition horse2Transition = new Transition(horse2);
    Transition horse3Transition = new Transition(horse3);
    Transition horse4Transition = new Transition(horse4);
    Transition horse5Transition = new Transition(horse5);

    Thread raceThread;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(0, 10, 0, 10));

        startRace.setOnAction(new startRaceButtonListener());
        resetRace.setOnAction(new resetRaceButtonListener());
        exitRace.setOnAction(new exitRaceButtonListener());

        horse1Group.getChildren().addAll
                (
                        track1,
                        horse1.getBody(),
                        horse1.getHead(),
                        horse1.getFrontLegs(),
                        horse1.getBackLegs()
                );
        horse2Group.getChildren().addAll
                (
                        track2,
                        horse2.getBody(),
                        horse2.getHead(),
                        horse2.getFrontLegs(),
                        horse2.getBackLegs()
                );
        horse3Group.getChildren().addAll
                (
                        track3,
                        horse3.getBody(),
                        horse3.getHead(),
                        horse3.getFrontLegs(),
                        horse3.getBackLegs()
                );
        horse4Group.getChildren().addAll
                (
                        track4,
                        horse4.getBody(),
                        horse4.getHead(),
                        horse4.getFrontLegs(),
                        horse4.getBackLegs()
                );
        horse5Group.getChildren().addAll
                (
                        track5,
                        horse5.getBody(),
                        horse5.getHead(),
                        horse5.getFrontLegs(),
                        horse5.getBackLegs()
                );
        flowPane.setVgap(8);
        flowPane.setHgap(4);
        flowPane.getChildren().add(startRace);
        flowPane.getChildren().add(resetRace);
        flowPane.getChildren().add(exitRace);

        track1Transition = new ParallelTransition
                (
                        horse1Transition.getBodyTransition(),
                        horse1Transition.getHeadTransition(),
                        horse1Transition.getFrontLegTransition(),
                        horse1Transition.getBackLegTransition()
                );
        track2Transition = new ParallelTransition
                (
                        horse2Transition.getBodyTransition(),
                        horse2Transition.getHeadTransition(),
                        horse2Transition.getFrontLegTransition(),
                        horse2Transition.getBackLegTransition()
                );
        track3Transition = new ParallelTransition
                (
                        horse3Transition.getBodyTransition(),
                        horse3Transition.getHeadTransition(),
                        horse3Transition.getFrontLegTransition(),
                        horse3Transition.getBackLegTransition()
                );
        track4Transition = new ParallelTransition
                (
                        horse4Transition.getBodyTransition(),
                        horse4Transition.getHeadTransition(),
                        horse4Transition.getFrontLegTransition(),
                        horse4Transition.getBackLegTransition()
                );
        track5Transition = new ParallelTransition
                (
                        horse5Transition.getBodyTransition(),
                        horse5Transition.getHeadTransition(),
                        horse5Transition.getFrontLegTransition(),
                        horse5Transition.getBackLegTransition()
                );

        track1Transition.setOnFinished(event ->
        {
            System.out.println("Horse 1 is the Winner!");
        });
        track2Transition.setOnFinished(event ->
        {
            System.out.println("Horse 2 is the Winner!");
        });
        track3Transition.setOnFinished(event ->
        {
            System.out.println("Horse 3 is the Winner!");
        });
        track4Transition.setOnFinished(event ->
        {
            System.out.println("Horse 4 is the Winner!");
        });
        track5Transition.setOnFinished(event ->
        {
            System.out.println("Horse 5 is the Winner!");
        });

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
    private class startRaceButtonListener implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            raceThread = new Thread(new RaceRunnable
                    (
                            track1Transition,
                            track2Transition,
                            track3Transition,
                            track4Transition,
                            track5Transition
                    ));
            raceThread.start();
            System.out.println("Start Button Pressed");
        }
    }
    private class resetRaceButtonListener implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            System.out.println("Reset Button Pressed");
        }
    }
    private class exitRaceButtonListener implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            Stage stage = (Stage) exitRace.getScene().getWindow();
            stage.close();
            System.out.println("Exit Button Pressed");
        }
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}

