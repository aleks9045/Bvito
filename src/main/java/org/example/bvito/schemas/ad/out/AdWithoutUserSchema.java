package org.example.bvito.schemas.ad.out;

import org.example.bvito.models.Ad;

import java.math.BigDecimal;
import java.util.Objects;

/** Advertisement schema without user field
 * <p>
 *  Linked with {@link Ad Advertisement model}
 *  <p>
 *  Has no user field for specific display
 *  @author Aleksey
 */
public class AdWithoutUserSchema {

    private Integer adId;
    private String brand;
    private String model;
    private Short year;
    private Integer mileage;
    private BigDecimal price;
    private String description;

    public AdWithoutUserSchema(Integer a_id, String brand, String model, Short year, Integer mileage, BigDecimal price, String description) {
        this.adId = a_id;
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
                "aId=" + adId +
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
        return Objects.equals(adId, that.adId) && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(year, that.year) && Objects.equals(mileage, that.mileage) && Objects.equals(price, that.price) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId, brand, model, year, mileage, price, description);
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
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

