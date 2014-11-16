package market;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by nn nn on 2014-11-16.
 */
public class Recipient {
    public string getRecipientName() {
        return recipientName;
    }

    private string recipientName = UUID.randomUUID();

    private List<Item> items = new ArrayList<Item>(0);

    public void recieveItem(Item item){
        items.add(item);
        System.out("Winner for auction "+item.getItemName()+" is "+this.getRecipientName());
    }

    private Chairman chairman;

    public Recipient(Chairman chman){
        chairman = chman;
    }

    public void register(){
        if(chairman.registerRecipient(this)){
            System.out("Registering "+this.getRecipientName());
        }
    }
}
