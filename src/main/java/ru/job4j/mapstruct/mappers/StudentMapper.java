package ru.job4j.mapstruct.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.mapstruct.dto.StudentDto;
import ru.job4j.mapstruct.model.StudentEntity;

@Mapper
public interface  StudentMapper {
    @Mapping(target = "className", source = "classVal")
    StudentDto getModelFromEntity(StudentEntity student);

    @InheritInverseConfiguration
    StudentEntity getEntityFromDto(StudentDto studentDto);
}