package com.BankingApplication.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cases")
public class Case {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Hibernate will generate the value automatically
	private Long id;
	
	@Column (name = "caseDescription")
	private String caseDescription;
	
	
	private String keySuspect;
	
	private String evidence;
	private String type;
	

	

	public Case(Long id, String caseDescription, String keySuspect, String evidence, String type) {
		super();
		this.id = id;
		this.caseDescription = caseDescription;
		this.keySuspect = keySuspect;
		this.evidence = evidence;
		this.type = type;
	}




	public Case() {
		super();
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getCaseDescription() {
		return caseDescription;
	}




	public void setCaseDescription(String caseDescription) {
		this.caseDescription = caseDescription;
	}




	public String getKeySuspect() {
		return keySuspect;
	}




	public void setKeySuspect(String keySuspect) {
		this.keySuspect = keySuspect;
	}




	public String getEvidence() {
		return evidence;
	}




	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}





}

