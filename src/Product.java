import java.util.*;

public class Product {
    private  int id;
    private String title;

    public void setTitle(String title) {this.title = title;}

    public void setId(int id) {this.id = id;}

    public int getId () {return id;}
    public String getTitle() {return title;}

    Product(int id, String title) {this.id = id;this.title = title;}

    public boolean equals (Object o) {
        if (o == null) return false;
        Product i3 = (Product) o;
        return this.id == i3.id && this.title.equals(i3.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,title);
    }

    public String toString() {
        return id + ": " + title;
    }

//    public int compareTo(Inventory i) {
//    return this.id - i.id;
//    }

    public static Comparator<Product> comparator = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    };
}

