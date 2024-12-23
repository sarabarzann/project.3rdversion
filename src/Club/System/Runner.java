package club.system;

import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private Scanner scanner;
    private ArrayList<Member> members; 
    private ArrayList<Sports> sportsList;

    public Runner() {
        scanner = new Scanner(System.in);
        members = new ArrayList<>();
        sportsList = new ArrayList<>();
    }

    public void start() {
        System.out.println("Welcome to Ashti Club Management System!");
        mainMenu();
    }
    
    private void mainMenu() {
        while (true) {
            System.out.println("\n--- Ashti Club Main Menu ---");
            System.out.println("1. Member Management (Staff & Players)");
            System.out.println("2. Sports Management");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    memberManagement();
                    break;
                case 2:
                    sportsManagement();
                    break;
                case 3:
                    System.out.println("Thank you for using Ashti Club Management System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void memberManagement() {
        while (true) {
            System.out.println("\n--- Member Management ---");
            System.out.println("1. Add Member (Staff or Player)");
            System.out.println("2. Remove Member");
            System.out.println("3. Update Member");
            System.out.println("4. Display Members");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    removeMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    displayMembers();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addMember() {
        System.out.println("\nChoose Member Type:");
        System.out.println("1. Coach");
        System.out.println("2. Doctor");
        System.out.println("3. Accountant");
        System.out.println("4. Player");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        Member member;
        switch (choice) {
            case 1:
                member = new Coach();
                break;
            case 2:
                member = new Doctor();
                break;
            case 3:
                member = new Accountants();
                break;
            case 4:
                member = new Players();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        member.input(); 
        members.add(member);
        System.out.println("Member added successfully!");
    }

    private void removeMember() {
        System.out.print("Enter Member ID to remove: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); 

        boolean removed = members.removeIf(member -> member.getMemberId() == memberId);
        if (removed) {
            System.out.println("Member removed successfully.");
        } else {
            System.out.println("No member found with the given ID.");
        }
    }

    private void updateMember() {
        System.out.print("Enter Member ID to update: ");
        int memberId = scanner.nextInt();
        scanner.nextLine(); 

        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                member.input(); 
                System.out.println("Member updated successfully!");
                return;
            }
        }
        System.out.println("Member not found.");
    }

    private void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members to display.");
            return;
        }

        for (Member member : members) {
            System.out.println(member);
            System.out.println("---");
        }
    }

    private void sportsManagement() {
        while (true) {
            System.out.println("\n--- Sports Management ---");
            System.out.println("1. Add Sports");
            System.out.println("2. Remove Sports");
            System.out.println("3. Display Sports");
            System.out.println("4. Add Session to Sports");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addSports();
                    break;
                case 2:
                    removeSports();
                    break;
                case 3:
                    displaySports();
                    break;
                case 4:
                    addSessionToSports();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addSports() {
        System.out.println("Choose the type of sport to add:");
        System.out.println("1. Football");
        System.out.println("2. Basketball");
        System.out.println("3. Volleyball");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        Sports sport;

        switch (choice) {
            case 1:
                sport = new Football();
                break;
            case 2:
                sport = new Basketball();
                break;
            case 3:
                sport = new Volleyball();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        sport.input();
        sportsList.add(sport);
        System.out.println(sport.getSportName() + " added successfully!");
    }

    private void removeSports() {
        System.out.print("Enter Sports Name to remove: ");
        String sportName = scanner.nextLine();

        boolean removed = sportsList.removeIf(sport -> sport.getSportName().equalsIgnoreCase(sportName));
        if (removed) {
            System.out.println("Sport removed successfully.");
        } else {
            System.out.println("No sport found with the given name.");
        }
    }

    private void displaySports() {
        if (sportsList.isEmpty()) {
            System.out.println("No sports to display.");
            return;
        }

        for (Sports sport : sportsList) {
            System.out.println(sport);
            System.out.println("---");
        }
    }

    private void addSessionToSports() {
        if (sportsList.isEmpty()) {
            System.out.println("No sports available. Add a sport first.");
            return;
        }

        System.out.println("Choose a sport to add a session:");
        for (int i = 0; i < sportsList.size(); i++) {
            System.out.println((i + 1) + ". " + sportsList.get(i).getSportName());
        }
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice < 1 || choice > sportsList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Sports selectedSport = sportsList.get(choice - 1);
        Session session = new Session();
        session.input();
        selectedSport.addSession(session);
        System.out.println("Session added to " + selectedSport.getSportName() + " successfully!");
    }

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
    }
}
