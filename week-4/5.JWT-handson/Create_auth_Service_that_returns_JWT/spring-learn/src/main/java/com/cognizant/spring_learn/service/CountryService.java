package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.model.Country;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final List<Country> countryList;

    public CountryService(@Qualifier("countryList") List<Country> countryList) {
        this.countryList = countryList;
    }

    public Country getCountry(String code) {
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
