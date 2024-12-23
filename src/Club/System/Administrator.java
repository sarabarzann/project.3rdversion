package club.system;

import java.util.Scanner;
import java.time.LocalDate;

public class Administrator extends Staff {

    private int projectsManaged;
    private String jobTitle;

    public Administrator() {
        super();
    }

    public Administrator(int projectsManaged, String jobTitle, LocalDate hireDate, double salary, double baseSalary, int workHours, int memberId, String name, String mobileNo, String gender) {
        super(hireDate, salary, baseSalary, workHours, memberId, name, mobileNo, gender);
        this.projectsManaged = projectsManaged;
        this.jobTitle = jobTitle;
    }

    public int getProjectsManaged() {
        return projectsManaged;
    }

    public void setProjectsManaged(int projectsManaged) {
        this.projectsManaged = projectsManaged;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your job title: ");
        this.setJobTitle(scanner.nextLine());
        System.out.println("Enter the number of projects managed: ");
        this.setProjectsManaged(scanner.nextInt());
    }

    @Override
    public double calculateSalary() {
        return calculateSalary() + (projectsManaged * 200);
    }

    @Override
    public String toString() {
        return String.format("%s\nMember type: Administrator\nJob Title: %s\nProjects Managed: %d\nCalculated Salary: %.2f", 
            super.toString(), 
            jobTitle, 
            projectsManaged, 
            calculateSalary()
        );
    }
}
