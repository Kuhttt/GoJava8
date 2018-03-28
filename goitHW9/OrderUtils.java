import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderUtils {

    public static void sortByPriceDescending(List<Order> list){
        list.sort((o1, o2)->o2.getPrice() - o1.getPrice());
    }

    public static void sortByPriceAndUserCity(List<Order> list){
        list.sort((o1, o2)->{
            if (o1.getPrice() == o2.getPrice()) {
                return o1.getUser().getCity().compareTo(o2.getUser().getCity());
            }
            else {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }

    public static void sortByItemNameIdUserCity(List<Order> list){
        list.sort((o1, o2)->{
            if (o1.getItemName().equals(o2.getItemName())) {
                if (o1.getId() == o2.getId()) {
                    return o1.getUser().getCity().compareTo(o2.getUser().getCity());
                }
                else {
                    return Long.compare(o1.getId(), o2.getId());
                }
            }
            else {
                return o1.getItemName().compareTo(o2.getItemName());
            }
        });
    }

    public static List<Order> removeDuplicates(List<Order> listOrders) {
        Stream<Order> streamOrders = listOrders.stream();
        return streamOrders.distinct().collect(Collectors.toList());
    }

    public static List<Order> removeOrdeersPriceLess1500(List<Order> listOrders) {
        int minimumPrice = 1500;
        Stream<Order> streamOrders = listOrders.stream();
        return streamOrders.filter(o->o.getPrice() >= minimumPrice).collect(Collectors.toList());
    }

    public static Map<Currency, List<Order>> separateUahAndUSDOrders(List<Order> listOrders) {
        Stream<Order> streamOrders = listOrders.stream();
        Map<Currency,List<Order>> mapOfOrdersWithDifferentCurrencies = new HashMap<>();
        mapOfOrdersWithDifferentCurrencies.put(Currency.UAH,streamOrders.filter(o->o.getCurrency() == Currency.UAH).collect(Collectors.toList()) );

        Stream<Order> streamOrders1 = listOrders.stream();
        mapOfOrdersWithDifferentCurrencies.put(Currency.USD,streamOrders1.filter(o->o.getCurrency() == Currency.USD).collect(Collectors.toList()) );
        return mapOfOrdersWithDifferentCurrencies;
    }

    public static Map<String, List<Order>> divideByCities(List<Order> listOrders) {
        return listOrders.stream().collect(Collectors.groupingBy(o->o.getUser().getCity()));
    }

    public static boolean checkSurname(String surname, List<Order> listOrders) {
        return listOrders.stream().filter(o->o.getUser().getLastName().equals(surname)).count() > 0;
    }

    public static List<Order> deleteCurrencyOrders(List<Order> listOrders, Currency currency) {
        return listOrders.stream().filter(o-> (o.getCurrency() != currency)).collect(Collectors.toList());
    }

}
