package triolingo;

public class ST_Dashboard extends User{
	
    public ST_Dashboard(String username, String password) {
        super(username, password);
    }
    @Override
	public void showMenu() {
    	Students stu = new Students();
		
		System.out.println("----------------------");
		System.out.println("WELCOME TO OUR PROGRAM");
		System.out.println("----------------------");
		while(stu.isWhile_loop()) {
			System.out.println("1.Daily Challenges\n2.Character Creation\n3.Plots\n4.Write Novel\n5.View Progress\n6.Log out");
			System.out.println("----------------------");
			System.out.print("Enter Your Service: ");
			stu.choice();
			System.out.println("----------------------");

			if(stu.getChoice() == 1) {
				DailyChallenge daily = new DailyChallenge();
				daily.Daily();
			}else if(stu.getChoice() == 2) {
				characters chara = new characters();
			}else if(stu.getChoice() == 3) {
				plot plot =new plot();
			}else if(stu.getChoice() == 4) {
				Write_Novel nvl = new Write_Novel();
			}else if(stu.getChoice() == 5) {
				progress prog =new progress();
			}else if(stu.getChoice() == 6) {
				System.out.println("Logging out.....\n");
				stu.setWhile_loop(false);
			}else {
				System.out.println("Please choose the valid choice.");
			}
		}
	}
}
