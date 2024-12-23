package club.system;

import java.util.Scanner;
import java.time.LocalDate;

public class Coach extends Staff {

    private double winBonus;
    private String speciality;
    private int overTime;

    public Coach() {
        super();
    }

    public Coach(double winBonus, String speciality, int overTime, LocalDate hireDate, double salary, double baseSalary, int workHours, int memberId, String name, String mobileNo, String gender) {
        super(hireDate, salary, baseSalary, workHours, memberId, name, mobileNo, gender);
        this.winBonus = winBonus;
        this.speciality = speciality;
        this.overTime = overTime;
    }

    public double getWinBonus() {
        return winBonus;
    }

    public void setWinBonus(double winBonus) {
        this.winBonus = winBonus;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getOverTime() {
        return overTime;
    }

    public void setOverTime(int overTime) {
        this.overTime = overTime;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your speciality: ");
        this.setSpeciality(scanner.nextLine());
        System.out.println("Enter number of overtime hours worked: ");
        this.setOverTime(scanner.nextInt());
        System.out.println("Enter win bonus: ");
        this.setWinBonus(scanner.nextDouble());
    }

    @Override
    public double calculateSalary() {
        return calculateSalary() + (overTime * 100) + winBonus;
    }

    @Override
    public String toString() {
        return String.format("%s\nMember type: Coach\nSpeciality: %s\nOvertime Hours: %d\nWin Bonus: %.2f\nCalculated Salary: %.2f", 
            super.toString(), 
            speciality, 
            overTime, 
            winBonus, 
            calculateSalary()
        );
    }
}
