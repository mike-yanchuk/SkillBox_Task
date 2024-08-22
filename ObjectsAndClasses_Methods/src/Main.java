public class Main {
    public static void main(String[] args) {
        Basket1 mishaBasket = new Basket1();
        mishaBasket.add("молоко",1);
        mishaBasket.add("товары",10);
        Basket1 dimaBasket = new Basket1();
        dimaBasket.add("Сухарики",100);
        System.out.println("Количетсво всех корзин: " + Basket1.getCountBasket());
        System.out.println("Количетсво всех товаров: " + Basket1.getCount());
        System.out.println("Вся сумма: " + Basket1.getTotalPrice());
        System.out.println("Средняя стоимость всех товаров: " + Basket1.getAverageTotalPrice());
        System.out.println("Средняя стоимость всех корзин: " + Basket1.getAverageTotalPriceBasket());

    }
}
