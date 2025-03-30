package com.example.bootstickverwaltung.mapper;

import com.example.bootstickverwaltung.dto.StickGroupDTO;
import com.example.bootstickverwaltung.model.StickGroup;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StickGroupMapper {

    StickGroup toEntity(StickGroupDTO dto);

    StickGroupDTO toDTO(StickGroup entity);

    List<StickGroupDTO> toDTO(List<StickGroup> entities);

    List<StickGroup> toEntity(List<StickGroupDTO> dtos);
}
