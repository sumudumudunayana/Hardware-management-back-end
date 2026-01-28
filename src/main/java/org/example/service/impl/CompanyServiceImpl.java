package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.dto.CompanyDto;
import org.example.entity.CompanyEntity;
import org.example.repository.CompanyRepository;
import org.example.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<CompanyDto> getAll() {
        List<CompanyDto> CopmpanyArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            CopmpanyArrayList.add(mapper.map(entity, CompanyDto.class));
        });
        return CopmpanyArrayList;
    }

    @Override
    public void addCompany(CompanyDto companyDto) {
        System.out.println(companyDto);
        repository.save(mapper.map(companyDto, CompanyEntity.class));
    }

    @Override
    public void deleteCompanyById(Integer id){
        repository.deleteById(id);
    }

    @Override
    public CompanyDto searchCompanyById(Integer id) {
        return mapper.map(repository.findById(id),CompanyDto.class);
    }

    @Override
    public void updateCompanyById(CompanyDto companyDto) {
        repository.save(mapper.map(companyDto, CompanyEntity.class));
    }
}
