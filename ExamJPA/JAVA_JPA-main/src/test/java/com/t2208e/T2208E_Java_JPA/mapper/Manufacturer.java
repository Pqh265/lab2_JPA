package com.t2208e.T2208E_Java_JPA.mapper;

import com.t2208e.T2208E_Java_JPA.dto.ManufacturerDTO;
import com.t2208e.T2208E_Java_JPA.entity.Manufacturer;

@Mapper(componentModel = "spring")
public interface ManufacturerMapper {
    ManufacturerDTO toDTO(Manufacturer manufacturer);
    Manufacturer toEntity(ManufacturerDTO manufacturerDTO);
}
