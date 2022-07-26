package com.lirik.service;

import com.lirik.exception.DuplicatedException;
import com.lirik.exception.StoreException;
import com.lirik.exception.StoreRuntimeException;
import com.lirik.model.*;

import java.util.*;

public class Store {

    List<Product> products;
    Map<Integer, Product> productsMap;

    public Store(int maxProducts) {
        products = new LinkedList<>();
        productsMap = new HashMap<>();

// инициилизировать объект
        for (int i = 0; i < maxProducts; i++) {
            double r = Math.random();
            Product p = null;

            if (r < 0.33) {
                p = new Tool(i, createTitle());
            } else if (r < 0.66) {
                p = new Food(i, createTitle(), Food.ShelfLife.UNKNOWN);
            } else {
                r = Math.random();
                if (r < 0.5) {
                    p = new CarPart(i, createTitle(), "Volvo", "XC-90", 2022);
                } else {
                    p = new MotorcyclePart(i, createTitle(), "Suzuki", "Ninja", 1995);
                }
            }

            products.add(p);
            productsMap.put(i, p);
        }
        Collections.shuffle(products);
    }

// 3. добавить в объект com.lirik.service.Store метод "com.lirik.model.Product findProductById1(int id)" который вернет первый попавшийся продукт путем перебора списка продуктов
//    public Product findById(int id) {
//        List<Product> productList = productsList;
//        int i = 0;
//        while (i < productList.size()) {
//           Product p = productList.get(i);
//            if (p.getId() == id) {
//                return p;
//            }
//            i++;
//        }
//        return null;
//    }

    // 4. добавить в объект com.lirik.service.Store метод "com.lirik.model.Product findProductById2(int id)" который вернет первый попавшийся продукт по ключу из Map (map.get(id))
    public Product findProductById(int id) {
        Product p = productsMap.get(id);
        return p;
    }

    //Добавь в класс com.lirik.service.Store методы void add(com.lirik.model.Product product) и void delete(int productId) которые будут обрабатывать нештатные ситуации
// добавление продукта с NULL title (нельзя)
// добавление NULL продукта
// добавление продукта с ID который уже есть (тоже нельзя)
    public void add(Product product) throws StoreException {
//        if (product == null) {
//            throw new com.lirik.exception.StoreRuntimeException("Продукт пустой");
//        }
        if (product.getTitle() == null) {
            throw new StoreException("Заполните title");
        }
        if (findProductById(product.getId()) != null) {
            throw new DuplicatedException("такое Id уже есть");
        }
        productsMap.put(product.getId(), product);
        products.add(product);
    }

    // удаление продукта по несуществующему ID
    public void delete(int productId) throws StoreException {
        Product product = findProductById(productId);
        if (product == null) {
            throw new StoreException("несуществующий id");
        }
        products.remove(product);
        productsMap.remove(productId);
    }

    private static String createTitle() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 100; // letter 'z' 122
        int targetStringLength = 3; // 10
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }


    public List<Food> getFood() {
// отфильтровать чтобы в результате была только Food
// getClass().equals()

        List<Food> result = new LinkedList<>();

        for (Product product : products) {
            if (/**проверить является ли продукт Food */product.getClass().equals(Food.class)) {
                result.add((Food) product);
            }
        }
        return result;
    }

    public List<VehiclePart> getVehicleParts() {
// отфильтровать чтобы в результате была только VehicleParts
// instanceof

        List<VehiclePart> result = new LinkedList<>();

        for (Product product : products) {
            if (/**проверить является ли продукт VehiclePart */product instanceof VehiclePart) {
                result.add((VehiclePart) product);
            }
        }
        return result;
    }

    public List<Tool> getTools() {
// отфильтровать чтобы в результате была только Tool
// getClass().isAssignableFrom()

        List<Tool> result = new LinkedList<>();

        for (Product product : products) {
            if (/**проверить является ли продукт Tool */product.getClass().isAssignableFrom(Tool.class)) {
                result.add((Tool) product);
            }
        }

        return result;
    }

    public VehiclePart findPart(int id) {
        Product p = findProductById(id);


        if (/** убедиться что это автозапчасть*/p.getClass().isAssignableFrom(CarPart.class)) {
//            //вернуть как запчасть
            return (VehiclePart) p;
        } else {
            throw new StoreRuntimeException("Это не запчасть!!");
        }
    }

}
