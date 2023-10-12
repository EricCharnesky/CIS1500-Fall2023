public class Main {
    public static void main(String[] args) {

        Item coffee = new Item("Coffee", "123", 1.99, 12);
        System.out.println("The total price of your coffee is: $"
                + coffee.getTotalPrice());
        System.out.println(coffee.toString());
        Item icedCoffee = new Item("Iced Coffee", "123", 2.99, 3);
        System.out.println("The total price of your iced coffee is: $"
                + icedCoffee.getTotalPrice());
        System.out.println(icedCoffee.toString());

        TaxableItem chips = new TaxableItem("Chip", "234", 2.99, 2, .06);
        System.out.println("The total price of your chips is: $"
                + chips.getTotalPrice());
    }
}