package triolingo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AuthService {
    private ArrayList<User> users;

    public AuthService() {
        users = new ArrayList<>();
    }

    public boolean registerUser(String username, String password) {
        // Check if the username is already taken in memory
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("❌ Username already taken! Please try another.");
                return false;
            }
        }

        // Check if the username exists in users.txt
        if (isUsernameTaken(username)) {
            System.out.println("❌ Username already exists in file! Please try another.");
            return false;
        }

        User newUser = new ST_Dashboard(username, password);
        users.add(newUser);
        saveToFile("users.txt", newUser);
        System.out.println("🎓 Student account created successfully!");
        return true;
    }

    private boolean isUsernameTaken(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",\s*"); // Split by comma and trim spaces
                if (userData.length >= 1 && userData[0].equals(username)) {
                    return true; // Username already exists
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return false; // Username not found
    }

    public User authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",\s*"); // Split by comma and trim spaces
                if (userData.length == 2) { // Ensure correct format (username, password)
                    String storedUsername = userData[0];
                    String storedPassword = userData[1];

                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        System.out.println("✅ Login successful! Welcome, " + storedUsername + "!");
                        return new ST_Dashboard(username, password);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }

        System.out.println("❌ Invalid username or password! Please try again.");
        return null;
    }

    private void saveToFile(String filename, User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(user.getUsername() + ", " + user.getPassword());
            writer.newLine(); // Move to the next line
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}