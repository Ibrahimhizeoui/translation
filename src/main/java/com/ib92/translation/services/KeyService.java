package com.ib92.translation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ib92.translation.models.Key;
import com.ib92.translation.repositories.KeyRepository;

@Service
public class KeyService {
	
	@Autowired
	KeyRepository keyRepository;
	
	public Key saveKey(Key k) {
		return keyRepository.saveAndFlush(k);
	}
	
	public List<Key> getAllKeys() {
		return keyRepository.findAll();
	}
}
