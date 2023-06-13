package br.com.erudio.mapper.custom;

import br.com.erudio.data.vo.v1.PersonVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.erudio.model.Person;

import java.util.List;

@Mapper
public interface PersonMapperV2 {
    PersonMapperV2 INSTANCE = Mappers.getMapper(PersonMapperV2.class);

    @Mapping(source = "id", target = "key")
    PersonVO mapToPersonVO(Person person);

    @Mapping(source = "key", target = "id")
    Person mapToPerson(PersonVO personVO);

    List<PersonVO> mapToListPersonVO(List<Person> people);
}

