public class HealthyPizza {
    private static Integer breadType = 0;
    private static Integer meat = 0;
    private static Double price = 0.0;
    private static Integer[] list = {0, 0, 0, 0, 0, 0};
    private static Integer counter = 0;

    /**
     * default constructor
     */
    public HealthyPizza(){

    }


    /**
     * Constructor
     * @param bread The type of bread
     * @param meatType The type of meat
     * @param currentPrice The price
     */
    public HealthyPizza(Integer bread, Integer meatType, Double currentPrice) {
        this.breadType = bread;
        this.meat = meatType;
        this.price = currentPrice;
    }

    /**
     * Set the bread type
     * @param breadType 0 for whole wheat/ 1 for kurakhan
     */
    public void setBtype(Integer breadType) {
        this.breadType = breadType;
    }

    /**
     * Set the meat type
     * @param meat the meat variety depends on the user's input
     */
    public void setMtype(Integer meat) {
        this.meat = meat;
    }

    /**
     * Setter for the Price
     * @param addprice price
     */
    public void setPrice(Double addprice) {
        this.price = addprice;
    }

    /**
     * Used to put items into the list in the class
     * @param addOnItem The item code ( 1 for cabbage and so on )
     * @param position The index in the array
     */
    public void setList(Integer addOnItem, Integer position) {
        this.list[position] = addOnItem;
    }

    /**
     * Get the bread type
     * @return bread type
     */
    public Integer getBtype() {
        return breadType;
    }

    /**
     * Get the meat type
     * @return meat type
     */
    public Integer getMtype() {
        return meat;
    }

    /**
     * Get the price
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Gets the item in a certain position in the array
     * @param position  Position of the item
     * @return the item
     */
    public static Integer getList(Integer position) {
        return list[position];
    }

    /**
     * This is a fucntion used to calculate and display the price
     */
    public static void viewPrice() {
        price=0.0;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("This is your Bill till now");
        System.out.println("Kurakhan bread-----------$3.00");
        price =price + 3.00; //Adds 3 to the total price as the bread cost
        switch (meat) {
            case 1:
                System.out.println("Chicken-----------$5.00");
                price = price + 5.00; //adds the price corresponding to the meat type
                break;
            case 2:
                System.out.println("Beef-----------$6.00");
                price = price + 6.00;
                break;
            case 3:
                System.out.println("Mutton-----------$8.00");
                price = price + 8.00;
                break;
            case 4:
                System.out.println("Seafood-----------$6.50");
                price = price + 6.50;
                break;
        }

        while (counter < 6) { //the maximum amount of toppings
            Integer listItem = getList(counter); //each item is gotten to the var listItem  via a getter to get it properly
            switch (listItem) {
                case 1:
                    System.out.println("Cabbage-----------$ 2.89");
                    price = price + 2.89; //adds the price corresponding to the Topping price
                    break;
                case 2:
                    System.out.println("Carrots-----------$3.5");
                    price = price + 3.5;
                    break;
                case 3:
                    System.out.println("Extra cheese-----------$4.9");
                    price = price + 4.9;
                    break;
                case 4:
                    System.out.println("Extra sauce-----------$1.69");
                    price = price + 1.69;
                    break;
                case 5:
                    System.out.println("Extra Meat-----------$9.25");
                    price = price + 9.25;
                    break;
                case 6:
                    System.out.println("Spicy-----------$2.22");
                    price = price + 2.22;
                    break;
                case 7:
                    System.out.println("Garlic Bread-----------$4.65");
                    price = price + 4.65;
                    break;
                case 8:
                    System.out.println("Thin Crust-----------$5.60");
                    price = price + 5.6;
                    break;
            }
            counter = counter + 1;
        }

    counter =0;
        System.out.println();
        System.out.println(("The grand Total of your bill is......")+price);
        System.out.println("-----------------------------------------------------------------");


}

}

