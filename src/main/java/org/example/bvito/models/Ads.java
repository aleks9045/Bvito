package org.example.bvito.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.Fetch;
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
    private Integer a_id;

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

    public Ads(Integer a_id, Users user, String brand, String model, Short year, Integer mileage, BigDecimal price, String description, Instant createdAt) {
        this.a_id = a_id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ads ads)) return false;
        return Objects.equals(getA_id(), ads.getA_id()) && Objects.equals(getUser(), ads.getUser()) && Objects.equals(getBrand(), ads.getBrand()) && Objects.equals(getModel(), ads.getModel()) && Objects.equals(getYear(), ads.getYear()) && Objects.equals(getMileage(), ads.getMileage()) && Objects.equals(getPrice(), ads.getPrice()) && Objects.equals(getDescription(), ads.getDescription()) && Objects.equals(getCreatedAt(), ads.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA_id(), getUser(), getBrand(), getModel(), getYear(), getMileage(), getPrice(), getDescription(), getCreatedAt());
    }

    @Override
    public String toString() {
        return "Ads{" +
                "a_id=" + a_id +
                ", users=" + user +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", mileage=" + mileage +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public static Ads newInstance() {
        return new Ads(1, Users.newInstance(), "KIA", "K5", (short) 2018, 40000, BigDecimal.valueOf(2600000), "Sell because don't like it", Instant.now());
    }

    public void setA_id(Integer a_id) {
        this.a_id = a_id;
    }

    public void setUser(Users users) {
        this.user = users;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getA_id() {
        return a_id;
    }

    public Users getUser() {
        return user;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Short getYear() {
        return year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

}
