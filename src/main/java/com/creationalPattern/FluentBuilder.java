package com.creationalPattern;

class Person {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String city;

    public Person(PersonBuilder pb) {
        this.firstName = pb.getFirstName();
        this.lastName = pb.getLastName();
        this.phoneNo = pb.getPhoneNo();
        this.city = pb.getCity();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

class PersonBuilder {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String city;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getCity() {
        return city;
    }

    public PersonBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonBuilder withPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return this;
    }

    public PersonBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        return new Person(this);
    }
}

public class FluentBuilder {
    public static void main(String[] args) {
        Person p = new PersonBuilder("John","Doe").withCity("Gotham").withPhoneNo("+91 9909018278").build();
        System.out.println(p);
    }
}
