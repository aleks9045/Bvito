package org.example.bvito.schemas.ads.out;

import org.example.bvito.models.Ads;

import java.math.BigDecimal;

/** Advertisement schema without user field
 * <p>
 *  Linked with {@link Ads Advertisement model}
 *  <p>
 *  Has no id field, because database creates it automatically<br>
 *  Has no user field for specific display
 *  @author Aleksey
 */
public class AdWithoutUserSchema {

    private String brand;
    private String model;
    private Short year;
    private Integer mileage;
    private BigDecimal price;
    private String description;

    @Override
    public String toString() {
        return "AdsWithoutUserSchema{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public AdWithoutUserSchema(String brand, String model, Short year, Integer mileage, BigDecimal price, String description) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.description = description;
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

