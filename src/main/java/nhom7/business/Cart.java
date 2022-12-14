package nhom7.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    private ArrayList<Game> items;

    public Cart() {
        items = new ArrayList<Game>();
    }

    public ArrayList<Game> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(Game item) {
        String gameName = item.getGameName();
        for (int i = 0; i < items.size(); i++) {
            Game lineItem = items.get(i);
            if (lineItem.getGameName().equals(gameName))
                return;
        }
        items.add(item);
    }

    public void removeItem(Game item) {
        String gameName = item.getGameName();
        for (int i = 0; i < items.size(); i++) {
            Game lineItem = items.get(i);
            if (lineItem.getGameName().equals(gameName)) {
                items.remove(i);
                return;
            }
        }
    }

    public long getTotal(){
        long total = 0;
        for (int i = 0; i < items.size(); i++){
            Game item = items.get(i);
            total += item.getPrice();
        }
        return total;
    }
}
