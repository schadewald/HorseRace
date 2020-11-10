import javafx.animation.TranslateTransition;
import javafx.util.Duration;
/**
 * Chad Schadewald
 * Transition.java
 * Project 3
 */
public class Transition
{
    TranslateTransition bodyTransition = new TranslateTransition();
    TranslateTransition headTransition = new TranslateTransition();
    TranslateTransition frontLegTransition = new TranslateTransition();
    TranslateTransition backLegTransition = new TranslateTransition();

    public Transition(Horse horse)
    {
        bodyTransition.setDuration(Duration.seconds(5));
        bodyTransition.setToX(420);
//        bodyTransition.setRate(2);
        bodyTransition.setNode(horse.getBody());

        headTransition.setDuration(Duration.seconds(5));
        headTransition.setToX(420);
        headTransition.setNode(horse.getHead());

        frontLegTransition.setDuration(Duration.seconds(5));
        frontLegTransition.setToX(420);
        frontLegTransition.setNode(horse.getFrontLegs());

        backLegTransition.setDuration(Duration.seconds(5));
        backLegTransition.setToX(420);
        backLegTransition.setNode(horse.getBackLegs());
    }
    public TranslateTransition getBodyTransition()
    {
        return bodyTransition;
    }
    public TranslateTransition getHeadTransition()
    {
        return headTransition;
    }
    public TranslateTransition getFrontLegTransition()
    {
        return frontLegTransition;
    }
    public TranslateTransition getBackLegTransition()
    {
        return backLegTransition;
    }
}
