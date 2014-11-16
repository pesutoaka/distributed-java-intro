package market;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nn nn on 2014-11-16.
 */
public class Recipient extends Thread{
    public string getRecipientName() {
        return recipientName;
    }

    private string recipientName = UUID.randomUUID();

    private List<Item> items = new ArrayList<Item>(0);

    public void recieveItem(Item item){
        items.add(item);
        try {
            System.out("Winner for auction "+item.getItemName()+" is "+this.getRecipientName());
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000,15001));
        }catch (Exception e){

        }

    }

    private Chairman chairman;

    public Recipient(Chairman chman){
        chairman = chman;
    }

    public void register(){
        if(chairman.registerRecipient(this)){
            System.out("Registering "+this.getRecipientName());
            try{
                Thread.sleep(ThreadLocalRandom.current().nextInt());
            }
        }
    }
}
