package org.example.bvito.repository;

import org.example.bvito.models.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aleksey
 */
public interface PhotosRepository extends JpaRepository<Photos, Integer> {
}
