package com.iremember.prayer.db.prayer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "VERSE")
@Data
public class VerseEntity implements Serializable{
	 
	private static final long serialVersionUID = -1351894260243523348L;
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "VERSE")
	private String verse;

}
