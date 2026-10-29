import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*Schreibe eine Kommandozeilenanwendung, die den Inhalt einer Textdatei ausgibt, sowie eine weitere, die in eine Datei schreiben kann.

 */

public class FileInput {

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the text:_");
        String userText = scanner.nextLine();
        boolean append = askToAppendText(scanner);
        File filePath = InputValidator.getValidatedFilePath(scanner);

        if(!filePath.exists()) {
            createNewFile(filePath, scanner);
        }

        try (FileWriter fileWriter = new FileWriter(filePath, append)){
            fileWriter.write(userText + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred " + e);
        }
        scanner.close();
    }

    private static void createNewFile(File filePath, Scanner scanner) {
        System.out.println("File does not exist");
        System.out.println("Do you want to create a new file? (Y/N)");
        String createFile = scanner.nextLine().trim();
        if (createFile.equalsIgnoreCase("y")) {
            try {
                if(filePath.createNewFile()) {
                    System.out.println("The new file was create " + filePath.getAbsolutePath());
                }
                else System.out.println("The file cannot be created");
            } catch (IOException e) {
                System.out.println("An error occurred: ");
                e.printStackTrace();
            }
        }
    }

    static boolean askToAppendText(Scanner scanner) {

        String userAnswer;
        while (true) {
            System.out.println("Do you want to append text to the file? (Y/N)");
            userAnswer = scanner.nextLine().trim();
            if (userAnswer.equalsIgnoreCase("Y")) return true;
            if (userAnswer.equalsIgnoreCase("N")) return false;
            else System.out.println("Please enter Y or N.");
        }
    }
}
