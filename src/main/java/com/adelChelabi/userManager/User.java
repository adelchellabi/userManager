package com.adelChelabi.userManager;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  int id;

     @NotNull
     @NotBlank
     @Size(min = 3,max = 20)
     private String firstName;

     @NotNull
     @NotBlank
     @Size(min = 3,max = 20)
     private String lastName;


     @Column(unique = true)
     @NotNull
     @NotBlank
     @Size(min = 3,max = 20)
     private String username;

     @NotNull
     @NotBlank
     @Size(min = 8,max = 25)
     private String password;
     @Email
     private String email;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
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

     public String getUsername() {
          return username;
     }

     public void setUsername(String username) {
          this.username = username;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }
}
