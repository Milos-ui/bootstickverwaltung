package com.example.bootstickverwaltung.mapper;

import com.example.bootstickverwaltung.dto.USBStickDTO;
import com.example.bootstickverwaltung.model.StickGroup;
import com.example.bootstickverwaltung.model.USBStick;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.bootstickverwaltung.repository.StickGroupRepository;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class USBStickMapper {

    @Autowired
    private StickGroupRepository groupRepository;

    // ---------- from DTO -> Entity -------------
    public abstract USBStick toEntity(USBStickDTO dto);

    // ---------- from Entity -> DTO -------------
    public abstract USBStickDTO toDTO(USBStick entity);

    public abstract List<USBStickDTO> toDTO(List<USBStick> entity);
    public abstract List<USBStick> toEntity(List<USBStickDTO> dto);

    @AfterMapping
    protected void mapGroupIdToGroup(USBStickDTO dto, @MappingTarget USBStick entity) {
        if (dto.getGroupId() != null) {
            StickGroup group = groupRepository.findById(dto.getGroupId()).orElse(null);
            entity.setGroup(group);
        }
    }

    @AfterMapping
    protected void mapGroupToGroupId(USBStick entity, @MappingTarget USBStickDTO dto) {
        if (entity.getGroup() != null) {
            dto.setGroupId(entity.getGroup().getGroupId());
        }
    }
}
