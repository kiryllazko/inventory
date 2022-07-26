import com.lirik.exception.StoreException;
import com.lirik.model.CarPart;
import com.lirik.model.Food;
import com.lirik.model.Tool;
import com.lirik.model.VehiclePart;
import com.lirik.service.Store;

import java.util.List;

public class Main {

    public static void main(String[] args) throws StoreException {
        Store store = new Store(1000);


        List<VehiclePart> parts = store.getVehicleParts();
        System.out.println(parts.size());


        List<Food> foods = store.getFood();
        System.out.println(foods.size());

        List<Tool> tools = store.getTools();
        System.out.println(tools.size());

        store.add(new CarPart(1001, "part", "Honda", "Civic", 2020));

        VehiclePart bumper = store.findPart(1001);
        System.out.println(bumper);


//        Food f1 = new Food(123,"Батончик Марс",Food.ShelfLife.NON_PERISHABLE);
//        Food f2 = new Food(124,"Пакет Сметаны 200гр", Food.ShelfLife.PERISHABLE);
//
//        boolean isPerishable = (f2.getShelfLife()==Food.ShelfLife.PERISHABLE);
//        System.out.println("Продукт скоропортящийся: "+isPerishable);
    }
}
