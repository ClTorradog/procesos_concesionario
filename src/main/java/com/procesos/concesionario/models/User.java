package com.procesos.concesionario.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")

    private String lastName;
    private String email;
    private String password;
    private String address;
    private LocalDate birthday;

}
