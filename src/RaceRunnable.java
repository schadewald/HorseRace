import javafx.animation.ParallelTransition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RaceRunnable implements Runnable
{
    int waitTime = (int)(Math.random() * (500 - 100 + 1) + 100);
    ArrayList<ParallelTransition> tracks = new ArrayList<>(5);
    public RaceRunnable
            (
                    ParallelTransition track1,
                    ParallelTransition track2,
                    ParallelTransition track3,
                    ParallelTransition track4,
                    ParallelTransition track5
            )
    {
        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);
        tracks.add(track4);
        tracks.add(track5);
    }

    @Override
    public void run()
    {
        Collections.shuffle(tracks);
        for (ParallelTransition track : tracks) {
            track.play();
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ;
    }
}
