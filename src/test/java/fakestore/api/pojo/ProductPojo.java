package fakestore.api.pojo;

import java.util.Map;
import java.util.Objects;

public class ProductPojo {
    int id;
    String title;
    float price;
    String description;
    String category;
    String image;
    RatingPojo rating;

    public ProductPojo() {
    }

    public int getId() {
        return id;
    }

    public ProductPojo(int id, String title, float price, String description, String category, String image, RatingPojo rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
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

    public RatingPojo getRating() {
        return rating;
    }

    public void setRating(RatingPojo rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductPojo that = (ProductPojo) o;
        return id == that.id && Float.compare(price, that.price) == 0 && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(category, that.category) && Objects.equals(image, that.image) && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, category, image, rating);
    }

    @Override
    public String toString() {
        return "ProductPojo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                '}';
    }

    public static class RatingPojo {
        float rate;
        int count;

        public RatingPojo() {
        }

        public RatingPojo(int count, float rate) {
            this.count = count;
            this.rate = rate;
        }

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            RatingPojo that = (RatingPojo) o;
            return Float.compare(rate, that.rate) == 0 && count == that.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rate, count);
        }

        @Override
        public String toString() {
            return "RatingPojo{" +
                    "rate=" + rate +
                    ", count=" + count +
                    '}';
        }
    }


}
