public class TaxableItem extends Item {
    private double taxRate;

    public TaxableItem(String name, String sku, double price, int quantity, double taxRate) {
        // the first thing you have to do in a subclass constructor,
        // is call the super class constructor
        super(name, sku, price, quantity);
        setTaxRate(taxRate);
    }

    @Override
    public double getTotalPrice(){
        return getPrice() * getQuantity() * ( 1 + taxRate );
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        if (taxRate < 0) {
            this.taxRate = 0;
        } else {
            this.taxRate = taxRate;
        }
    }
}
