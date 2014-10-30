package exercise2.equipment;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Brushes {

    private final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(20);
    
    public String takeBrush() throws InterruptedException {
        return bq.poll();
    }

    public void returnBrush(String brush) {
        try {
            bq.offer(brush,100,TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(Brushes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
