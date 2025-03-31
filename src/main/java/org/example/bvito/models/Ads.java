package org.example.bvito.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/** Represents advertisement model
 *  @author Aleksey
 */
@Entity
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "u_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users user;

    @Column(name = "brand", nullable = false, length = 32)
    private String brand;

    @Column(name = "model", nullable = false, length = 64)
    private String model;

    @Column(name = "year", nullable = false, columnDefinition = "INTEGER CHECK (0 < year and year < 3000)")
    @Min(0)
    @Max(3000)
    private Short year;

    @Column(name = "mileage", nullable = false, columnDefinition = "INTEGER CHECK (0 < mileage and mileage < 10000000)")
    @Min(0)
    @Max(10_000_000)
    private Integer mileage;

    @Column(name = "price", nullable = false, precision = 9, scale = 2)
    @DecimalMin("0.00")
    private BigDecimal price;

    @Column(name = "description", nullable = false, length = 256)
    private String description;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt = Instant.now();

    public Ads() {}

    public Ads(Integer aId, Users user, String brand, String model, Short year, Integer mileage, BigDecimal price, String description, Instant createdAt) {
        this.aId = aId;
        this.user = user;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.description = description;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Ads{" +
                "aId=" + aId +
                ", uId=" + user +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ads ads)) return false;
        return Objects.equals(aId, ads.aId) && Objects.equals(user, ads.user) && Objects.equals(brand, ads.brand) && Objects.equals(model, ads.model) && Objects.equals(year, ads.year) && Objects.equals(mileage, ads.mileage) && Objects.equals(price, ads.price) && Objects.equals(description, ads.description) && Objects.equals(createdAt, ads.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aId, user, brand, model, year, mileage, price, description, createdAt);
    }

    public static Ads newInstance() {
        return new Ads(1, Users.newInstance(), "KIA", "K5", (short) 2018, 40000, BigDecimal.valueOf(2600000), "Sell because don't like it", Instant.now());
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users uId) {
        this.user = uId;
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

    public @Min(0) @Max(3000) Short getYear() {
        return year;
    }

    public void setYear(@Min(0) @Max(3000) Short year) {
        this.year = year;
    }

    public @Min(0) @Max(10_000_000) Integer getMileage() {
        return mileage;
    }

    public void setMileage(@Min(0) @Max(10_000_000) Integer mileage) {
        this.mileage = mileage;
    }

    public @DecimalMin("0.00") BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@DecimalMin("0.00") BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
