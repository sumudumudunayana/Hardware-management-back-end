package org.example.controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.CompanyDto;
import org.example.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class CompanyController {
    final CompanyService service;

    @GetMapping("/get-all")
    public List<CompanyDto> getCompany() {
        return service.getAll();
    }

    @PostMapping("/add-company")
    public void addCompany(@RequestBody CompanyDto companyDto){
        log.info("updated-> {}",companyDto);
        service.addCompany(companyDto);
    }

    @GetMapping("/search-by-id/{id}")
    public CompanyDto getCompanyById(@PathVariable Integer id){
        return service.searchCompanyById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCompanyById(@PathVariable Integer id){
        service.deleteCompanyById(id);
    }

    @PutMapping("/update-company")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCompanyById(@RequestBody CompanyDto companyDto){
        service.updateCompanyById(companyDto);
    }
}
