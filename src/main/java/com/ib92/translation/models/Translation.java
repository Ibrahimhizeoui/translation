package com.ib92.translation.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="translations")
public class Translation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String key;
	private String langid;
	private String translated;
	
	public Translation() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getLangid() {
		return langid;
	}

	public void setLangid(String langid) {
		this.langid = langid;
	}

	public String getTranslated() {
		return translated;
	}
	public void setTranslated(String translated) {
		this.translated = translated;
	}
}
