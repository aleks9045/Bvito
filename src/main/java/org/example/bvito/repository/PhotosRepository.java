package org.example.bvito.repository;

import org.example.bvito.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *  Works with Photos model
 *  <p>
 *  Implements JpaRepository, so it has a set of ready-made methods
 *  @see Photo Photos model
 *  @author Aleksey
 */
public interface PhotosRepository extends JpaRepository<Photo, Integer> {

    void deleteByUrl(String url);

    @Query("""
            SELECT COUNT(*)
            FROM Photo p
            WHERE p.ad.adId = :adId
            """)
    int countByAdId(@Param("adId") int adId);
}
