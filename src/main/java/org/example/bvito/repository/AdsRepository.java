package org.example.bvito.repository;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Users;
import org.example.bvito.schemas.ads.out.AdWithoutUserSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *  Works with Advertisement model
 *  <p>
 *  Implements JpaRepository, so it has a set of ready-made methods
 *  @see Ads Advertisement model
 *  @author Aleksey
 */
public interface AdsRepository extends JpaRepository<Ads, Integer> {

    @Query("""
            SELECT a, p.url
            FROM Ads a
            LEFT JOIN Photos p ON p.ad = a""")
    List<Object[]> findAllWithPhotos();

    @Query("""
            SELECT NEW org.example.bvito.schemas.ads.out.AdWithoutUserSchema(
                           a.aId,
                           a.brand,
                           a.model,
                           a.year,
                           a.mileage,
                           a.price,
                           a.description
                       ), p.url
            FROM Ads a
            LEFT JOIN Photos p ON p.ad = a
            WHERE a.user = :user
            """)
    List<Object[]> findAllByUser(@Param("user") Users user);
}
