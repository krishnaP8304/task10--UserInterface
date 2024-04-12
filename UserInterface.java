import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserInterface {

    public String findPetName(String fileName) {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (countVowels(line) == 2) {
                    return line;
                }
            }

        } catch (FileNotFoundException e) {
            return "Please give the correct file name";
        } catch (IOException e) {
            return "Error occurred while reading the names from file";
        }

        // If no suitable name is found
        return "";
    }

    private int countVowels(String str) {
        int count = 0;
        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String fileName = "names.txt"; // Change this to your file path/name
        UserInterface ui = new UserInterface();
        String petName = ui.findPetName(fileName);
        if (!petName.isEmpty()) {
            System.out.println("Pet's name with exactly 2 vowels: " + petName);
        } else {
            System.out.println("No valid pet name found with exactly 2 vowels in the file.");
        }
    }
}
