package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.DistributorDto;
import org.example.service.DistributorService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distributor")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class DistributorController {
    final DistributorService service;

    @GetMapping("/get-all")
    public List<DistributorDto> getDistributor() {
        return service.getAll();
    }

    @PostMapping("/add-distributor")
    public void addDistributor(@RequestBody DistributorDto distributorDto){
        log.info("updated-> {}",distributorDto);
        service.addDistributor(distributorDto);
    }

    @GetMapping("/search-by-id/{id}")
    public DistributorDto getDistributorById(@PathVariable Integer id){
        return service.searchDistributorById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDistributorById(@PathVariable Integer id){
        service.deleteDistributorById(id);
    }

    @PutMapping("/update-distributor")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateDistributorById(@RequestBody DistributorDto distributorDto){
        service.updateDistributorById(distributorDto);
    }
}
