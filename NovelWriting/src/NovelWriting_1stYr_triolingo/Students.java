package triolingo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
	private String features;
	private int choice;
	private boolean while_loop= true;
	
	Scanner scan = new Scanner(System.in);
	
	static List<List<String>> List = new ArrayList<>();
	
	void choice() {
		int choice = Integer.parseInt(scan.nextLine());
		this.setChoice(choice);
	}
	void show_choice(String features) {
		this.setFeatures(features);
		System.out.println("1."+this.getFeatures()+"\n2.Exit");
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public boolean isWhile_loop() {
		return while_loop;
	}
	public void setWhile_loop(boolean while_loop) {
		this.while_loop = while_loop;
	}
}
