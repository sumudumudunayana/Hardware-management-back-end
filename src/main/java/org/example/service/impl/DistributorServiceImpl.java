package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.DistributorDto;
import org.example.entity.DistributorEntity;
import org.example.repository.DistributorRepository;
import org.example.service.DistributorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistributorServiceImpl implements DistributorService{
    private final DistributorRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<DistributorDto> getAll() {
        List<DistributorDto> DistributorArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            DistributorArrayList.add(mapper.map(entity, DistributorDto.class));
        });
        return DistributorArrayList;
    }

    @Override
    public void addDistributor(DistributorDto distributorDto) {
        System.out.println(distributorDto);
        repository.save(mapper.map(distributorDto, DistributorEntity.class));
    }

    @Override
    public void deleteDistributorById(Integer id){
        repository.deleteById(id);
    }

    @Override
    public DistributorDto searchDistributorById(Integer id) {
        return mapper.map(repository.findById(id),DistributorDto.class);

    }

    @Override
    public void updateDistributorById(DistributorDto distributorDto) {
        repository.save(mapper.map(distributorDto, DistributorEntity.class));
    }
}
