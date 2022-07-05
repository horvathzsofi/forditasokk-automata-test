import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandler {

    public String readFile(String fileName) {
        String result = "";
        try {
            File myFile = new File(fileName);
            Scanner readMyFile = new Scanner(myFile);
            while (readMyFile.hasNextLine()) {
                String row = readMyFile.nextLine();
                result += row + "\n";
            }
            readMyFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        return result;
    }

    public void writeFile(String text, String fileName) {
        try {
            FileWriter output = new FileWriter(fileName, true);
            text += "\n";
            output.write(text);
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void deleteFile(String filePath) {
        Path path = Paths.get(filePath);
        try{
            Files.deleteIfExists(path);
        }catch (Exception e){
            System.out.println("An error has occurred.");
        }
    }
}
