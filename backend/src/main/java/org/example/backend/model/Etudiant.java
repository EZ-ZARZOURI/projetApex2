package org.example.backend.model;

import jakarta.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "ETUDIANT")
public class Etudiant {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "NO_ETUDIANT_NAT", length = 50, nullable = false)
    private int noEtudiantNat;

    @ManyToOne
    @JoinColumn(name = "ANNEE_PRO", nullable = false)
    @JsonProperty("promotion")
    private Promotion promotion;

    @Column(name = "CODE_COM", length = 10)
    @JsonProperty("codeCom")
    private String codeCom;

    @Column(name = "NO_ETUDIANT_UBO", length = 20)
    @JsonProperty("noEtudiantUbo")
    private String noEtudiantUbo;

    @Column(name = "SEXE", length = 1, nullable = false)
    @JsonProperty("sexe")
    private String sexe;

    @Column(name = "NOM", length = 50, nullable = false)
    @JsonProperty("nom")
    private String nom;

    @Column(name = "PRENOM", length = 50, nullable = false)
    @JsonProperty("prenom")
    private String prenom;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_NAISSANCE", nullable = false)
    @JsonProperty("dateNaissance")
    private Date dateNaissance;

    @Column(name = "LIEU_NAISSANCE", length = 255, nullable = false)
    @JsonProperty("lieuNaissance")
    private String lieuNaissance;

    @Column(name = "SITUATION", length = 3, nullable = false)
    @JsonProperty("situation")
    private String situation;

    @Column(name = "NATIONALITE", length = 50, nullable = false)
    @JsonProperty("nationalite")
    private String nationalite = "Française";

    @Column(name = "TEL_PORT", length = 20)
    @JsonProperty("telPort")
    private String telPort;

    @Column(name = "EMAIL", length = 255)
    @JsonProperty("email")
    private String email;

    @Column(name = "PERM_ADRESSE", length = 255, nullable = false)
    @JsonProperty("permAdresse")
    private String permAdresse;

    @Column(name = "PERM_CP", length = 10, nullable = false)
    @JsonProperty("permCp")
    private String permCp;

    @Column(name = "PERM_VILLE", length = 255, nullable = false)
    @JsonProperty("permVille")
    private String permVille;

    @Column(name = "PERM_PAYS", length = 255, nullable = false)
    @JsonProperty("permPays")
    private String permPays;

    @Column(name = "DERNIER_DIPLOME", length = 255, nullable = false)
    @JsonProperty("dernierDiplome")
    private String dernierDiplome;

    @Column(name = "UNIVERSITE", length = 255, nullable = false)
    @JsonProperty("universite")
    private String universite;

    @Column(name = "EST_DIPLOME", length = 1)
    @JsonProperty("estDiplome")
    private char estDiplome = 'N';

    // Getters et Setters

    public int getNoEtudiantNat() {
        return noEtudiantNat;
    }

    public void setNoEtudiantNat(int noEtudiantNat) {
        this.noEtudiantNat = noEtudiantNat;
    }

    public String getCodeCom() {
        return codeCom;
    }

    public void setCodeCom(String codeCom) {
        this.codeCom = codeCom;
    }

    public String getNoEtudiantUbo() {
        return noEtudiantUbo;
    }

    public void setNoEtudiantUbo(String noEtudiantUbo) {
        this.noEtudiantUbo = noEtudiantUbo;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public char getEstDiplome() {
        return estDiplome;
    }

    public void setEstDiplome(char estDiplome) {
        this.estDiplome = estDiplome;
    }
}
