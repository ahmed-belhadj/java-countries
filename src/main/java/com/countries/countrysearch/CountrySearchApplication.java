package com.countries.countrysearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountrySearchApplication
{
    static CountryList countriesListed;

    public static void main(String[] args)
    {
        countriesListed = new CountryList();
        SpringApplication.run(CountrySearchApplication.class, args);
    }
}

