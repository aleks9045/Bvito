package org.example.bvito.schemas.ad.in;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.example.bvito.models.Ad;
import org.example.bvito.schemas.ad.AdsValidationGroups;

import java.math.BigDecimal;
import java.util.Objects;

/** Default advertisement schema
 * <p>
 *  Linked with {@link Ad Advertisement model}
 *  <p>
 *  Has no id field, because database creates it automatically
 *  @author Aleksey
 */
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AdSchemaIn {

    @Schema(description = "user id", example = "1")
    @NotNull(groups = AdsValidationGroups.OnCreate.class)
    @Positive
    private Integer userId;

    @Schema(description = "brand", maxLength = 32, example = "BMV")
    @NotNull(groups = AdsValidationGroups.OnCreate.class)
    @Size(max = 32)
    private String brand;

    @Schema(description = "model", maxLength = 64, example = "A5")
    @NotNull(groups = AdsValidationGroups.OnCreate.class)
    @Size(max = 64)
    private String model;

    @Schema(description = "year", example = "2018", minimum = "0", maximum = "3000")
    @NotNull(groups = AdsValidationGroups.OnCreate.class)
    @Min(0)
    @Max(3000)
    private Short year;

    @Schema(description = "mileage", example = "440000", minimum = "0", maximum = "10_000_000")
    @NotNull(groups = AdsValidationGroups.OnCreate.class)
    @Min(0)
    @Max(10_000_000)
    private Integer mileage;

    @Schema(description = "price", example = "1299990.90")
    @NotNull(groups = AdsValidationGroups.OnCreate.class)
    private BigDecimal price;

    @Schema(description = "description", maxLength = 256, example = "long description")
    @NotNull(groups = AdsValidationGroups.OnCreate.class)
    @Size(max = 256)
    private String description;

    public AdSchemaIn(Integer userId, String brand, String model, Short year, Integer mileage, BigDecimal price, String description) {
        this.userId = userId;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "AdSchemaIn{" +
                "uId=" + userId +
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
        if (!(o instanceof AdSchemaIn that)) return false;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getBrand(), that.getBrand()) && Objects.equals(getModel(), that.getModel()) && Objects.equals(getYear(), that.getYear()) && Objects.equals(getMileage(), that.getMileage()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getBrand(), getModel(), getYear(), getMileage(), getPrice(), getDescription());
    }

    public @NotNull(groups = AdsValidationGroups.OnCreate.class) @Positive Integer getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(groups = AdsValidationGroups.OnCreate.class) @Positive Integer userId) {
        this.userId = userId;
    }

    public @NotNull(groups = AdsValidationGroups.OnCreate.class) @Size(max = 32) String getBrand() {
        return brand;
    }

    public void setBrand(@NotNull(groups = AdsValidationGroups.OnCreate.class) @Size(max = 32) String brand) {
        this.brand = brand;
    }

    public @NotNull(groups = AdsValidationGroups.OnCreate.class) @Size(max = 64) String getModel() {
        return model;
    }

    public void setModel(@NotNull(groups = AdsValidationGroups.OnCreate.class) @Size(max = 64) String model) {
        this.model = model;
    }

    public @NotNull(groups = AdsValidationGroups.OnCreate.class) @Min(0) @Max(3000) Short getYear() {
        return year;
    }

    public void setYear(@NotNull(groups = AdsValidationGroups.OnCreate.class) @Min(0) @Max(3000) Short year) {
        this.year = year;
    }

    public @NotNull(groups = AdsValidationGroups.OnCreate.class) @Min(0) @Max(10_000_000) Integer getMileage() {
        return mileage;
    }

    public void setMileage(@NotNull(groups = AdsValidationGroups.OnCreate.class) @Min(0) @Max(10_000_000) Integer mileage) {
        this.mileage = mileage;
    }

    public @NotNull(groups = AdsValidationGroups.OnCreate.class) BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull(groups = AdsValidationGroups.OnCreate.class) BigDecimal price) {
        this.price = price;
    }

    public @NotNull(groups = AdsValidationGroups.OnCreate.class) @Size(max = 256) String getDescription() {
        return description;
    }

    public void setDescription(@NotNull(groups = AdsValidationGroups.OnCreate.class) @Size(max = 256) String description) {
        this.description = description;
    }

    public static AdSchemaIn newInstance() {
        return new AdSchemaIn(1, "KIA", "K5", (short) 2018, 40000, BigDecimal.valueOf(2600000), "Sell because don't like it");
    }

}
