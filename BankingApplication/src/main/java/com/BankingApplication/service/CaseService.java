//package com.BankingApplication.service;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.stereotype.Service;
//
//import com.BankingApplication.dto.CaseDto;
//import com.BankingApplication.entity.Case;
//import com.BankingApplication.repository.CaseRepository;
//
//@Service
//public class CaseService {
//
//    private CaseRepository caseRepository;
//
//    // Constructor Injection
//    public CaseService(CaseRepository caseRepository) {
//        super();
//        this.caseRepository = caseRepository;
//    }
//
//    @Override
//    public CaseDto createCase(CaseDto caseDto) {
//        Case caseEntity = CaseMapper.mapToCase(caseDto);
//        Case savedCase = caseRepository.save(caseEntity);
//        return CaseMapper.mapToCaseDto(savedCase);
//    }
//
//    @Override
//    public CaseDto getCaseById(Long id) {
//        Case caseEntity = caseRepository.findById(id).orElseThrow();
//        return CaseMapper.mapToCaseDto(caseEntity);
//    }
//
//    @Override
//    public CaseDto updateCase(Long id, CaseDto caseDto) {
//        Case existingCase = caseRepository.findById(id).orElseThrow();
//        existingCase.setCaseDescription(caseDto.getCaseDescription());
//        existingCase.setKeySuspect(caseDto.getKeySuspect());
//        existingCase.setEvidence(caseDto.getEvidence());
//        existingCase.setType(caseDto.getType());
//
//        Case updatedCase = caseRepository.save(existingCase);
//        return CaseMapper.mapToCaseDto(updatedCase);
//    }
//
//    @Override
//    public List<CaseDto> getAllCases() {
//        ArrayList<CaseDto> caseDtos = new ArrayList<>();
//        List<Case> cases = caseRepository.findAll();
//        for (Case caseEntity : cases) {
//            CaseDto caseDto = CaseMapper.mapToCaseDto(caseEntity);
//            caseDtos.add(caseDto);
//        }
//        return caseDtos;
//    }
//
//    @Override
//    public void deleteCase(Long id) {
//        Case caseEntity = caseRepository.findById(id).orElseThrow();
//        caseRepository.delete(caseEntity);
//    }
//}