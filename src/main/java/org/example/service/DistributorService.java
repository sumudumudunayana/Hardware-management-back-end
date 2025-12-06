package org.example.service;

import org.example.dto.DistributorDto;

import java.util.List;

public interface DistributorService {
    List<DistributorDto> getAll();

    void addDistributor(DistributorDto distributorDto);

    void deleteDistributorById(Integer id);

    DistributorDto searchDistributorById(Integer id);

    void updateDistributorById(DistributorDto distributorDto);
}
