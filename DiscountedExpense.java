// expense subclass with an additional discount attribute
class DiscountedExpense extends Expense {
    double discountPercent;

    public DiscountedExpense(String name, double price, double discountPercent) {
        super(name, price);
        this.discountPercent = discountPercent;
    }

    public double getFinalAmount() {

        return price - ((price * discountPercent) / 100);
    }

    public void showInfo() {
        System.out.println("You've added " + name + " which costs £" + String.format("%.2f", price) +
                " with a discount of " + discountPercent + "% to the expense list.");
    }
}