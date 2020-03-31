import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Account> generatedAccounts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Main objectForCallingMethods = new Main();
        boolean condition_1 = false;

        while (condition_1 != true){

        objectForCallingMethods.greeting();

        int option = objectForCallingMethods.takeAnIntegerInput();

        switch (option) {
            case 1:

                System.out.print("Name: ");
                String name = objectForCallingMethods.takeAnStringInput();

                System.out.print("Surname: ");
                String surname = objectForCallingMethods.takeAnStringInput();

                System.out.print("Password you prefer: ");
                String password = objectForCallingMethods.takeAnStringInput();

                Account newAccount = new Account(name, surname, password);
                generatedAccounts.add(newAccount);
                break;

            case 2:
                System.out.println("Please choose account: ");
                for(int i = 0; i < generatedAccounts.size() ; i++) {
                    System.out.print(i+1);
                    System.out.print(". " + generatedAccounts.get(i).getPerson().getName() + " " + generatedAccounts.get(i).getPerson().getSurname());
                    System.out.println();

                }

                int numberOfAccount = objectForCallingMethods.takeAnIntegerInput() - 1;

                Account chosenAccount = generatedAccounts.get(numberOfAccount);

                System.out.println("You have chosen this account: " + chosenAccount.getPerson().getName() + " " + chosenAccount.getPerson().getSurname());


                System.out.println("Please enter the password of the account: ");

                if (chosenAccount.getPassword().equalsIgnoreCase(objectForCallingMethods.takeAnStringInput()) ){
                    System.out.println("Welcome, " + chosenAccount.getPerson().getName() + " " + chosenAccount.getPerson().getSurname() + "!" );
                    boolean condition = false;
                    while(condition != true) {
                        System.out.println("Operations:");
                        System.out.println("[1] Show Balance \n [2] Cash In \n [3] CashOut \n [4] Transfer Money \n [5] Exit Account");
                        int operation = objectForCallingMethods.takeAnIntegerInput();
                        switch (operation){
                            case 1:
                                chosenAccount.showBalance();
                                break;
                            case 2:
                                System.out.println("please enter amount to cash in");
                                chosenAccount.cashIn(objectForCallingMethods.takeAnIntegerInput());
                                chosenAccount.showBalance();
                                break;
                            case 3:
                                System.out.println("please enter amount to cash out");
                                chosenAccount.cashOut(objectForCallingMethods.takeAnIntegerInput());
                                chosenAccount.showBalance();
                                break;
                            case 4:
                                objectForCallingMethods.lister();
                                System.out.println("Choose account to transfer money,then amount of money to transfer");
                                chosenAccount.transferMoney(generatedAccounts.get(objectForCallingMethods.takeAnIntegerInput() - 1) , objectForCallingMethods.takeAnIntegerInput());
                                break;
                            case 5:
                                condition = true;
                                break;
                            default:
                                System.out.println("Invalid enterance");




                        }

                    }


                }else{
                    System.out.println("Wrong password");
                    break;
                }




            case 3:
                System.out.println("Thank you for using");
                condition_1 = true;
                break;

        }

        }

    }

    private void greeting() {
        System.out.println("Welcome");
        System.out.println("[1] create new account");
        System.out.println("[2] login account");
        System.out.println("[3] Exit Sysytem");

    }

    private String takeAnStringInput() {
        String input = scanner.nextLine();
        return input;
    }

    private int takeAnIntegerInput(){
        int n = Integer.parseInt(takeAnStringInput());
        return n;
    }

    private void closeScanner() {
        scanner.close();
    }

    private void lister(){
        for(int i = 0; i < generatedAccounts.size() ; i++) {
            System.out.print(i+1);
            System.out.print(". " + generatedAccounts.get(i).getPerson().getName() + " " + generatedAccounts.get(i).getPerson().getSurname());
            System.out.println();

        }

    }

}