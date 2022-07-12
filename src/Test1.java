import java.util.*;

public class Test1 {

//    public static Product findByTitle1(List<Product> productList, String keyword) {
//        return productList.stream() // stream loop
//                .filter(c -> c.getTitle().contains(keyword))
//                .collect(Collectors.toList());
//    }

    public static Product findById1(List<Product> productList, int id) {
        for (int i = 0; i < productList.size(); i++) {
//            найти элемент и вернуть его
            Product find = productList.get(i);
            if (find.getId() == id) {
                return find;
            }
        }
        return null;
    }

    public static Product findById2(List<Product> productList, int id) {
        for (Product i : productList) {
//            найти элемент и вернуть его
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public static int findByTitle(List<Product> products, String title) {
        for (Product i : products) {
            if (i.getTitle().equals(title)) {
                return products.indexOf(i);
            }
        }
        return -1;
    }

    public static int indexOfProductWithId(List<Product> products, int id) {
        for (Product i : products) {
            if (i.getId() == id) {
                return products.indexOf(i);
            }
        }
        return -1;
    }

    public static Product find(List<Product> products, String name) {
        for (Product i : products) {
            if (i.getTitle().equals(name)) {
                return i;
            }
        }
        return null;
    }

    public static Product removeByTitle(List<Product> products, String title) {
        Product product = find(products, title);
        if (product != null) {
            products.remove(product);
            return product;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(5, "Яблоко"));
        products.add(new Product(100, "Зубная паста"));
        products.add(new Product(200, "Телевизор"));
        products.add(new Product(300, "Стиральная машина"));


        Collections.shuffle(products);  //перетасовать товары в списке. каждый раз они будут по-разному
//1. найти порядковый номер товара "Зубная паста" в этом списке (по названию)
        int toothPasteIndex = -1;
        String name = "Зубная паста";

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getTitle().equals(name)) {
                toothPasteIndex = i;
            }
        }
        System.out.println(toothPasteIndex);

        toothPasteIndex = -1;
        int k = 0;
        while(k < products.size() && toothPasteIndex == -1) {
            Product p = products.get(k);
            if (p.getTitle().equals(name)) {
               toothPasteIndex = k;
            }
            k++;
        }
       System.out.println("Порядковый номер товара `Зубная паста`: "+ toothPasteIndex);

//2. удалить из списка продукт с названием "Зубная паста" - используя найденный индекс "toothPasteIndex"
//        products.... удалить зубную пасту
        products.remove(toothPasteIndex);



//3. найти порядковый номер товара c id=5
        int productId5 = 5;
        int indexOfProductWithId5 = -1;
        int i = 0;
        while (i < products.size() && indexOfProductWithId5 == -1) {
            Product p = products.get(i);
            if (p.getId() == productId5) {
                indexOfProductWithId5 = i;
            }
            i++;
        }
        System.out.println("Порядковый номер продукта с ID=5: "+ indexOfProductWithId5);
        System.out.println(products);

//4. удалить из списка продукт с id=5  "indexOfProductWithId5"

         int id = 5;
         i = 0;
         boolean removed = false;
         while (i < products.size() && !removed) {
             Product p = products.get(i);
             if (p.getId() == id) {
                 products.remove(i);
                 removed = true;
                 //Лучше ли использовать brake?
             }
             i ++;
         }
            System.out.println(products);

//5. найти в списке продукт с названием
        name = "Стиральная машина";
        int index = -1;

        for (int t = 0; t < products.size(); t++) {
            Product p = products.get(t);
            if (p.getTitle().equals(name)) {
                System.out.println(p);
                index = t;
            }
        }

        products.remove(index);
        System.out.println(products);
//6. удалить из списка продукт "washer"
//        for (int i = 0; i < products.size(); i++) {
//            Product p = products.get(i);
//            if (p.getTitle().equals(name)) {
//                products.remove(p);
//            }
//        }
//
//7. вывести список продуктов - что осталось (id + название)
        for (Product e : products) {
            System.out.println(e.getId() + ", " + e.getTitle());
        }
    }
}

