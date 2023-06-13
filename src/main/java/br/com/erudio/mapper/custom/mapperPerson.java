package br.com.erudio.mapper.custom;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Service
public class mapperPerson {

    @Mapping(source = "key", target = "id")
    public PersonVO mapToPersonVO(Person person) {
        PersonVO personVO = new PersonVO();
        personVO.setKey(person.getId());
        personVO.setFirstName(person.getFirstName());
        personVO.setLastName(person.getLastName());
        personVO.setAddress(person.getAddress());
        personVO.setGender(person.getGender());
        return personVO;
    }

    @Mapping(source = "id", target = "key")
    public Person mapToPerson(PersonVO personVO) {
        Person person = new Person();
        person.setId(personVO.getKey());
        person.setFirstName(personVO.getFirstName());
        person.setLastName(personVO.getLastName());
        person.setAddress(personVO.getAddress());
        person.setGender(personVO.getGender());
        return person;
    }

    public List<PersonVO> mapToPersonVOList(List<Person> persons) {
        return persons.stream()
                .map(this::mapToPersonVO)
                .collect(Collectors.toList());
    }
}
