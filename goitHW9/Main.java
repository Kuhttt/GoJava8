import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User user1 = new User(1, "Pavel", "Ivanov", "Kyiv", 2500);
        User user2 = new User(2, "Ivan", "Petrov", "Lviv", 4500);
        User user3 = new User(3, "Nikoloay", "Slonov", "Charkiv", 1500);
        User user4 = new User(4, "Sergey", "Petrenko", "Kyiv", 2500);
        User user5 = new User(5, "Mihail", "Gorbachov", "Brovary", 2000);
        User user6 = new User(6, "Kiril", "Poliakov", "Mariupol", 500);
        User user7 = new User(7, "Natasha", "Segeeva", "Obuhov", 100);
        User user8 = new User(8, "Olia", "Parasko", "Brovary", 10000);
        User user9 = new User(9, "Oleg", "Gerachenko", "Brovary", 750);
        User user10 = new User(10, "Viktoria", "Kushnir", "Bila Cerkva", 5500);

        Order order1 = new Order(1,2000, Currency.UAH, "Vacuum Cleaner", "Rozetka", user1);
        Order order2 = new Order(2,3500, Currency.UAH, "Nokia phone", "Rozetka", user2);
        Order order3 = new Order(3,1000, Currency.USD, "Gaming mouse", "Citrus", user3);
        Order order4 = new Order(4,200, Currency.UAH, "Data cable", "Repka", user4);
        Order order5 = new Order(5,10, Currency.USD, "Flash disc", "Citrus", user5);
        Order order6 = new Order(6,3500, Currency.UAH, "Smartphone Samsung", "MoYo", user6);
        Order order7 = new Order(7,15000, Currency.UAH, "IPhone6", "Istore", user7);
        Order order8 = new Order(8,3500, Currency.UAH, "Tablet PC", "Rozetka", user8);
        Order order9 = new Order(9,25000, Currency.UAH, "Electro-bike", "MoYo", user9);
        Order order10 = new Order(11,300, Currency.UAH, "Music disc", "Foxtrot", user10);
        Order order11 = new Order(10,300, Currency.UAH, "Music disc", "Foxtrot", user5);
        Order order12 = new Order(10,300, Currency.UAH, "Music disc", "Foxtrot", user7);

        List<Order> listOrders = Arrays.asList(order1, order2, order3, order4, order5, order6, order7, order8, order9,
                order10, order11, order12);
        System.out.println(listOrders);

        System.out.println("отсортируйте список за ценой заказа по убыванию");
        OrderUtils.sortByPriceDescending(listOrders);
        System.out.println(listOrders);

        System.out.println("отсортируйте список за ценой заказа по возрастанию и за городом пользователя");
        OrderUtils.sortByPriceAndUserCity(listOrders);
        System.out.println(listOrders);

        System.out.println("отсортируйте список за наименованием товара, идентификатором заказа, и городом пользователя");
        OrderUtils.sortByItemNameIdUserCity(listOrders);
        System.out.println(listOrders);

        System.out.println("удалите дублированные данные со списка");
        System.out.println(OrderUtils.removeDuplicates(listOrders));

        System.out.println("удалите объекты, где цена меньше 1500");
        System.out.println(OrderUtils.removeOrdeersPriceLess1500(listOrders));

        System.out.println("разделите список на 2 списка - заказы в долларах и в гривнах");
        System.out.println("выводит заказы в долларах");
        System.out.println(OrderUtils.separateUahAndUSDOrders(listOrders).get(Currency.USD));

        System.out.println("выводит заказы в uah");
        System.out.println(OrderUtils.separateUahAndUSDOrders(listOrders).get(Currency.UAH));

        System.out.println("разделите список на столько списков, сколько уникальных городов в User");
        System.out.println(OrderUtils.divideByCities(listOrders));

        System.out.println("проверьте, содержит ли сет заказ, где фамилия пользователя - Petrov");
        String surname = "Petrov";
        System.out.println(OrderUtils.checkSurname(surname, listOrders));

        System.out.println("удалите заказы в USD");
        System.out.println(OrderUtils.deleteCurrencyOrders(listOrders, Currency.USD));
    }
}
