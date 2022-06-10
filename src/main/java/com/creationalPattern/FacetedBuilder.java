package com.creationalPattern;

class PersonFaceted {
    // Employee Details
    private String street, area, zipcode;

    // Company Details
    private String companyName, companyAddress;

    // Earning Details
    private double incomeAmt;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public double getIncomeAmt() {
        return incomeAmt;
    }

    public void setIncomeAmt(double incomeAmt) {
        this.incomeAmt = incomeAmt;
    }

    @Override
    public String toString() {
        return "PersonFaceted{" +
                "street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", incomeAmt=" + incomeAmt +
                '}';
    }
}

class PersonFacetedBuilder {
    protected PersonFaceted pf = new PersonFaceted();

    public EmployeeDetailsBuilder lives() {
        return new EmployeeDetailsBuilder(pf);
    }

    public CompanyDetailsBuilder works() {
        return new CompanyDetailsBuilder(pf);
    }

    public IncomeDetailsBuilder earnings() {
        return new IncomeDetailsBuilder(pf);
    }

    public PersonFaceted build() {
        return pf;
    }
}

class EmployeeDetailsBuilder extends PersonFacetedBuilder {
    public EmployeeDetailsBuilder(PersonFaceted pf) {
        this.pf = pf;
    }

    public EmployeeDetailsBuilder withStreet(String street) {
        this.pf.setStreet(street);
        return this;
    }

    public EmployeeDetailsBuilder withArea(String area) {
        this.pf.setArea(area);
        return this;
    }

    public EmployeeDetailsBuilder withZipCode(String zipCode) {
        this.pf.setZipcode(zipCode);
        return this;
    }
}

class CompanyDetailsBuilder extends PersonFacetedBuilder {
    public CompanyDetailsBuilder(PersonFaceted pf) {
        this.pf = pf;
    }

    public CompanyDetailsBuilder withCompanyName(String companyName) {
        this.pf.setCompanyName(companyName);
        return this;
    }

    public CompanyDetailsBuilder withCompanyAddress(String companyAddress) {
        this.pf.setCompanyAddress(companyAddress);
        return this;
    }
}

class IncomeDetailsBuilder extends PersonFacetedBuilder {
    public IncomeDetailsBuilder(PersonFaceted pf) {
        this.pf = pf;
    }

    public IncomeDetailsBuilder withIncomeAmt(double incomeAmt) {
        this.pf.setIncomeAmt(incomeAmt);
        return this;
    }
}

public class FacetedBuilder {
    public static void main(String[] args) {
        PersonFaceted pf = new PersonFacetedBuilder()
                .lives()
                    .withStreet("123 Marin Drive")
                    .withArea("Xyx Area")
                    .withZipCode("548515")
                .works()
                    .withCompanyName("Google LLC")
                    .withCompanyAddress("California")
                .earnings()
                    .withIncomeAmt(1452145)
                .build();
        System.out.println(pf);
    }
}
