import java.util.*;

public class IManageSystemImpl implements IManageSystem<Food> {

    Map<Food, Double> database = new HashMap<Food, Double>();

    @Override
    public Food save(Food obj, double price) {
        database.put(obj, price);
        return obj;
    }

    @Override
    public Food save(Food obj) {
        database.put(obj, (double) 0);
        return obj;
    }

    @Override
    public void delete(Food obj) {
        database.remove(obj);
    }

    @Override
    public void deleteById(int id) {
        database.keySet().removeIf(e->e.getId() == id);
    }

    @Override
    public Food get(int id) {

        Food res;
        for (Food food : database.keySet()) {
            if(food.getId() == id) {
                res = food;
                return res;
            }
        }
        return null;
    }

    @Override
    public Double getPrice(Food obj) {
        return database.get(obj);
    }

    @Override
    public Set<Food> getProducts() {
        return database.keySet();
    }

    @Override
    public List<Double> getPrices() {
        List<Double> res = new ArrayList<>();
        res.addAll(database.values());
        return res;
    }
}
