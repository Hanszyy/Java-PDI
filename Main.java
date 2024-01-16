import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String CSV_FILE_PATH = "First_Nation_Infrastructure_Investment.csv";
    private static final String LOG_FILE_PATH = "log.txt";

    public static void main(String[] args) {
        Project[] projects = loadProjectsFromCSV();
        writeLog("Application started.\n");
        displayOpeningMenu(projects);
        writeLog("Application terminated.\n");
    }

    private static Project[] loadProjectsFromCSV() {
        Project[] projects = new Project[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            int lineNumber = 0;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                if (lineNumber > 0) {
                    String[] data = line.split(",");
                    if (data.length == 10) {
                        String province = data[0];
                        String beneficiary = data[1];
                        int beneficiaryNum = Integer.parseInt(data[2]);
                        String assetClass = data[3];
                        String name = data[4];
                        String description = data[5];
                        String stage = data[6];
                        double latitude = Double.parseDouble(data[7]);
                        double longitude = Double.parseDouble(data[8]);
                        String coordinateSystem = data[9];
                        Location location = new Location(latitude, longitude, coordinateSystem);
                        Project project = new Project(province, beneficiary, beneficiaryNum, assetClass, name, description, stage, location);

                        Project[] newProjects = new Project[projects.length + 1];
                        for (int i = 0; i < projects.length; i++) {
                            newProjects[i] = projects[i];
                        }
                        newProjects[projects.length] = project;
                        projects = newProjects;
                    }
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return projects;
    }


    private static void writeLog(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH, true)) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayOpeningMenu(Project[] projects) {
        System.out.println("Welcome to the Investments in Indigenous community infrastructure Program.");
        System.out.println("There are a total of " + projects.length + " projects throughout Canada.");
        System.out.println("Please make a selection from the Menu below:");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. All of Canada");
            System.out.println("2. Alberta");
            System.out.println("3. British Columbia");
            System.out.println("4. Manitoba");
            System.out.println("5. New Brunswick");
            System.out.println("6. Newfoundland and Labrador");
            System.out.println("7. Nova Scotia");
            System.out.println("8. Ontario");
            System.out.println("9. Prince Edward Island");
            System.out.println("10. Quebec");
            System.out.println("11. Saskatchewan");
            System.out.println("12. Northwest Territories");
            System.out.println("13. Nunavut");
            System.out.println("14. Yukon");
            System.out.println("15. Exit Program");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayCanadaStatistics(projects);
                    break;
                case 2:
                    displayProvinceStatistics("Alberta", projects);
                    break;
                case 3:
                    displayProvinceStatistics("British Columbia", projects);
                    break;
                case 4:
                    displayProvinceStatistics("Manitoba", projects);
                    break;
                case 5:
                    displayProvinceStatistics("New Brunswick", projects);
                    break;
                case 6:
                    displayProvinceStatistics("Newfoundland and Labrador", projects);
                    break;
                case 7:
                    displayProvinceStatistics("Nova Scotia", projects);
                    break;
                case 8:
                    displayProvinceStatistics("Ontario", projects);
                    break;
                case 9:
                    displayProvinceStatistics("Prince Edward Island", projects);
                    break;
                case 10:
                    displayProvinceStatistics("Quebec", projects);
                    break;
                case 11:
                    displayProvinceStatistics("Saskatchewan", projects);
                    break;
                case 12:
                    displayProvinceStatistics("Northwest Territories", projects);
                    break;
                case 13:
                    displayProvinceStatistics("Nunavut", projects);
                    break;
                case 14:
                    displayProvinceStatistics("Yukon", projects);
                    break;
                case 15:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 15);
    }

    private static void displayCanadaStatistics(Project[] projects) {
        int totalProjects = projects.length;
        int ongoingProjects = 0;
        int completedProjects = 0;

        for (Project project : projects) {
            if (project.getStage().equalsIgnoreCase("Ongoing")) {
                ongoingProjects++;
            } else if (project.getStage().equalsIgnoreCase("Completed")) {
                completedProjects++;
            }
        }

        double completedPercentage = (double) completedProjects / totalProjects * 100;

        String totalProjectsMessage = "Total number of projects in Canada: " + totalProjects;
        String ongoingProjectsMessage = "Total number of ongoing projects: " + ongoingProjects;
        String completedProjectsMessage = "Total number of completed projects: " + completedProjects;
        String completedPercentageMessage = "Percentage of completed projects: " + completedPercentage + "%";

        System.out.println(totalProjectsMessage);
        System.out.println(ongoingProjectsMessage);
        System.out.println(completedProjectsMessage);
        System.out.println(completedPercentageMessage);

        writeLog(totalProjectsMessage);
        writeLog(ongoingProjectsMessage);
        writeLog(completedProjectsMessage);
        writeLog(completedPercentageMessage);
    }


    private static void displayProvinceStatistics(String province, Project[] projects) {
        int totalProjects = projects.length;
        int projectsInProvince = 0;
        int ongoingProjects = 0;
        int completedProjects = 0;

        for (Project project : projects) {
            if (project.getProvince().equalsIgnoreCase(province)) {
                projectsInProvince++;
                if (project.getStage().equalsIgnoreCase("Ongoing")) {
                    ongoingProjects++;
                } else if (project.getStage().equalsIgnoreCase("Completed")) {
                    completedProjects++;
                }
            }
        }

        double provincePercentage = (double) projectsInProvince / totalProjects * 100;
        double provinceOngoingPercentage = (double) ongoingProjects / projectsInProvince * 100;
        double provinceCompletedPercentage = (double) completedProjects / projectsInProvince * 100;

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Statistics Menu ---");
            System.out.println("1. Number of projects in " + province);
            System.out.println("2. Percentage of all projects located in " + province);
            System.out.println("3. Total number and percentage of ongoing projects in " + province);
            System.out.println("4. Total number and percentage of completed projects in " + province);
            System.out.println("5. All of the above statistics");
            System.out.println("6. Go back to the main menu");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    String projectsInProvinceMessage = "Number of projects in " + province + ": " + projectsInProvince;
                    System.out.println(projectsInProvinceMessage);
                    writeLog(projectsInProvinceMessage);
                    break;
                case 2:
                    String provincePercentageMessage = "Percentage of all projects located in " + province + ": " + provincePercentage + "%";
                    System.out.println(provincePercentageMessage);
                    writeLog(provincePercentageMessage);
                    break;
                case 3:
                    String ongoingProjectsMessage = "Total number and percentage of ongoing projects in " + province + ": " + ongoingProjects + " (" + provinceOngoingPercentage + "%)";
                    System.out.println(ongoingProjectsMessage);
                    writeLog(ongoingProjectsMessage);
                    break;
                case 4:
                    String completedProjectsMessage = "Total number and percentage of completed projects in " + province + ": " + completedProjects + " (" + provinceCompletedPercentage + "%)";
                    System.out.println(completedProjectsMessage);
                    writeLog(completedProjectsMessage);
                    break;
                case 5:
                    String allStatisticsMessage = "Number of projects in " + province + ": " + projectsInProvince + "\n" +
                            "Percentage of all projects located in " + province + ": " + provincePercentage + "%\n" +
                            "Total number and percentage of ongoing projects in " + province + ": " + ongoingProjects + " (" + provinceOngoingPercentage + "%)\n" +
                            "Total number and percentage of completed projects in " + province + ": " + completedProjects + " (" + provinceCompletedPercentage + "%)";
                    System.out.println(allStatisticsMessage);
                    writeLog(allStatisticsMessage);
                    break;
                case 6:
                    System.out.println("Returning to the main menu...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
}

