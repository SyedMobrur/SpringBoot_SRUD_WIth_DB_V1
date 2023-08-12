package com.Javaguide.springbootrestapiwithDB.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.Javaguide.springbootrestapiwithDB.generator.CustomIdGenerator")
    private String customId;


    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_id", unique = false)
    private String email;

}
