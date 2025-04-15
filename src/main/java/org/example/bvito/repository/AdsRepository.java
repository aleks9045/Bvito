package org.example.bvito.repository;

import org.example.bvito.models.Ad;
import org.example.bvito.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *  Works with Advertisement model
 *  <p>
 *  Implements JpaRepository, so it has a set of ready-made methods
 *  @see Ad Advertisement model
 *  @author Aleksey
 */
public interface AdsRepository extends JpaRepository<Ad, Integer> {

    @Query("""
            SELECT a, p.url
            FROM Ad a
            LEFT JOIN Photo p ON p.ad = a""")
    List<Object[]> findAllWithPhotos();

    @Query("""
            SELECT NEW org.example.bvito.schemas.ad.out.AdWithoutUserSchema(
                           a.adId,
                           a.brand,
                           a.model,
                           a.year,
                           a.mileage,
                           a.price,
                           a.description
                       ), p.url
            FROM Ad a
            LEFT JOIN Photo p ON p.ad = a
            WHERE a.user = :user
            """)
    List<Object[]> findAllByUser(@Param("user") User user);
}
