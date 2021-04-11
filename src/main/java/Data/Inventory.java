package Data;

import java.util.List;

public interface Inventory {
    List<Book> getAllInventory();

    int getSize();
}
