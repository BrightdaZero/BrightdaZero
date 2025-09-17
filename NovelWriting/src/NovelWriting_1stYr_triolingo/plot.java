package triolingo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class plot extends Students{
	static List<List<String>> List = new ArrayList<>();

	public plot(){
		while(isWhile_loop()) {
			List<String> info = new ArrayList<>();
			
			super.show_choice("Plot");
			System.out.println("----------------------");
			System.out.print("Enter Your Service: ");
			choice();
			System.out.println("----------------------");
			if(this.getChoice() == 1) {
				System.out.print("Enter Plot Name: ");
				String pName = scan.nextLine();
				info.add(pName);
				
				
				System.out.print("Enter Your Plot: ");
				String plot = scan.nextLine();
				info.add(plot);
				
				List.add(info);
				System.out.println();
				System.out.println("Your plot have been stored.");
				System.out.println();
			}else if(getChoice()==2) {
				setWhile_loop(false);
			}
		}
		saveToFile("plots.txt");
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
}
