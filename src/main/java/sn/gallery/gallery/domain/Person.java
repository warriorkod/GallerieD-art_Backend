package sn.gallery.gallery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String civilite;
    private String nom;
    private String prenom;
    private String email;
    private String date_naissance;
    private String telephone;
    private String pays;
    private String ville;
    private String rue;
    private Long numero;
    private String code_postal;
}
