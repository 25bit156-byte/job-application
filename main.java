import java.util.ArrayList;
import java.util.Scanner;

class JobApplication {
    int id;
    String companyName;
    String role;
    String date;
    String status;

    // Constructor
    JobApplication(int id, String companyName,
                   String role, String date, String status) {
        this.id = id;
        this.companyName = companyName;
        this.role = role;
        this.date = date;
        this.status = status;
    }

    // Display application details
    void display() {
        System.out.println("----------------------------");
        System.out.println("Application ID: " + id);
        System.out.println("Company Name: " + companyName);
        System.out.println("Job Role: " + role);
        System.out.println("Application Date: " + date);
        System.out.println("Status: " + status);
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<JobApplication> applications =
            new ArrayList<>();

    static int nextId = 1;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== JOB APPLICATION TRACKING SYSTEM =====");
            System.out.println("1. Add Application");
            System.out.println("2. View Applications");
            System.out.println("3. Search Application");
            System.out.println("4. Update Status");
            System.out.println("5. Delete Application");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addApplication();
                    break;

                case 2:
                    viewApplications();
                    break;

                case 3:
                    searchApplication();
                    break;

                case 4:
                    updateStatus();
                    break;

                case 5:
                    deleteApplication();
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    // Add a new application
    static void addApplication() {
        System.out.print("Enter company name: ");
        String company = sc.nextLine();

        System.out.print("Enter job role: ");
        String role = sc.nextLine();

        System.out.print("Enter application date (DD-MM-YYYY): ");
        String date = sc.nextLine();

        System.out.print("Enter status (Applied/Shortlisted/Rejected/Selected): ");
        String status = sc.nextLine();

        JobApplication app = new JobApplication(
                nextId, company, role, date, status);

        applications.add(app);

        System.out.println("Application added successfully!");
        System.out.println("Your Application ID is: " + nextId);

        nextId++;
    }

    // View all applications
    static void viewApplications() {
        if (applications.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (JobApplication app : applications) {
            app.display();
        }
    }

    // Search an application by ID
    static void searchApplication() {
        System.out.print("Enter Application ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (JobApplication app : applications) {
            if (app.id == id) {
                System.out.println("Application found!");
                app.display();
                return;
            }
        }

        System.out.println("Application not found.");
    }

    // Update application status
    static void updateStatus() {
        System.out.print("Enter Application ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (JobApplication app : applications) {
            if (app.id == id) {
                System.out.print("Enter new status: ");
                app.status = sc.nextLine();

                System.out.println("Status updated successfully!");
                return;
            }
        }

        System.out.println("Application not found.");
    }

    // Delete an application
    static void deleteApplication() {
        System.out.print("Enter Application ID: ");
        int id = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < applications.size(); i++) {
            if (applications.get(i).id == id) {
                applications.remove(i);

                System.out.println("Application deleted successfully!");
                return;
            }
        }

        System.out.println("Application not found.");
    }
}
