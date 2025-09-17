package triolingo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Write_Novel extends Students{
	static List<List<String>> List = new ArrayList<>();
	
	public Write_Novel(){
		while(isWhile_loop()) {
			
			super.show_choice("Write Novel");
			System.out.println("----------------------");
			System.out.print("Enter Your Service: ");
			choice();
			System.out.println("----------------------");
			if(this.getChoice() == 1) {
				List<String> info= new ArrayList<>();
				System.out.println("Characters you created: ");
				readFromFile("characters.txt");
				System.out.println("\n------------------------");
				System.out.println("Plots you created: ");
				readFromFile("plots.txt");
				System.out.println("\n------------------------");
				System.out.print("Novel Name: ");
				String nName = scan.nextLine();
				info.add(nName);
				
				System.out.print("Write your novel: ");
				String novel = scan.nextLine();
				info.add(novel);
				
				List.add(info);
				System.out.println();
				System.out.println("Your story have been stored.");
				System.out.println();
			}else if(getChoice()==2) {
				setWhile_loop(false);
			}
		}
		saveToFile("novels.txt");
	}
	private void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true))) {
            for (List<String> character : List) {
                writer.write(String.join(", ", character));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
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