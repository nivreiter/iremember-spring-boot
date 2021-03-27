package com.iremember.prayer.db.prayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerseDbService {
	
	@Autowired
	private VerseRepo verseRepo;
	
	public Optional<VerseEntity> getVerseById(String id) {
		return verseRepo.findById(id);
	}
	

}
