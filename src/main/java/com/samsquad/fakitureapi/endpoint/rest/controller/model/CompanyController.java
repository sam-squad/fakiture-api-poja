package com.samsquad.fakitureapi.endpoint.rest.controller.model;

import com.samsquad.fakitureapi.repository.model.Company;
import com.samsquad.fakitureapi.service.event.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CompanyController {
    private final CompanyService companyService;

    @PostMapping("/company")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company addedCompany = companyService.addCompany(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCompany);
    }

    @GetMapping("/companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/company/{companyNumber}")
    public Company getCompanyById(@PathVariable Integer companyNumber) throws ChangeSetPersister.NotFoundException {
        return companyService.getCompanyByCompanyNumber(companyNumber);
    }

    @PutMapping("/company/{companyNumber}")
    public Company updateCompany(@PathVariable Integer companyNumber) throws ChangeSetPersister.NotFoundException {
        return companyService.updateCompany(companyNumber);
    }

    @DeleteMapping("/company/{companyNumber}")
    public void deleteCompany(@PathVariable Integer companyNumber) {
        companyService.deleteCompanyByCompanyNumber(companyNumber);
    }
}

