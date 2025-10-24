import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void Main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "notes.txt";

        System.out.println("📒 Welcome to Notes Manager");
        System.out.println("1. Write a new note");
        System.out.println("2. Read all notes");
        System.out.print("Choose an option (1 or 2): ");

        // Check if input is an integer
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = scanner.nextLine();
                    writeNote(fileName, note);
                    break;
                case 2:
                    readNotes(fileName);
                    break;
                default:
                    System.out.println("❌ Invalid choice");
            }
        } else {
            System.out.println("⚠️ Please enter a valid number (1 or 2).");
        }

        scanner.close();
    }

    public static void writeNote(String fileName, String note) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("✅ Note saved successfully.");
        } catch (IOException e) {
            System.out.println("⚠️ Error writing note: " + e.getMessage());
        }
    }

    public static void readNotes(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("📂 Your Notes:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println
