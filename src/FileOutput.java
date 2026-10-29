import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Schreibe eine Kommandozeilenanwendung, die den Inhalt einer Textdatei ausgibt, sowie eine weitere, die in eine Datei schreiben kann.

 */

public class FileOutput {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        File file = InputValidator.getValidatedFilePath(scanner);
        String fileText;

        try (Scanner fileScanner = new Scanner(file)){
            while (fileScanner.hasNextLine()) {
                fileText = fileScanner.nextLine();
                System.out.println(fileText);
            }

        } catch (FileNotFoundException e) {
            System.out.println(file.getName() + " does not exist");
        }
    }
}
