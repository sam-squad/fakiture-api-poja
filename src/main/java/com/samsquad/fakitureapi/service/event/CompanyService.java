package com.samsquad.fakitureapi.service.event;

import com.samsquad.fakitureapi.repository.CompanyRepository;
import com.samsquad.fakitureapi.repository.model.Company;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company getCompanyByCompanyNumber(Integer companyNumber) throws ChangeSetPersister.NotFoundException {
        return companyRepository.findById(companyNumber).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public void deleteCompanyByCompanyNumber(Integer companyNumber) {
        companyRepository.deleteById(companyNumber);
    }

    public Company updateCompany(Integer companyNumber) throws ChangeSetPersister.NotFoundException {
        Company company = companyRepository.findById(companyNumber).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return companyRepository.save(company);
    }
}
