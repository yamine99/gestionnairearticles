package fr.ensup.webapp.model;

import javax.persistence.*;

@Entity
@Table( name = "user")
public class User {
     @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 25)
    private String email;

    @Column(nullable = false, length = 25)
    private String mdp;
}
