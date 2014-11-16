package market;

/**
 * Created by nn nn on 2014-11-16.
 */
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Chairman {
    private final BlockingQueue<market.Item> registeredItems = new ArrayBlockingQueue<Item>(10);

    private final BlockingQueue<Recipient> recipients = new ArrayBlockingQueue<Recipient>(10);

    private Item current;

    public Item getRegisteredItem(){
        return registeredItems.take();
    }

    public boolean registerItem(Item item){
        return registeredItems.offer(item);
    }

    public boolean registerRecipient(Recipient recipient){
        return recipients.offer(recipient);
    }

    public Recipient drawRecipient(){
        int size = recipients.size();
        switch (size){
            case 0:
                System.out("There is no winner for "+current.getItemName());
                getRegisteredItem();
                return null;
                break;
            case 1:
                Recipient r = recipients.take();
                r.recieveItem(getRegisteredItem());
                return r;
                break;
            default:
                Random r = new Random();
                Recipient[] f = recipients.toArray();
                Recipient re = f[r.nextInt(size)];
                re.recieveItem(getRegisteredItem());
                return re;
        }
    }
}
