package org.example.service;

import org.example.dto.CompanyDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getAll();

    void addCompany(CompanyDto companyDto);

    void deleteCompanyById(Integer id);

    CompanyDto searchCompanyById(Integer id);

    void updateCompanyById(CompanyDto companyDto);
}
