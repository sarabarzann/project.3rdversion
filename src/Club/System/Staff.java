package club.system;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Staff extends Member {

    private LocalDate hireDate;
    private double salary;
    private double baseSalary;
    private int workHours;

    public Staff() {
        super();
    }

    public Staff(LocalDate hireDate, double salary, double baseSalary, int workHours,
                 int memberId, String name, String mobileNo, String gender) {
        super(memberId, name, mobileNo, gender);
        this.hireDate = hireDate;
        this.salary = salary;
        this.baseSalary = baseSalary;
        this.workHours = workHours;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public abstract double calculateSalary();

    @Override
    public void input() {
        super.input(); 
        Scanner input = new Scanner(System.in);

        System.out.print("Enter salary: ");
        salary = input.nextDouble();

        System.out.print("Enter base salary: ");
        baseSalary = input.nextDouble();

        System.out.print("Enter work hours: ");
        workHours = input.nextInt();

        hireDate = LocalDate.of(2023, 5, 1); 
       
        System.out.println("Hired Date: "+ hireDate);
    }

    @Override
    public String toString() {
        return String.format(
            "%s\nHire Date: %s\nSalary: %.2f\nBase Salary: %.2f\nWork Hours: %d",
            super.toString(),
            hireDate,
            salary,
            baseSalary,
            workHours
        );
    }
}
