package org.example.Dao;

import org.example.Entity.RecommenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommenderRepository extends JpaRepository<RecommenderEntity, Integer> {
}
