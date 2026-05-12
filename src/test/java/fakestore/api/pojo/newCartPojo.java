package fakestore.api.pojo;

import java.util.List;
import java.util.Objects;

public class newCartPojo {
    int userId;
    List<CartPojo.Product> products;

    public newCartPojo() {
    }

    public newCartPojo(int userId, List<CartPojo.Product> products) {
        this.userId = userId;
        this.products = products;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartPojo.Product> getProducts() {
        return products;
    }

    public void setProducts(List<CartPojo.Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "newCartPojo{" +
                "userId=" + userId +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        newCartPojo that = (newCartPojo) o;
        return userId == that.userId && Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, products);
    }
}
