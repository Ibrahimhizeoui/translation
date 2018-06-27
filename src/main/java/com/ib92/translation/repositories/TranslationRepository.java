package com.ib92.translation.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ib92.translation.models.Translation;

@Repository
public interface TranslationRepository extends JpaRepository<Translation,Integer>{
	Optional<Translation> findById(int id);
	Translation findByOriginAndKey(String origin, String key);
	List<Translation> findByOrigin(String origin);
}
