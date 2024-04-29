package com.inn.qms.serviceimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.inn.qms.model.PersonFilter;
import com.inn.qms.repository.IPersonFilterRepository;
import com.inn.qms.service.IPersonFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonFilterServiceImpl implements IPersonFilterService {

    @Autowired
    private IPersonFilterRepository personFilterRepository;

    @Override
    public PersonFilter createPersonFilter(PersonFilter personFilter) {
        ObjectMapper om = new ObjectMapper();
        PersonFilter data = new PersonFilter();
        data.setName(personFilter.getName());
        try {
            data.setMembership(personFilter.getMembership() == null || personFilter.getMembership().isEmpty() ? null
                    : om.writeValueAsString(Map.of("name", personFilter.getName(), "membership", personFilter.getMembership())));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return personFilterRepository.save(data);
    }

    @Override
    public PersonFilter updatePersonFilter(String json, Long id) {
        PersonFilter existing = personFilterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No PersonFilter found with id: " + id));

        Gson gson = new Gson();
        PersonFilter newData = gson.fromJson(json, PersonFilter.class);

        if (newData.getMembership() != null && !newData.getMembership().equals(existing.getMembership())) {
            existing.setMembership(newData.getMembership());
        }

        if (newData.getName() != null && !newData.getName().equals(existing.getName())) {
            existing.setName(newData.getName());
        }

        return personFilterRepository.save(existing);
    }

    @Override
    public String deletePersonFilter(Long id) {
        personFilterRepository.deleteById(id);
        return "Succefully deleted";
    }

    @Override
    public PersonFilter getPersonFilterByName(String name) {
        return personFilterRepository.findByname(name);
    }

    @Override
    public void deleteLayoutDetails(List<Long> ids) {
        if(ids == null || ids.isEmpty()){
            throw new IllegalArgumentException("List of ids is null or empty");
        }
        for(Long id:ids){
            if(personFilterRepository.existsById(id)){
                personFilterRepository.deleteById(id);
            }
            else{
                throw new IllegalArgumentException("Entity with id "+id+"does not exist");
            }
        }

    }
}