
import java.util.Scanner;

public class PizzaYard_Pvt_Ltd {

    //A simple to method to print the menu to select meat
    private static void MeatMenu() {
        System.out.println("--------------------------------");
        System.out.println("Select your meat Type please ");
        System.out.println("1) Chicken ");
        System.out.println("2) Beef ");
        System.out.println("3) Mutton");
        System.out.println("4) Sea Food");
        System.out.println("9) To check your bill");
        System.out.print("Please enter your option   ");

    }
    //A menu to select additional toppings
    private static void AdditonalMenu() {
        System.out.println("--------------------------------");
        System.out.println("Select 4 additionals");
        System.out.println("1) Cabbage ");
        System.out.println("2) Carrots ");
        System.out.println("3) Extra cheese");
        System.out.println("4) Extra sauce");
        System.out.println("5) Extra Meat");
        System.out.println("6) Spicy");
        System.out.println("7) Garlic Bread");
        System.out.println("8) Thin Crust");
        System.out.println("9) To check your bill");
        System.out.print("Please enter your option   ");

    }

    //A method to select the Pizza type
    private static void PizzaTypeMenu() {
        System.out.println("--------------------------------");
        System.out.println("Select your Pizza type");
        System.out.println("1) Normal Pan pizza ");
        System.out.println("2) Healthy Pan pizza ");
        System.out.println("3) Premium Pan Pizza");
        System.out.print("Please enter your option   ");
    }

    /**
     * A small method to call the viewPrice fucntions on each class
     * @param pizzaType determines the class. 1 being basePizza
     */
    private static void CheckPrice(Integer pizzaType) {
        if (pizzaType == 1) {
            BasePizza.viewPrice();
        }
        if (pizzaType == 2) {
            HealthyPizza.viewPrice();
        }
        if (pizzaType == 3) {
            Preminum_Pizza.viewPrice();
        }
    }

    //The main class
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); //to get user inputs
        Integer breadtype = 0;// to get breadtype 0= whole wheat , 1= kurakkhan
        Integer meatType = 0;// To get the specific meat type requested by customer
        Integer optionalItems = 0; //The amount of toppings each pizza gets
        Integer userItem = 0; // The topping the user selects
        Integer[] items = {0, 0, 0, 0, 0, 0}; //Stores the toppings so it can be accessed later its length is due to the Preminger pizza having 6 toppings
        Integer type = 0; // The pizza type
        Boolean typeChecker = false; //A validity checker for the pizza type
        Boolean meatChecker = false; //A validity checker for the meat type
        Boolean toppingsChecker = false; //A validity checker for the topping type
        Integer counter = 0; //Used to loop the items[] in a while loop
        Double addtionalPrice = 0.00; // The prices of the extra toppings

        BasePizza NormalPizza = new BasePizza(breadtype, meatType, addtionalPrice); //New instance of Pizza
        HealthyPizza HPizza = new HealthyPizza(breadtype, meatType, addtionalPrice); //New Instance of HealthyPizza
        Preminum_Pizza PrePizza = new Preminum_Pizza(breadtype, meatType, addtionalPrice); //New instance of premium Pizza

        System.out.println("Welcome to PizzaYard Private Limited");
        PizzaTypeMenu();
        while (!typeChecker) { //Kept false to loop infinitely around the loop while the condition is met
            try { //A try catch is used to with a NumberFormatException to loop the user until the user enters a Integer
                type = Integer.parseInt(userInput.nextLine()); //Used to further verify the input ( using .nextInt tend to mess with the total at times )
                if (type == 1 | type == 2 | type == 3) { //Permits only inputs 1,2,3
                    typeChecker = true; // Only if the input is 1,3,4 the loop is exited
                } else {
                    System.out.println("Please enter an option in the menu(The number in front of the option)");
                    type = Integer.parseInt(userInput.nextLine()); //Prompts for the next input
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number please");
            }
        }


        MeatMenu();
        while (!meatChecker) {
            try {
                meatType = Integer.parseInt(userInput.nextLine());
                if (meatType == 1 | meatType == 2 | meatType == 3 | meatType == 4) { //Checks only for the 4 meat options given
                    meatChecker = true;
                } else if (meatType == 9) { //The menu option 9 prompts the checkprice function so user can check the price
                    CheckPrice(type);
                } else {
                    System.out.println("Please enter an option in the menu"); //if the integers 1 , 2 ,3 ,4 or 9 is not entered this message will be displayed
                    meatType = Integer.parseInt(userInput.nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number please");
            }
        }

        if (type == 1) { //If the user selects a normal Pizza type
            NormalPizza.setMtype(meatType); //Users meat type is updated for the normal pizza
        }
        if (type == 2) {
            HPizza.setBtype(1); //Bread type is set to 1 to indicate the kurakkhan bread
            HPizza.setMtype(meatType); //Users meat type is updated for the Healthy pizza
        }
        if (type == 3) {
            PrePizza.setMtype(meatType);//Users meat type is updated for the Premium pizza
        }
        //This big function was created in order to add additional toppings into the pizza
        if (type == 2) { // This is for the healthy Pizza ONLY
            AdditonalMenu();
            while (optionalItems < 6) { //Optionalitems set to 6 because healthy gets 6 options
                while (!toppingsChecker) { //Used to validate each and every input. ONLY if the input is validated is true
                    try {
                        userItem = Integer.parseInt(userInput.nextLine()); //gets input
                        //Checks if the inputs are only 1 2 3 4 5 6 7 8 as they are the only options
                        if (userItem == 1 | userItem == 2 | userItem == 3 | userItem == 4 | userItem == 5 | userItem == 6 | userItem == 7 | userItem == 8) {
                            items[optionalItems] = userItem;
                            //User's option [userItem] is added into the array [items] using [optionalItems] as the position as it changes per validated input
                            optionalItems++; // Incremented as the input is validated
                            toppingsChecker = true; //toppingsChecker set to True to exit the loop
                        } else if (userItem == 9) {  //if the input is 9 calls the method to check the price
                            for (int i = 0; i < items.length; i++) { //While in length of the Items Array
                                HPizza.setList(items[i], i);
                                //call the setter of the healthy pizza to set the array containing the additional toppings. Basically transferring the users inputs to the class
                                //Used to update the prices of the toppings so each time a topping is added the price could be checked
                            }
                            CheckPrice(type); //calls to check the price
                            System.out.println("Now enter the ingredients you want");
                        } else {
                            System.out.println("Please enter an option in the menu"); //if the input is not the requested ones
                            meatType = Integer.parseInt(userInput.nextLine());
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number please"); //makes sure only integer is added
                    }
                }
                toppingsChecker = false; //Forcibly changes this to false otherwise the loop wont run as its true
            }
        }
        if (type == 1) {
            AdditonalMenu();
            while (optionalItems < 4) { //Optional items limited to 4
                while (!toppingsChecker) {
                    try {
                        userItem = Integer.parseInt(userInput.nextLine());
                        if (userItem == 1 | userItem == 2 | userItem == 3 | userItem == 4 | userItem == 5 | userItem == 6 | userItem == 7 | userItem == 8) {
                            items[optionalItems] = userItem;
                            optionalItems++;
                            toppingsChecker = true;
                        } else if (userItem == 9) {
                            for (int i = 0; i < items.length; i++) {
                                NormalPizza.setList(items[i], i);
                            }
                            CheckPrice(type);
                            System.out.println("Now enter the ingredients you want");
                        } else {
                            System.out.println("Please enter an option in the menu");
                            meatType = Integer.parseInt(userInput.nextLine());
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a number please");
                    }
                }
                toppingsChecker = false;
            }
        }
        NormalPizza.setPrice(addtionalPrice); //The setter of the class is called and the price is updated
        HPizza.setPrice(addtionalPrice);
        /**
         * Same function as above to send the array to class
         */
        for (int i = 0; i < items.length; i++) {
            HPizza.setList(items[i], i);
            NormalPizza.setList(items[i], i);
        }
        //Diplay the final bill
        CheckPrice(type);


    }

}
