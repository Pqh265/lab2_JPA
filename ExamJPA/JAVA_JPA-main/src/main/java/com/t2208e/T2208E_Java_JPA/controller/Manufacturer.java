package com.t2208e.T2208E_Java_JPA.controller;

import com.t2208e.T2208E_Java_JPA.dto.ManufacturerDTO;
import com.t2208e.T2208E_Java_JPA.entity.Manufacturer;
import com.t2208e.T2208E_Java_JPA.mapper.ManufacturerMapper;
import com.t2208e.T2208E_Java_JPA.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/manufacturers")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ManufacturerMapper manufacturerMapper;

    @GetMapping
    public List<ManufacturerDTO> getAllManufacturers() {
        return manufacturerService.getAllManufacturers().stream()
                .map(manufacturerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ManufacturerDTO createManufacturer(@RequestBody ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = manufacturerMapper.toEntity(manufacturerDTO);
        return manufacturerMapper.toDTO(manufacturerService.saveManufacturer(manufacturer));
    }

    @PutMapping("/{id}")
    public ManufacturerDTO updateManufacturer(@PathVariable Long id, @RequestBody ManufacturerDTO manufacturerDTO) throws Exception {
        Manufacturer existingManufacturer = manufacturerService.getManufacturerById(id)
                .orElseThrow(() -> new Exception("Manufacturer not found"));

        existingManufacturer.setName(manufacturerDTO.getName());
        existingManufacturer.setOrigin(manufacturerDTO.getOrigin());
        existingManufacturer.setDescription(manufacturerDTO.getDescription());

        return manufacturerMapper.toDTO(manufacturerService.saveManufacturer(existingManufacturer));
    }

    @DeleteMapping("/{id}")
    public void deleteManufacturer(@PathVariable Long id) throws Exception {
        manufacturerService.deleteManufacturer(id);
    }
}
