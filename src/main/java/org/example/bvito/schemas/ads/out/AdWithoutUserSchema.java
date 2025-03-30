package org.example.bvito.schemas.ads.out;

import org.example.bvito.models.Ads;

import java.math.BigDecimal;
import java.util.Objects;

/** Advertisement schema without user field
 * <p>
 *  Linked with {@link Ads Advertisement model}
 *  <p>
 *  Has no id field, because database creates it automatically<br>
 *  Has no user field for specific display
 *  @author Aleksey
 */
public class AdWithoutUserSchema {

    private Integer a_id;
    private String brand;
    private String model;
    private Short year;
    private Integer mileage;
    private BigDecimal price;
    private String description;

    public AdWithoutUserSchema(Integer a_id, String brand, String model, Short year, Integer mileage, BigDecimal price, String description) {
        this.a_id = a_id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "AdWithoutUserSchema{" +
                "a_id=" + a_id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdWithoutUserSchema that)) return false;
        return Objects.equals(a_id, that.a_id) && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(year, that.year) && Objects.equals(mileage, that.mileage) && Objects.equals(price, that.price) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a_id, brand, model, year, mileage, price, description);
    }

    public Integer getA_id() {
        return a_id;
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

