package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class SignIn implements Validator {

    @NotEmpty(message = "firstName is forced")
    @Size(min = 5, max = 45,message = "min is 5 and max is 45")
    private String firstName;

    @NotEmpty(message = "lastName is forced")
    @Size(min = 5, max = 45,message = "min is 5 and max is 45")
    private String lastName;

    @Email
    private String email;

    private String password;

    @NotEmpty
    private String number;

    public SignIn() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return SignIn.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
       SignIn signIn = (SignIn) target;
       String number = signIn.getNumber();
       if (number.length()>11 || number.length()<10){
           errors.rejectValue("number","number.length");
       }
       if ((!number.startsWith("0"))){
           errors.rejectValue("number","number.startWith");
       }
       if (!number.matches("(^$|[0-9]*$)")){
           errors.rejectValue("number","number.matches");
       }
       if (!signIn.getPassword().matches("bananhduc")){
           errors.rejectValue("password","password.validation");
       }
    }
}
