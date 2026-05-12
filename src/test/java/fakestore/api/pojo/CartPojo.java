package fakestore.api.pojo;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class CartPojo {
    private int id;
    private int userId;
    private Instant date;
    private List<Product> products;
    int __v = 0;

    public CartPojo() {
    }

    public CartPojo(int id, int userId, Instant date, List<Product> products) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CartPojo cartPojo = (CartPojo) o;
        return id == cartPojo.id && userId == cartPojo.userId && __v == cartPojo.__v && Objects.equals(date, cartPojo.date) && Objects.equals(products, cartPojo.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, date, products, __v);
    }

    @Override
    public String toString() {
        return "CartPojo{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", products=" + products +
                ", __v=" + __v +
                '}';
    }

    public static class Product{
        int productId;
        int quantity;

        public Product() {
        }

        public Product(int productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return productId == product.productId && quantity == product.quantity;
        }

        @Override
        public int hashCode() {
            return Objects.hash(productId, quantity);
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productId=" + productId +
                    ", quantity=" + quantity +
                    '}';
        }
    }
}
