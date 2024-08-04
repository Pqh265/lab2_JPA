package com.t2208e.T2208E_Java_JPA.service;

import com.t2208e.T2208E_Java_JPA.entity.Manufacturer;
import com.t2208e.T2208E_Java_JPA.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public Optional<Manufacturer> getManufacturerById(Long id) {
        return manufacturerRepository.findById(id);
    }

    public void deleteManufacturer(Long id) throws Exception {
        Manufacturer manufacturer = manufacturerRepository.findById(id)
                .orElseThrow(() -> new Exception("Manufacturer not found"));

        if (!manufacturer.getProducts().isEmpty()) {
            throw new Exception("Cannot delete manufacturer with products");
        }

        manufacturerRepository.deleteById(id);
    }
}
