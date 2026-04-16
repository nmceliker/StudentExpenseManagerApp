import java.util.ArrayList;
import java.util.Scanner;

class StudentExpenseManagerApp {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenseList = new ArrayList<>();

        // main menu
        while (true) {
            System.out.println("\n==== Student Expense Manager ====");
            System.out.println("1. Add Expense");
            System.out.println("2. Add Discounted Expense");
            System.out.println("3. View All Expenses");
            System.out.println("4. Show Total Spending");
            System.out.println("5. Show The Highest Expense");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            double price;
            String name;
            switch (choice) {
                case 1: // add a normal expense
                    System.out.print("You've chosen to add an expense. Enter expense name: ");
                    name = scanner.nextLine();
                    price = DoubleInputCheck.getValidDouble(scanner, "Enter expense price in £ (e.g. 3.50): ");
                    Expense newExpense = new Expense(name, price);
                    expenseList.add(newExpense);
                    newExpense.showInfo();
                    break;
                case 2: //add a discounted expense
                    double discount;
                    System.out.print("You've chosen to add a discounted expense. Enter expense name: ");
                    name = scanner.nextLine();
                    price = DoubleInputCheck.getValidDouble(scanner,
                            "Enter the original price in £ (e.g. 3.50): ");
                    discount = DoubleInputCheck.getValidDouble(scanner,
                            "Enter the discount in percentage (e.g. 10 for 10%): ");
                    if (discount == 0) {
                        System.out.println("Expense is considered to be normal (not discounted).");
                        expenseList.add(new Expense(name, price));
                        System.out.println("Expense added.");
                    } else {
                        DiscountedExpense newDiscountedExpense = new DiscountedExpense(name, price, discount);
                        expenseList.add(newDiscountedExpense);
                        newDiscountedExpense.showInfo();
                    }
                    break;
                case 3: // view all expenses
                    System.out.println("You've chosen to view all expenses.");
                    System.out.println("\nNAME, TYPE, PRICE(£), DISCOUNT(%), DISCOUNTED PRICE(£)");
                    for (Expense x : expenseList) {
                        if (x instanceof DiscountedExpense y) {
                            System.out.println(x.name + ", Discounted,  " + x.price + ", " + y.discountPercent + ", "
                                    + y.getFinalAmount() + ", ");
                        } else {
                            System.out.println(x.name + ", Normal,  " + x.price + ", n/a, n/a");
                        }
                    }
                    break;
                case 4: // show total spending
                    System.out.println("You've chosen to show total spending.");
                    double sum = 0;
                    if (expenseList.isEmpty()) {
                        System.out.print("Total spending is £0, there are no expenses.");
                    } else {
                        for (Expense x : expenseList) {
                            sum += x.getFinalAmount();
                        }
                        System.out.println("Your total spending is £" + sum + ".");
                    }
                    break;
                case 5: // show the highest expense
                    System.out.println("You've chosen to show the highest expense.");
                    if (expenseList.isEmpty()) {
                        System.out.println("There are no expenses.");
                    } else {
                        int max_price_index = 0;
                        for (int i = 0; i < expenseList.size(); i++) {
                            if (expenseList.get(i).getFinalAmount() > expenseList.get(max_price_index).getFinalAmount()) {
                                max_price_index = i;
                            }
                        }
                        System.out.println("Your highest expense is " + expenseList.get(max_price_index).name
                                + " and it costs £" + expenseList.get(max_price_index).getFinalAmount() + ".");
                    }
                    break;
                case 6: // exit
                    System.out.println("Thanks for using Student Expense Manager.");
                    System.exit(0);
                default:
                    System.out.println("Unexpected value: " + choice);
            }
        }

    }
}