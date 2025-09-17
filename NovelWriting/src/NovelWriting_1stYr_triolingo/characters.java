package triolingo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class characters extends Students{
static List<List<String>> List = new ArrayList<>();
	
	public characters(){
		while(isWhile_loop()) {
			List<String> info = new ArrayList<>();
			
			super.show_choice("Character Creation");
			System.out.println("----------------------");
			System.out.print("Enter Your Service: ");
			choice();
			System.out.println("----------------------");
			if(this.getChoice() == 1) {
				System.out.print("Enter Your Character Name: ");
				String name = scan.nextLine();
				info.add(name);
				
				System.out.print("Enter Your Character Personality: ");
				String persona = scan.nextLine();
				info.add(persona);
				
				System.out.print("Enter Your Character Height: ");
				String height = scan.nextLine();
				info.add(height);
				
				System.out.print("Enter Your Character Role: ");
				String role = scan.nextLine();
				info.add(role);
				List.add(info);
				System.out.println();
				System.out.println("Your character have been stored.");
				System.out.println();
			}else if(getChoice()==2) {
				setWhile_loop(false);
			}
		}
		saveToFile("characters.txt");
		
	}
	private void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (List<String> character : List) {
                writer.write(String.join(", ", character));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
