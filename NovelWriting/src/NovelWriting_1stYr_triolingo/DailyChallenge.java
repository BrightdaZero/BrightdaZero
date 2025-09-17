package triolingo;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailyChallenge {
		
		private ArrayList<String> Challenges; 
		
		private static final String FILE_NAME = "user_response.txt";
		
		private HashMap<String, List<String>> challengeKeywords; 
		
		public DailyChallenge() {
			Challenges = new ArrayList<>(Arrays.asList(
		            "Write a scene from the antagonist's point of view.",
		            "Rewrite a scene from a different character’s perspective.",
		            "Write in second person (You walk into the room...).",
		            "Describe an event from a bystander’s point of view.",
					"Write a short story where the narrator is unreliable.",
					"Retell a classic fairy tale from the villain’s perspective.",
					"Write a scene from an animal’s perspective."
				
		        ));
			
			challengeKeywords = new HashMap<>();
		    challengeKeywords.put("Write a scene from the antagonist's point of view.", Arrays.asList("evil", "villain", "against", "revenge"));
		    challengeKeywords.put("Rewrite a scene from a different character’s perspective.", Arrays.asList("he", "she", "they", "perspective"));
		    challengeKeywords.put("Write in second person (You walk into the room...).", Arrays.asList("you", "your", "yours"));
		    challengeKeywords.put("Describe an event from a bystander’s point of view.", Arrays.asList("watch", "observe", "see", "look"));
		    challengeKeywords.put("Write a short story where the narrator is unreliable.", Arrays.asList("lie", "deceived", "unreliable", "doubt"));    
		    challengeKeywords.put("Retell a classic fairy tale from the villain’s perspective.", Arrays.asList("villain", "misunderstood", "revenge", "jealousy", "deceive", "power", "trick", "fate"));
		    challengeKeywords.put("Write a scene from an animal’s perspective.", Arrays.asList("instinct", "scent", "paws", "Hunger", "territory", "Danger", "survival", "smell", "hear"));	    
			
		}
		
		
		// get Challenge
		public String getChallenge() {
			if (Challenges.isEmpty()) {
				return "No Challenge Available";
			} else {
				return Challenges.get(new Random().nextInt(Challenges.size()));
			}
		}
		
		// to display the menu
		public static void displayMenu() {
	        System.out.println("\n----- Daily Challenge Mode -----");
	        System.out.println("1. Take Daily Challenge");
	        System.out.println("2. View Past Responses & Feedback");
	        System.out.println("3. Quit");
	        System.out.print("Enter your choice: ");
	    }
		
		// to calculate the mark
		public int calculateMark(int wordCount) {
			if (wordCount >= 30 ) return 10;
			if (wordCount >= 20) return 7;
			if (wordCount >= 10) return 4;
			if (wordCount >= 5) return 0;
			return 0;
		}
		
		// to generate the feedback
		public String generateFeedback(int marks) {
			if (marks == 10) return "Excellent work! Your writing is detailed and engaging.";
			if (marks == 7) return "Great effort! Try adding more descriptive details.";
			if (marks == 4) return "Good start! Expand your ideas for better impact.";
			return "Keep practicing! Write more to improve your storytelling.";
		}
		
		// to check the response
		public boolean checkResponse(String challenge, String response) {
		    List<String> keywords = challengeKeywords.get(challenge);

		    // Ensure challenge text matches exactly
		    if (keywords == null) {
		        System.out.println("Warning: No keywords found for challenge - " + challenge);
		        return false;
		    }

		    int matchCount = 0;
		    response = response.toLowerCase(); 

		    for (String keyword : keywords) {
		        if (response.contains(keyword.toLowerCase())) { 
		            matchCount++;
		        }
		    }

		    // Debugging info
		    System.out.println();
		    System.out.println("Checking response for challenge: " + challenge);
		    System.out.println("Expected Keywords: " + keywords);
		    System.out.println("User Response: " + response);
		    System.out.println("Matched Keywords: " + matchCount);
		    System.out.println();

		    return matchCount >= 2;
		}


		
		// saving the response part
		public void saveResponse(String challenge, String response) {
			int wordCount = response.split("\\s+").length;
			int marks = calculateMark(wordCount);
			String feedback = generateFeedback(marks);
				
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME,true));
				writer.write("Challenge: " + challenge);
				writer.newLine();
				writer.write("Response: " + response);
				writer.newLine();
				writer.write("Marks: " + marks + "/10");
				writer.newLine();
				writer.write("Feedback: " + feedback);
				writer.newLine();
				
				writer.newLine();
				writer.write("\n---------------------------------");
				writer.newLine();
				writer.flush();
				System.out.println("Your response has been saved");
				System.out.println("Marks: " + marks + "/10");
				System.out.println("Feedback: " + feedback);
				
				
			} catch (Exception e) {
				System.out.println("Error saving response!");
			}
				
			
		} 
		
		// to see the past response
		public void viewPastResponses() {
		    File file = new File(FILE_NAME);
		    if (!file.exists() || file.length() == 0) {
		        System.out.println("No past responses found.");
		        return;
		    }
		    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
		        String line;
		        System.out.println("\n----- Past Responses & Feedback -----");
		        System.out.println();
		        while ((line = reader.readLine()) != null) {
		            System.out.println(line);
		        }
		    } catch (IOException e) {
		        System.out.println("Error reading past responses.");
		    }
		}
		
		void Daily() {
			DailyChallenge challengeMode = new DailyChallenge();
		    Scanner input = new Scanner(System.in);

		    while (true) {
		        displayMenu();
		        String choice = input.nextLine().trim();
		        System.out.println();

		        switch (choice) {
		        case "1": 
		            String challenge = challengeMode.getChallenge();
		            System.out.println("Your Daily Challenge: " + " '" + challenge + "' " );
		            System.out.print("Your response: ");
		            String response = input.nextLine().trim();
		            
		            boolean isCorrect = challengeMode.checkResponse(challenge, response);
		            
		            while (!isCorrect) { // keep retrying if the response is incorrect
		                System.out.println("Your response may not fully address the challenge.");
		                System.out.print("Would you like to try again? (Y/N): ");
		                String retryChoice = input.nextLine().trim().toLowerCase();

		                if (!retryChoice.equals("y")) {
		                    System.out.println("Skipping this challenge.");
		                    break;  // exit retry loop if the user doesn't want to try again
		                }
		                // go here if we type y
		                System.out.print("Rewrite your response: ");
		                response = input.nextLine().trim();
		                isCorrect = challengeMode.checkResponse(challenge, response);
		            }

		            if (isCorrect) {
		                challengeMode.saveResponse(challenge, response);
		            }

		            break; 

		             
		              
		            case "2": 
		                challengeMode.viewPastResponses();
		                break;

		            case "3":
		                System.out.println("Exit from the Daily Challenge Mode!");
		           
		                return;

		            default:
		                System.out.println("Invalid choice. Enter a valid option");
		        }
		    }
		}

	
}	
	
