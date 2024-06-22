//package com.BankingApplication.controller;
//
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.BankingApplication.dto.CaseDto;
//import com.BankingApplication.service.CaseService;
//
//@RestController
//@RequestMapping("/api/cases")
//public class CaseController {
//    private CaseService caseService;
//
//    public CaseController(CaseService caseService) {
//        super();
//        this.caseService = caseService;
//    }
//
//    @PostMapping
//    public CaseDto addCase(@RequestBody CaseDto caseDto) {
//        try {
//            return caseService.createCase(caseDto);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to create case", e);
//        }
//    }
//
//    @GetMapping("/{id}")
//    public CaseDto getCaseById(@PathVariable Long id) {
//        try {
//            return caseService.getCaseById(id);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to get case with id: " + id, e);
//        }
//    }
//
//    @PutMapping("/{id}")
//    public CaseDto updateCase(@PathVariable Long id, @RequestBody CaseDto caseDto) {
//        try {
//            return caseService.updateCase(id, caseDto);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to update case with id: " + id, e);
//        }
//    }
//
//    @GetMapping
//    public List<CaseDto> getAllCases() {
//        try {
//            List<CaseDto> caseDtos = caseService.getAllCases();
//            return caseDtos;
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to get all cases", e);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteCase(@PathVariable Long id) {
//        try {
//            caseService.deleteCase(id);
//            return "Case with id: " + id + " deleted successfully";
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to delete case with id: " + id, e);
//        }
//    }
//}