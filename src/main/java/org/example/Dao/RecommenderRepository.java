package org.example.Dao;

import org.example.Entity.RecommenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommenderRepository extends JpaRepository<RecommenderEntity, Integer> {
}
