package market;

/**
 * Created by nn nn on 2014-11-16.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class Donor extends Thread{
    public string getDonorName() {
        return donorName;
    }

    private string donorName = UUID.randomUUID();

    private List<Item> items = new ArrayList<Item>(0);

    private Chairman chairman;

    public Donor(Chairman chman){
        Random r = new Random();
        int capacity = r.nextInt(20) +1;
        for (int i =0;i<capacity;i++){
            items.add(new Item());
        }
        chairman=chman;
    }

    public void donate(){
        while (items.size()!=0){
            Item item = getItem();
            boolean registered=false;
            while (!registered){
                try {
                    registered=chairman.registerItem(item);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(5000,30001));
                }catch (Exception e){

                }
            }
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
            }catch (Exception e){

            }

        }
    }

    public Item getItem(){
        if(items.size()!=0){
            return items.remove(0);
        }
        return null;
    }

}
