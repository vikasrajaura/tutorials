package com.vik.model;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
 
public class Customer {
    
    @NotNull
    @NotEmpty @NotBlank
    @Email
    private String emailId;
    
    @NotNull
    @Size(min=8,max=15)
    private String password;
 
    public String getEmailId() {
        return emailId;
    }
 
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
}