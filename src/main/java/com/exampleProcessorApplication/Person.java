package com.exampleProcessorApplication;
import com.exampleProcessorApplication.Person;
public class Person {
    private String email;
    private String birthDate;
    private String profession;

    public Person(String email, String birthDate, String profession) {
        this.email = email;
        this.birthDate = birthDate;
        this.profession = profession;
    }

    // Getters y Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

}
