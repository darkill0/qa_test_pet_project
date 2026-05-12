package fakestore.api.pojo;

import java.util.Objects;

public class NewProductPojo {

    String title;
    float price;
    String description;
    String category;
    String image;

    public NewProductPojo() {
    }

    public NewProductPojo( String title, float price, String description, String category, String image) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
    }




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NewProductPojo that = (NewProductPojo) o;
        return Float.compare(price, that.price) == 0 && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(category, that.category) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, description, category, image);
    }

    @Override
    public String toString() {
        return "NewProductPojo{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
