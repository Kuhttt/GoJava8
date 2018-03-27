public class Main {
    public static void main(String[] args) {

        IManageSystemImpl manageSystem = new IManageSystemImpl();

        Food banana = new Food("banana", Countries.Canada, 15);
        Food meat = new Food("meat", Countries.Greece, 10);
        Food sugar = new Food("sugar", Countries.Poland, 300);
        Food salo = new Food("salo", Countries.Ukraine, 200);
        Food milk = new Food("milk", Countries.Usa, 5);

        manageSystem.save(banana, 400);
        manageSystem.save(meat, 600);
        manageSystem.save(sugar, 250);
        manageSystem.save(salo, 1000);
        manageSystem.save(milk);

        System.out.println(manageSystem.getProducts());
        System.out.println(manageSystem.getPrices());
        System.out.println("===================");

        manageSystem.delete(milk);
        manageSystem.deleteById(1);

        System.out.println(manageSystem.getProducts());
        System.out.println(manageSystem.getPrices());
        System.out.println("===================");

        System.out.println(manageSystem.get(2));
        System.out.println(manageSystem.getPrice(meat));

    }
}
