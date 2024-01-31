package com.springframework.springboot.mvc;

import jakarta.validation.constraints.*;

public class Customer {

    public String firstName;

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    public String lastName = "";

    @NotNull(message = "is required")
    @Min(value=0, message = "must be greater than or equal to zero")
    @Max(value=10, message = "must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp="^[0-9]{5}", message="must contain 5 digits")
    // @Pattern(regexp="^[a-zA-Z0-9]{5}", message="must contain 5 digits/letetrs")
    private String postalCode;

    public Customer() {
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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
