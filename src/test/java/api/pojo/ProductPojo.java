package api.pojo;

import java.util.Objects;

public class ProductPojo {
    private Integer id;
    private  String   name;
    private  Integer   year;
    private  String     color;
    private String  pantone_value;


    public ProductPojo() {
    }

    public ProductPojo(Integer id, String name, Integer year, String color, String pantone_value) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantone_value = pantone_value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPantone_value() {
        return pantone_value;
    }

    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductPojo that = (ProductPojo) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(year, that.year) && Objects.equals(color, that.color) && Objects.equals(pantone_value, that.pantone_value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, color, pantone_value);
    }

    @Override
    public String toString() {
        return "ProductPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", color='" + color + '\'' +
                ", pantone_value='" + pantone_value + '\'' +
                '}';
    }
}
