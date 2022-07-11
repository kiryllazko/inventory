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
        } return null;
    }
    public static Product findById2(List<Product> productList, int id) {
        for (Product i : productList) {
//            найти элемент и вернуть его
            if (i.getId() == id) {
                return i;
            }
        } return null;
    }
    public static int findByTitle(List<Product> products, String title) {
        for (Product i : products) {
            if (i.getTitle().equals(title)) {
               return products.indexOf(i);
            }
        } return -1;
    }
    public static int indexOfProductWithId(List<Product> products,int id) {
        for (Product i : products) {
            if(i.getId() == id) {
                return products.indexOf(i);
            }
        } return -1;
    }
    public static Product find(List<Product> products, String name) {
        for (Product i : products) {
            if (i.getTitle().equals(name)) {
                return i;
            }
        } return null;
    }

    public static Product removeByTitle(List<Product> products,String title) {
       Product product = find(products,title);
       if (product != null) {
           products.remove(product);
           return product;
       } else { return null;}
    }


    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(5,"Яблоко"));
        products.add(new Product(100,"Зубная паста"));
        products.add(new Product(200,"Телевизор"));
        products.add(new Product(300,"Стиральная машина"));

        //1. найти порядковый номер товара "Зубная паста" в этом списке (по названию)
        //2. удалить из списка продукт с названием "Зубная паста" - используя найденный индекс "toothPasteIndex"

        int toothPasteIndex = findByTitle(products,"Яблоко");
        System.out.println(toothPasteIndex);
        products.remove(0);
        System.out.println(products);


        //3. найти порядковый номер товара c id=5
        //4. удалить из списка продукт с id=5  "indexOfProductWithId5"
        int indexOfProductWithId5 = indexOfProductWithId(products,200);
        System.out.println(indexOfProductWithId5);
        products.remove(1);
        System.out.println(products);

        //5. найти в списке продукт с названием
        //6. удалить из списка продукт "washer"
        Product washer = removeByTitle(products,"Стиральная машина");
        System.out.println(products);

        //7. вывести список продуктов - что осталось (id + название)

    }
}

