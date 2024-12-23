package club.system;
import java.util.ArrayList;
import java.util.Scanner;

public class Players extends Member {
    private String teamName;
    private String position;
    private int gamesPlayed;
    private int gamesWon;
    private Type membershipType;
    private double discountRate;
    private static ArrayList<Players> players = new ArrayList<>();

   
    public enum Type {
        Daily, Monthly, Yearly
    }

    public Players() {
        super();
    }

    public Players(int memberId, String name, String mobileNo, String gender,
                   String teamName, String position, int gamesPlayed, int gamesWon, 
                   Type membershipType) {
        super(memberId, name, mobileNo, gender);
        this.teamName = teamName;
        this.position = position;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.membershipType = membershipType;
        this.discountRate = calculateDiscount();
    }

    private double calculateDiscount() {
        switch (membershipType) {
            case Daily:
                return 0.05; 
            case Monthly:
                return 0.10;
            case Yearly:
                return 0.20; 
            default:
                return 0;
        }
    }

    private double calculateWinRate() {
        if (gamesPlayed == 0) return 0.0;
        return (double) gamesWon / gamesPlayed * 100;
    }

    public Type getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(Type membershipType) {
        this.membershipType = membershipType;
        this.discountRate = calculateDiscount();
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void displayMembershipDetails() {
        System.out.println("Membership Type: " + membershipType);
        System.out.printf("Discount Rate: %.2f%%%n", discountRate * 100);
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Select Membership Type:");
        System.out.println("1. Daily");
        System.out.println("2. Monthly");
        System.out.println("3. Yearly");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                this.membershipType = Type.Daily;
                break;
            case 2:
                this.membershipType = Type.Monthly;
                break;
            case 3:
                this.membershipType = Type.Yearly;
                break;
            default:
                this.membershipType = Type.Daily;
        }
        
        this.discountRate = calculateDiscount();
    }

    @Override
    public String toString() {
        return super.toString() + 
               String.format("\nTeam: %s\nPosition: %s\nGames Played: %d\n" +
               "Games Won: %d\nWin Rate: %.2f%%\n" +
               "Membership Type: %s\nDiscount Rate: %.2f%%", 
               teamName, position, gamesPlayed, gamesWon, 
               calculateWinRate(), membershipType, discountRate * 100);
    }
}