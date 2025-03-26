package org.example.bvito.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.example.bvito.models.Users;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;


public class AdsSchema {

    @Schema(description = "user id", example = "1")
    @NotNull
    @Positive
    private Integer u_id;

    @Schema(description = "brand", maxLength = 32, example = "BMV")
    @NotNull
    @Size(max = 32)
    private String brand;

    @Schema(description = "model", maxLength = 64, example = "A5")
    @NotNull
    @Size(max = 64)
    private String model;

    @Schema(description = "year", example = "2018", minimum = "0", maximum = "3000")
    @NotNull
    @Size(max = 3000)
    private Short year;

    @Schema(description = "mileage", example = "440000", minimum = "0", maximum = "10_000_000")
    @NotNull
    @Size(max = 10_000_000)
    private Integer mileage;

    @Schema(description = "price", example = "1299990.90")
    @NotNull
    private BigDecimal price;

    @Schema(description = "description", maxLength = 256, example = "long description")
    @NotNull
    @Size(max = 256)
    private String description;


    public AdsSchema(Integer u_id, String brand, String model, Short year, Integer mileage, BigDecimal price, String description, Instant createdAt) {
        this.u_id = u_id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdsSchema adsSchema)) return false;
        return Objects.equals(u_id, adsSchema.u_id) && Objects.equals(brand, adsSchema.brand) && Objects.equals(model, adsSchema.model) && Objects.equals(year, adsSchema.year) && Objects.equals(mileage, adsSchema.mileage) && Objects.equals(price, adsSchema.price) && Objects.equals(description, adsSchema.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(u_id, brand, model, year, mileage, price, description);
    }

    @Override
    public String toString() {
        return "AdsSchema{" +
                "u_id=" + u_id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public static AdsSchema newInstance() {
        return new AdsSchema(1, "KIA", "K5", (short) 2018, 40000, BigDecimal.valueOf(2600000), "Sell because don't like it", Instant.now());
    }

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
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
