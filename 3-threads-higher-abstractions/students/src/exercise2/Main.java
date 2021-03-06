package exercise2;

import exercise2.equipment.Brushes;
import exercise2.equipment.Paints;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Paints paints = new Paints();
        Brushes brushes = new Brushes();
        paints.returnPaint("black");
        paints.returnPaint("yellow");
        paints.returnPaint("green");
        paints.returnPaint("whatever");
        paints.returnPaint("red");
        paints.returnPaint("white");

        brushes.returnBrush("1");
        brushes.returnBrush("2");
        brushes.returnBrush("3");
        brushes.returnBrush("4");
        brushes.returnBrush("5");
        brushes.returnBrush("6");
        
        ExecutorService executors = Executors.newCachedThreadPool();
        for (int i = 0; i < 32; ++i) {
            executors.execute(new Painter(paints, brushes));
        }
        executors.shutdown();
        executors.awaitTermination(30, TimeUnit.SECONDS);
    }
}
