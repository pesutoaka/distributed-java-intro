package exercise1.equipment;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Paints {
    private int available = 3;
    
    final Lock lock = new ReentrantLock();
    final Condition condition  = lock.newCondition(); 
    
    public void takePaint() throws InterruptedException {
        
        if (available == 0) {
            throw new IllegalStateException("There are no more paints!");
            
        }
        available -= 1;
    }

    public void returnPaint() {
        available += 1;
    }
}
