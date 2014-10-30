package exercise2.equipment;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paints {
    
    private final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(20);

    public String takePaint() throws InterruptedException {
        return bq.poll();
    }

    public void returnPaint(String paint) {
        try {
            bq.offer(paint,100,TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(Paints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
