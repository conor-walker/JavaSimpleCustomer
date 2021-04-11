package Engine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadDelimitedFile implements InventoryStock{

    private String fileDelimiter = ",";

    public void setFileDelimiter(String fileDelimiter){
        this.fileDelimiter = fileDelimiter;
    }

    public List<String[]> getFileData(String fileName){
        List<String[]> fileData = new ArrayList<String[]>();
        try {
            String filePathPrefix = "src/main/resources/";
            File propertyFile = new File(filePathPrefix + fileName);
            Scanner propertyReader = new Scanner(propertyFile);
            while (propertyReader.hasNextLine()) {
                String fileRow = propertyReader.nextLine();
                fileData.add(fileRow.split(fileDelimiter));
            }
            propertyReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return fileData;
    }
}