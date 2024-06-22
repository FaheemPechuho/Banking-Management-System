package com.BankingApplication.dto;

public class CaseDto {
    private Long id;
    private String caseDescription;
    private String keySuspect;
    private String evidence;
    private String type;

    public CaseDto() {}

    public CaseDto(Long id, String caseDescription, String keySuspect, String evidence, String type) {
        this.id = id;
        this.caseDescription = caseDescription;
        this.keySuspect = keySuspect;
        this.evidence = evidence;
        this.type = type;
    }

    // Getters and Setters

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