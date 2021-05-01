package com.iremember.prayer.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iremember.prayer.db.prayer.VerseDbService;
import com.iremember.prayer.db.prayer.VerseEntity;

@Service
public class PrayerActions {
	
	@Autowired
	private VerseDbService verseDbService;
	
	public String getPrayer(String firstName) {
		return getKitPrayerByFirstName(firstName);
	}

	private String getKitPrayerByFirstName(String firstName) {
		Optional<VerseEntity> verseById = verseDbService.getVerseById(VerseEnum.KIT.name());
		VerseEntity verseEntity = verseById.get();
		
		String kitPrayer =  verseEntity.getVerse();
		List<String> kitVerses = getTokensWithCollection(kitPrayer);
		StringBuffer sb = new StringBuffer();
		
		char[] charArray = firstName.toCharArray();
		List<String> nameKitVerses = new ArrayList<String>();
		
		charArray = handleUpperLetter(charArray);
		for (char c : charArray) {
			List<String> tmp = kitVerses.stream().filter(s -> s.startsWith(String.valueOf(c))).collect(Collectors.toList());
			nameKitVerses.addAll(tmp);
		}
		
		nameKitVerses.stream().forEach(s-> {sb.append(s).append("<br>");});
		
		return sb.toString();
		
		
	}
	
	
	private char[] handleUpperLetter(char[] charArray) {
		int i = 0;
		for (char c : charArray) {
			if(c == 'ם') {
				charArray[i] = 'מ';
			}
			else if(c == 'ף') {
				charArray[i] = 'פ';
			}
			else if(c == 'ץ') {
				charArray[i] = 'צ';
			}
			else if(c == 'ך') {
				charArray[i] = 'כ';
			}
			else if(c == 'ן') {
				charArray[i] = 'נ';
			}
			i++;
		}
		
		return charArray;
		
	}

	private List<String> getTokensWithCollection(String str) {
	    return Collections.list(new StringTokenizer(str, "\r\n")).stream()
	      .map(token -> (String) token)
	      .collect(Collectors.toList());
	}

}
