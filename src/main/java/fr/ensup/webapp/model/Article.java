package fr.ensup.webapp.model;


import javax.persistence.*;

@Entity
@Table( name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true, length = 25)
    private String nom;

    @Column(nullable = false, length = 25)
    private String type;

    @Column(nullable = false, length = 6)
    private int prix;

    @Column(nullable = false, length = 6)
    private int quantite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}
