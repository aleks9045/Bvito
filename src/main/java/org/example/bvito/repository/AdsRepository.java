package org.example.bvito.repository;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.ads.out.AdsWithoutUserSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdsRepository extends JpaRepository<Ads, Integer> {

    @Query("""
            SELECT NEW org.example.bvito.schemas.ads.out.AdsWithoutUserSchema(
                           a.brand,
                           a.model,
                           a.year,
                           a.mileage,
                           a.price,
                           a.description
                       )
            FROM Ads a
            WHERE a.user = :user
            """)
    List<AdsWithoutUserSchema> findAllByUser(@Param("user") Users user);
}
