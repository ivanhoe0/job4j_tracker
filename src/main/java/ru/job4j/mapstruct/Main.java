package ru.job4j.mapstruct;

import org.mapstruct.factory.Mappers;
import ru.job4j.mapstruct.dto.DeliveryAddressDTO;
import ru.job4j.mapstruct.dto.StudentDto;
import ru.job4j.mapstruct.mappers.DeliveryAddressMapper;
import ru.job4j.mapstruct.mappers.StudentMapper;
import ru.job4j.mapstruct.model.AddressEntity;
import ru.job4j.mapstruct.model.StudentEntity;

public class Main {
    public static void main(String[] args) {
        DeliveryAddressMapper deliveryAddressMapper = Mappers.getMapper(DeliveryAddressMapper.class);
        StudentEntity sEntity = new StudentEntity(0, "entity", "junior");
        StudentDto sDto = new StudentDto(11, "dto", "middle");
        AddressEntity address = new AddressEntity(100, "cityGood", "stateNew");
        DeliveryAddressDTO deliveryAddressDTO = deliveryAddressMapper.getDeliveryAddress(sEntity, address);
        System.out.println("deliveryAddressDTO = " + deliveryAddressDTO);
    }
}
