import java.util.Timer;
import java.util.TimerTask;

/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

 public class DrawLoop {
    Timer timer;
    int frameRate = 60;

    public void init(int seconds, TimerTask RemindTask) {
        timer = new Timer();
        timer.schedule(RemindTask, 1000, 1000);
	}
}