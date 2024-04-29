package com.inn.qms.service;

import com.inn.qms.model.PersonFilter;

import java.util.List;
import java.util.Optional;

public interface IPersonFilterService {
    public PersonFilter createPersonFilter(PersonFilter personFilter);
    public PersonFilter updatePersonFilter(String json, Long id);
    public String deletePersonFilter(Long id);
    public PersonFilter getPersonFilterByName(String name);
    public void deleteLayoutDetails(List<Long> ids);
}
