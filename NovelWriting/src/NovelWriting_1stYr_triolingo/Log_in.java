package triolingo;

import java.util.Scanner;

public class Log_in{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();

        while (true) {
            System.out.println("\n🔹 WELCOME TO THE SYSTEM 🔹");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser(scanner, authService);
                    break;
                case 2:
                    User loggedInUser = loginUser(scanner, authService);
                    if (loggedInUser != null) {
                        loggedInUser.showMenu();
                    }
                    break;
                case 3:
                    System.out.println("👋 Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner, AuthService authService) {
        System.out.println("\n📝 REGISTER USER");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();


        boolean success = authService.registerUser(username, password);
        if (success) {
            System.out.println("✅ Registration successful! You can now log in.\n");
        }
    }

    private static User loginUser(Scanner scanner, AuthService authService) {
        System.out.println("\n🔐 LOGIN");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = authService.authenticate(username, password);
        if (user == null) {
            System.out.println("❌ Login failed.");
        }
        return user;
    }
}
