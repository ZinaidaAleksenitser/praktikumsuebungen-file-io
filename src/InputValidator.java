import java.io.File;
import java.util.Scanner;

public class InputValidator {

    public static File getValidatedFilePath(Scanner scanner){
        return new File(validateDirectoryPath(scanner), validateFileName(scanner));
    }

    public static String validateFileName(Scanner scanner) {
        String fileName;
        boolean valid;
        do{
            System.out.println("Please enter a file name");
            fileName = scanner.nextLine();
            valid = fileName.matches("[A-Za-z0-9_. -]+\\.(txt|csv|xml|html|json|properties|log)");
            if(!valid){
                System.out.println("Invalid file name. Please try again.");
            }
        }
        while (!valid);
        return fileName;
    }

    public static File validateDirectoryPath(Scanner scanner){
        String directoryStr;
        File directory;
        boolean valid;
        do{
            System.out.println("Please enter the directory path:");
            directoryStr = scanner.nextLine();
            //valid = directoryStr.matches("^[a-zA-Z]:\\\\(?:[^\\\\/:*?\"<>|\\r\\n]+\\\\)*[^\\\\/:*?\"<>|\\r\\n]*$");
            directory = new File(directoryStr);
            valid = directory.exists() && directory.isDirectory();
            if(!valid){
                System.out.println("Invalid directory path. Please try again.");
            }
        }
        while (!valid);
        return directory;
    }
}
