import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // el PIN el sa7 w el attempts
        int correctPin = 1234;
        int attempts = 0;
        boolean loggedIn = false;

        // while loop wa7da 3shan el 3 attempts btoo3 el PIN
        while (attempts < 3 && !loggedIn) {
            System.out.print("Enter 4-digit PIN: ");
            int enteredPin = input.nextInt();

            if (enteredPin == correctPin) {
                loggedIn = true;
            } else {
                attempts++;
            }
        }

        // law el 3 attempts 5elso mn 3'er ma yd5ol sa7
        if (!loggedIn) {
            System.out.println("Your account has been locked.");
            return;
        }

        // initial balance z
        double balance = 2500.75;
        // counter 3shan el bonus
        int totalTransactions = 0;
        int choice = 0;

        // do-while loop for menu
        do {
            System.out.println("========= ATM =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account Status");
            System.out.println("5. Exit");
            System.out.println("=======================");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            // switch statement 3shan el 5 options
            switch (choice) {
                case 1:
                    // 1. Balance
                    System.out.println("Current balance: " + balance);
                    break;

                case 2:
                    // 2. deposit
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = input.nextDouble();

                    if (depositAmount > 0) {
                        balance += depositAmount;
                        totalTransactions++;
                        System.out.println("Updated balance: " + balance);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    // 3. withdraw
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = input.nextDouble();

                    if (withdrawAmount == 0) {
                        System.out.println("Transaction cancelled.");
                    } else if (withdrawAmount < 0) {
                        System.out.println("Invalid amount.");
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdrawAmount;
                        totalTransactions++;
                        System.out.println("Updated balance: " + balance);

                        if (balance == 0) {
                            System.out.println("Warning: Your account is empty.");
                        }
                    }
                    break;

                case 4:
                    // 4. account stats
                    if (balance >= 5000) {
                        System.out.println("VIP Customer");
                    } else if (balance >= 1000) {
                        System.out.println("Regular Customer");
                    } else {
                        System.out.println("Low Balance");
                    }
                    break;

                case 5:
                    // 5. exit
                    System.out.println("Thank you for using our ATM.");
                    System.out.println("Total transactions: " + totalTransactions);
                    break;

                default:
                    // Invalid 
                    System.out.println("Invalid option.");
                    break;
            }

            // el break statement el 3shan n-terminate el loop 3nd option 5
            if (choice == 5) {
                break;
            }

        } while (true);
    }
}
