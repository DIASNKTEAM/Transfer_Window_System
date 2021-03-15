import controllers.ClubsController;
import entities.Budget;
import entities.Clubs;
import entities.Transfers;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    // constant variables to control all functions
    private final ClubsController controller;

    // constant variable for input system
    private final Scanner scanner;

    // variable to store log inned user
    private Clubs loginnedClub = null;

    // Constructor for creating a new MyApplication
    public MyApplication(ClubsController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }



    // method to start application
    public void start() {
        System.out.println("Hello, champs! This is Transfer Window System!");
        while (true) {
            System.out.println("Write clubname and password in format 'clubname password' to log in");
            try {
                String clubname = scanner.next();
                String password = scanner.next();
                Clubs clubs = controller.getClubs(clubname);
                if (clubs == null) {
                    System.out.println("Incorrect username or password!");
                    continue;
                }
                if (clubs.getClubname().equals(clubname) && clubs.getPassword().equals(password)) {
                    loginnedClub = clubs;
                    // true - admin, false - customer
                    if (loginnedClub.isClub_type()) {
                        // show options for admin
                        adminOptions();
                    }
                    else {
                        // show options for customer
                        customerOptions();
                    }
                }
                else {
                    System.out.println("Incorrect clubname or password!");
                    continue;
                }

            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void adminOptions() {
        while (true) {
            System.out.println("Below you can see functions to use application:");
            System.out.printf("%5s %1s","1:", "Show club information");
            System.out.println();
            System.out.printf("%5s %1s","2:", "Create new club");
            System.out.println();
            System.out.printf("%5s %1s","3:", "Search user by Club name");
            System.out.println();
            System.out.printf("%5s %1s","4:", "Create new admin account");
            System.out.println();
            System.out.printf("%5s %1s","0:", "Log out");
            System.out.println();
            try {
                System.out.print("In order to control, write the number of function:");
                int numberF = scanner.nextInt();
                if (numberF == 1) {
                    showAccountInfo();
                } else if (numberF == 2) {
                    createAccount(false);
                } else if (numberF == 3) {
                    searchUserByUsername();
                } else if (numberF == 4) {
                    createAccount(true);
                } else{
                    return;
                }
            } catch (InputMismatchException i) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("********************************");
        }
    }
    private void showAccountInfo() {
        System.out.println(loginnedClub.getClubInfo());
    }
    private void createAccount(boolean club_type) {
        System.out.println("Write clubname and password in format: 'clubname password'");
        String clubname = scanner.next();
        String password = scanner.next();

        System.out.println("Write the amount of budget and its valuta in format: 'money_amount valuta'");
        int money_amount = scanner.nextInt();
        String valuta = scanner.next();
        Budget budget = new Budget(clubname,money_amount,valuta);

        System.out.println("Write country");
        String country = scanner.next();
        Clubs clubs = new Clubs(clubname, password, club_type, country);
        System.out.println(controller.createClub(clubs));
    }

    private void searchUserByUsername() {
        System.out.println("Write clubname");
        String clubname = scanner.next();
        Clubs clubs = controller.getClubs(clubname);

        System.out.println(clubs.getClubInfo());
    }

    private void customerOptions() {
        while (true) {
            System.out.println("Below you can see functions to use application:");
            System.out.printf("%5s %1s","1:", "Show Club information");
            System.out.println();
            System.out.printf("%5s %1s","2:", "Show Budget information");
            System.out.println();
            System.out.printf("%5s %1s","3:", "Transfer money to another Club");
            System.out.println();
            System.out.printf("%5s %1s","0:", "Log out");
            System.out.println();
            try {
                System.out.print("In order to control, write the number of function:");
                int numberF = scanner.nextInt();
                if (numberF == 1) {
                    showAccountInfo();
                } else if (numberF == 2) {
                    showClubInfo();
                } else if (numberF == 3) {
                    transferMoney();
                }else{
                    return;
                }
            } catch (InputMismatchException i) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("********************************");
        }
    }
    private void showClubInfo() {
        System.out.println(controller.getBudgetInfo(loginnedClub.getClubname()));
    }
    private void transferMoney() {
        System.out.println("Write name of the club which you want to transfer money");
        String to_clubname = scanner.next();
        System.out.println("How much money you want to transfer");
        int money_transferred = scanner.nextInt();

        System.out.println(controller.transferMoney(loginnedClub.getClubname(), to_clubname, money_transferred));
    }
}
