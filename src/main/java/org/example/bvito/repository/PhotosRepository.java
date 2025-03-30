package org.example.bvito.repository;

import org.example.bvito.models.Ads;
import org.example.bvito.models.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *  Works with Photos model
 *  <p>
 *  Implements JpaRepository, so it has a set of ready-made methods
 *  @see Photos Photos model
 *  @author Aleksey
 */
public interface PhotosRepository extends JpaRepository<Photos, Integer> {


}
