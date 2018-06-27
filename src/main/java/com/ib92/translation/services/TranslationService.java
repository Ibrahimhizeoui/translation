package com.ib92.translation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ib92.translation.models.Translation;
import com.ib92.translation.repositories.TranslationRepository;

@Service
public class TranslationService {

	@Autowired
	TranslationRepository translationRepository;
	
	public Translation saveTranslation(Translation t) {
		return translationRepository.save(t);
    }
	
	public Translation getTranslation(String langid, String key) {
		return translationRepository.findByLangidAndKey(langid, key);
    }
	
	public Optional<Translation> getTranslationById(int id) {
		return translationRepository.findById(id);
    }
	
	public List<Translation> getAllByKey(String key) {
		return translationRepository.findByKey(key);
    }
	
	public void deleteTranslation(int id) {
		this.translationRepository.deleteById(id);
	}
	
}
