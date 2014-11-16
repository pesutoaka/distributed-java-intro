package market;

/**
 * Created by nn nn on 2014-11-16.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
public class Donor {
    public string getDonorName() {
        return donorName;
    }

    private string donorName = UUID.randomUUID();

    private List<Item> items = new ArrayList<Item>(0);

    public Donor(){
        Random r = new Random();
        int capacity = r.nextInt(20) +1;
        for (int i =0;i<capacity;i++){
            items.add(new Item());
        }
    }

    public Item getItem(){
        if(items.size()!=0){
            return items.remove(0);
        }
        return null;
    }

}
