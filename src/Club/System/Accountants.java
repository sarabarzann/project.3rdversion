package club.system;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class Accountants extends Staff {

    private ArrayList<Staff> staffList;

    public Accountants() {
        super();
        this.staffList = new ArrayList<>();
    }

    public Accountants(LocalDate hireDate, double salary, double baseSalary, int workHours, int memberId, String name, String mobileNo, String gender) {
        super(hireDate, salary, baseSalary, workHours, memberId, name, mobileNo, gender);
        this.staffList = new ArrayList<>();
    }

    public void addStaff(Staff staff) {
        staffList.add(staff);
        System.out.println("Staff added: " + staff.toString());
    }

    public double calculateTotalSalary() {
        double total = 0;
        for (Staff staff : staffList) {
            total += staff.calculateSalary();
        }
        return total;
    }

    public void displayPayroll() {
        System.out.println("Payroll Details:");
        for (Staff staff : staffList) {
            System.out.println("Name: " + staff.getName());
            System.out.println("Role: " + staff.getClass().getSimpleName());
            System.out.printf("Salary: %.2f%n", staff.calculateSalary());
            System.out.println("---");
        }
        System.out.printf("Total Payroll: %.2f%n", calculateTotalSalary());
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter additional details for the accountant: ");
       
    }

    @Override
    public double calculateSalary() {
    
        return calculateSalary();
    }

    @Override
    public String toString() {
        return String.format("%s\nMember type: Accountants\nNumber of Staff Managed: %d\nTotal Payroll Amount: %.2f", 
            super.toString(), 
            staffList.size(), 
            calculateTotalSalary()
        );
    }
}
