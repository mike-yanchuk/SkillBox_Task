public class Basket1 {

    public static int totalPrice;
    private static int count;
    private static int countBasket;
    private String items = "";
    private int limit;
    private  static int price;
    public static int averageTotalPrice;

    public static double averageTotalPriceBasket;



    public static void plusCountBasket(){
        countBasket = countBasket + 1;
    }

    private double totalWeight = 0;

    public Basket1() {
        plusCountBasket();
        items = "Список товаров:";
        this.limit = 1000000;
    }



    public Basket1(int limit) {
        this();
        this.limit = limit;
    }

    public Basket1(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = this.totalPrice + totalPrice;
        allTotalPrice(count);
        plusCount(1);
    }




    public void add(String name, int price) {
        add(name, price,1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        this.price = price;

        items = items + "\n" + name + " - " +
                count + " шт. - " + price;
        allTotalPrice(count);
        plusCount(1);
        averageTotalPrice();
        plusAverageTotalPriceBasket();
        System.out.println(getCount());
        System.out.println(getTotalPrice());
        System.out.println(getAverageTotalPrice());

        System.out.println();
    }

    public void add(String name, int price, int count, double weight){
        add(name, price, count);
        totalWeight = totalWeight + weight;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }



    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }

    }
    public double getTotalWeight(){
        return totalWeight;
    }

    public static void plusCount(int count){
       Basket1.count = Basket1.count + count;
    }

    public static void allTotalPrice(int count){
        Basket1.totalPrice = Basket1.totalPrice + count * price;
    }

    public static void averageTotalPrice(){
        averageTotalPrice =  totalPrice / count;
    }

    public static void plusAverageTotalPriceBasket(){
        averageTotalPriceBasket = (double) totalPrice / countBasket;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public static double getAverageTotalPriceBasket() {
        return averageTotalPriceBasket;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }

    public static int getAverageTotalPrice() {
        return averageTotalPrice;
    }

    public static int getCountBasket() {
        return countBasket;
    }

    public static int getCount() {
        return count;
    }
}
