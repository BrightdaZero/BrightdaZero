package triolingo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class progress extends Students{

	public progress(){
		
		while(isWhile_loop()) {
			System.out.println("1.Characters\n2.Plots\n3.Novels\n4.Exit");
			System.out.println("----------------------");
			System.out.print("Enter Your Service: ");
			choice();
			System.out.println("----------------------");
			if(getChoice() == 1) {
				System.out.println("These are the characters you created.");
				System.out.println("----------------------");
				readFromFile("characters.txt");
				System.out.println("----------------------");
			}else if(getChoice() == 2) {
				System.out.println("These are the plots you created.");
				System.out.println("----------------------");
				readFromFile("plots.txt");
				System.out.println("----------------------");
			}else if(getChoice() == 3) {
				System.out.println("These are the Storys you writed.");
				System.out.println("----------------------");
				readFromFile("novels.txt");
				System.out.println("----------------------");
			}else if(getChoice() == 4) {
				setWhile_loop(false);
			}else {
					System.out.println();
					System.out.println("INVALID SERVICE. TRY AGAIN");
					System.out.println();
			}
		}
	}
	private void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");
                System.out.print("{");
                for (int i = 0; i < data.length; i++) {
                    System.out.print(data[i]);
                    if (i < data.length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("}");
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
