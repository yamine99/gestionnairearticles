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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
