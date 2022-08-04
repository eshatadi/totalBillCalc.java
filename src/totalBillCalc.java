import java.util.Scanner;
import java.util.ArrayList;

public class totalBillCalc {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner addItem = new Scanner(System.in);
        Scanner deleteItem = new Scanner(System.in);

        ArrayList<String> itemsArr = new ArrayList();
        ArrayList<Double> costArr = new ArrayList<>();
        ArrayList<Integer> quantityArr = new ArrayList();

        System.out.println("======== TOTAL BILL CALCULATOR ========");
        System.out.println("======== WELCOME! MAIN MENU ===========");
        System.out.println("1 -> ADD ITEM");
        System.out.println("2 -> ITEM REMOVAL(OPTION CURRENTLY NOT AVAILABLE)");
        System.out.println("3 -> CALCULATE BILL TOTAL(OPTION CURRENTLY NOT AVAILABLE)");
        int menuChoice = input.nextInt();

        while(menuChoice != 1 && menuChoice != 2 && menuChoice != 3) {
            System.out.println("INVALID CHOICE");
            System.out.println("PLEASE ENTER A VALID OPTION");
            menuChoice = input.nextInt(); // read user choice input
        }

        do {
            switch(menuChoice) {
                case 1: // ADD ITEM
                    System.out.println("=== ADDING ITEM TO LIST ===");
                    System.out.println("Enter Item: ");
                    String item = addItem.nextLine(); // reads user input
                    itemsArr.add(item); // adds input to an ArrayList

                    System.out.println("Enter Item's Cost: ");
                    double cost = input.nextDouble(); // reads user input

                    System.out.println("Enter Item's Quantity: ");
                    int quantity = input.nextInt(); // reads user input
                    quantityArr.add(quantity); // adds input to an ArrayList
                    costArr.add(cost * quantity); // calculates cost based on quantity

                    break;
                case 2: // DELETE ITEM
                    System.out.println("===== DELETING ITEM FROM LIST =====");
                    System.out.println("WARNING: WILL REMOVE ALL QUANTITIES OF ITEM");
                    System.out.println("Name of Removal Item: ");
                    String delItem = deleteItem.nextLine(); // reads user input

                    for(int i = 0; i < itemsArr.size(); i++) {
                        if(delItem.equals(itemsArr.get(i))) { // if entered string equals an item at certain index
                            itemsArr.remove(delItem); // remove item
                            costArr.remove(i); // remove item cost
                            quantityArr.remove(i); // remove item quantity
                            System.out.println("Item Removal Successful!");
                        }
                    }

                    break;
            }

            if(menuChoice > 0 && menuChoice < 4) {
                System.out.println("======= MAIN MENU =======");
                System.out.println("1 -> Add Item");
                System.out.println("2 -> Delete Item & It's Quantity");
                System.out.println("3 -> Calculate Bill Total");
                menuChoice = input.nextInt();
            }
        } while (menuChoice != 3);

        System.out.println("====== BILL OVERVIEW ======");
        System.out.println("Name     Cost      Quantity");

        // prints summary of bill
        for(int i = 0; i < itemsArr.size(); i++) {
            System.out.format("%-8s $%.2f %4d\n", itemsArr.get(i), costArr.get(i), quantityArr.get(i));
        }

        // calculates final cost
        double cost = 0;
        double finalCost = 0;
        for(int i = 0; i < costArr.size(); i++) {
            cost = costArr.get(i) * quantityArr.get(i); // multiplies cost with quantity
            finalCost += cost; // adds product of cost and quantity to final cost
        }

        // calculates total items
        int finalItems = 0;
        for(int i = 0; i < quantityArr.size(); i++) {
            finalItems += quantityArr.get(i); // adds the quantities
        }

        System.out.println();
        System.out.println("TOTAL ITEMS: " + finalItems);
        System.out.format("TOTAL COST: $%.2f", finalCost);
    }
}