package Engine;

import java.util.ArrayList;
import java.util.List;

public class ReadDelimitedFileFake implements InventoryStock{

    public List<String[]> getFileData(String fileName){
        List<String[]> fakeData = new ArrayList<>();
        fakeData.add(new String[]{"test1", "test2", "test3", "test4"});
        fakeData.add(new String[]{"test5", "test6", "test7", "test8"});
        return fakeData;
    }

}
