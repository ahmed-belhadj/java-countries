package com.countries.countrysearch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/data")
public class CountryController
{
    @RequestMapping("/names/all")
    public ArrayList<Country> getAllCountries()
    {
        CountrySearchApplication.countriesListed.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return CountrySearchApplication.countriesListed.countryList;
    }

    @RequestMapping("/names/begin")
    public ArrayList<Country> getBeginningWithLetter(@RequestParam(value = "letter") char letter)
    {
        ArrayList<Country> temporaryList = new ArrayList<Country>(CountrySearchApplication.countriesListed.countryList);
        temporaryList.removeIf(c -> c.getName().charAt(0) != Character.toUpperCase(letter));
        temporaryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return temporaryList;
    }

    @RequestMapping("/names/size")
    public ArrayList<Country> getCountriesBeginningWithLetter(@RequestParam(value = "letters") int letters)
    {
        ArrayList<Country> temporaryList = new ArrayList<Country>(CountrySearchApplication.countriesListed.countryList);
        temporaryList.removeIf(c -> c.getName().length() < letters);
        temporaryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return temporaryList;
    }

    @RequestMapping("/population/size")
    public ArrayList<Country> getCountriesWithPopulation(@RequestParam(value = "people") double people)
    {
        ArrayList<Country> temporaryList = new ArrayList<Country>(CountrySearchApplication.countriesListed.countryList);
        temporaryList.removeIf(c -> c.getPopulation() < people);
        return temporaryList;
    }

    @RequestMapping("/population/min")
    public Country getSmallestPopulation()
    {
        CountrySearchApplication.countriesListed.countryList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));
        return CountrySearchApplication.countriesListed.countryList.get(0);
    }

    @RequestMapping("/population/max")
    public Country getLargestPopulation()
    {
        CountrySearchApplication.countriesListed.countryList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));
        return CountrySearchApplication.countriesListed.countryList.get(0);
    }

    @RequestMapping("/age/age")
    public ArrayList<Country> getCountriesWithAge(@RequestParam(value = "age") double age)
    {
        ArrayList<Country> temporaryList = new ArrayList<Country>(CountrySearchApplication.countriesListed.countryList);
        temporaryList.removeIf(c -> c.getMedianAge() < age);
        return temporaryList;
    }

    @RequestMapping("/age/min")
    public Country getSmallestMedianAge()
    {
        CountrySearchApplication.countriesListed.countryList.sort((c1, c2) -> (int) (c1.getMedianAge() - c2.getMedianAge()));
        return CountrySearchApplication.countriesListed.countryList.get(0);
    }

    @RequestMapping("/age/max")
    public Country getGreatestMedianAge()
    {
        CountrySearchApplication.countriesListed.countryList.sort((c1, c2) -> (int) (c2.getMedianAge() - c1.getMedianAge()));
        return CountrySearchApplication.countriesListed.countryList.get(0);
    }
}
