package com.example.bootstickverwaltung.mapper;

import com.example.bootstickverwaltung.dto.USBStickDTO;
import com.example.bootstickverwaltung.model.USBStick;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface USBStickMapper {
    USBStick toEntity(USBStickDTO dto);
    USBStickDTO toDTO(USBStick entity);
    List<USBStickDTO> toDTO(List<USBStick> entity);
    List<USBStick> toEntity(List<USBStickDTO> dto);
}
