// normal non discounted expense
class Expense {
    String name;
    double price;

    public Expense(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getFinalAmount() {

        return price;
    }

    public void showInfo() {
        System.out.println("You've added " + name + " which costs £" + String.format("%.2f", price) +
                " to the expense list.");
    }
}