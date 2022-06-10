package com.creationalPattern;

class PersonWithGeneric {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String city;

    public PersonWithGeneric(PersonWithGenericBuilder pb) {
        this.firstName = pb.getFirstName();
        this.lastName = pb.getLastName();
        this.phoneNo = pb.getPhoneNo();
        this.city = pb.getCity();
    }

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

class Student extends PersonWithGeneric {
    private String hobby;
    private String sid;

    public Student(StudentBuilder sb) {
        super(sb);
        this.hobby = sb.getHobby();
        this.sid = sb.getSid();
    }

    @Override
    public String toString() {
        return "Student{" +
                "hobby='" + hobby + '\'' +
                ", sid='" + sid + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNo='" + getPhoneNo() + '\'' +
                ", city='" + getCity() + '\'' +
                '}';
    }
}

class StudentBuilder extends PersonWithGenericBuilder<StudentBuilder> {
    private String sid;
    private String hobby;

    public StudentBuilder(String firstName,String lastName,String sid) {
        super(firstName, lastName);
        this.sid = sid;
    }

    public StudentBuilder withHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public String getSid() {
        return sid;
    }

    public String getHobby() {
        return hobby;
    }

    @Override
    public Student build() {
        return new Student(this);
    }
}

class PersonWithGenericBuilder<SELF extends PersonWithGenericBuilder<SELF>>{
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

    public PersonWithGenericBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public SELF withPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
        return (SELF) this;
    }

    public SELF withCity(String city) {
        this.city = city;
        return (SELF) this;
    }

    public PersonWithGeneric build() {
        return new PersonWithGeneric(this);
    }
}

public class FluentBuilderWithRecursiveGenerics {
    public static void main(String[] args) {
        Student s = new StudentBuilder("John","Doe", "S001")
                .withCity("Gotham")
                .withPhoneNo("+91 9909018278")
                .withHobby("Cricket")
                .build();
        System.out.println(s);
    }
}
