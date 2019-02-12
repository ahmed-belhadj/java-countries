package com.countries.countrysearch;

public class Country
{
    private String name;
    private double population;
    private double landMassSize;
    private int medianAge;

    public Country(String name, double population, double landMassSize, int medianAge)
    {
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPopulation()
    {
        return population;
    }

    public void setPopulation(double population)
    {
        this.population = population;
    }

    public double getLandMassSize()
    {
        return landMassSize;
    }

    public void setLandMassSize(double landMassSize)
    {
        this.landMassSize = landMassSize;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(int medianAge)
    {
        this.medianAge = medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", landMassSize=" + landMassSize +
                ", medianAge=" + medianAge +
                '}';
    }
}
