package org.example.backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;



@Entity
@Table(name = "enseignant")
public class Enseignant {

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
    @Column(name = "no_enseignant")
    private int noEnseignant;

    @Column(name = "type")
    @JsonProperty("type")
    private String type;

    @Column(name = "sexe")
    @JsonProperty("sexe")
    private String sexe;

    @Column(name = "nom")
    @JsonProperty("nom")
    private String nom;

    @Column(name = "prenom")
    @JsonProperty("prenom")
    private String prenom;

    @Column(name = "adresse")
    @JsonProperty("adresse")
    private String adresse;

    @Column(name = "cp")
    @JsonProperty("cp")
    private String cp;

    @Column(name = "ville")
    @JsonProperty("ville")
    private String ville;

    @Column(name = "pays")
    @JsonProperty("pays")
    private String pays;

    @JsonProperty("tel_port")
    @Column(name = "tel_port")
    private String telPort;

    @JsonProperty("enc_perso_tel")
    @Column(name = "enc_perso_tel")
    private String encPersoTel;

    @JsonProperty("enc_ubo_tel")
    @Column(name = "enc_ubo_tel")
    private String encUboTel;

    @JsonProperty("enc_perso_email")
    @Column(name = "enc_perso_email")
    private String encPersoEmail;

    @JsonProperty("enc_ubo_email")
    @Column(name = "enc_ubo_email")
    private String encUboEmail;

    @JsonProperty("int_no_insee")
    @Column(name = "int_no_insee")
    private String intNoInsee;

    @JsonProperty("int_soc_nom")
    @Column(name = "int_soc_nom")
    private String intSocNom;

    @JsonProperty("int_soc_adresse")
    @Column(name = "int_soc_adresse")
    private String intSocAdresse;

    @JsonProperty("int_soc_cp")
    @Column(name = "int_soc_cp")
    private String intSocCp;

    @JsonProperty("int_soc_ville")
    @Column(name = "int_soc_ville")
    private String intSocVille;

    @JsonProperty("int_soc_pays")
    @Column(name = "int_soc_pays")
    private String intSocPays;

    @JsonProperty("int_fonction")
    @Column(name = "int_fonction")
    private String intFonction;

    @JsonProperty("int_prof_email")
    @Column(name = "int_prof_email")
    private String intProfEmail;

    @JsonProperty("int_prof_tel")
    @Column(name = "int_prof_tel")
    private String intProfTel;

    // Getters and Setters
    public int getNoEnseignant() { return noEnseignant; }
    public void setNoEnseignant(int noEnseignant) { this.noEnseignant = noEnseignant; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getCp() { return cp; }
    public void setCp(String cp) { this.cp = cp; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }

    public String getTelPort() { return telPort; }
    public void setTelPort(String telPort) { this.telPort = telPort; }

    public String getEncPersoTel() { return encPersoTel; }
    public void setEncPersoTel(String encPersoTel) { this.encPersoTel = encPersoTel; }

    public String getEncUboTel() { return encUboTel; }
    public void setEncUboTel(String encUboTel) { this.encUboTel = encUboTel; }

    public String getEncPersoEmail() { return encPersoEmail; }
    public void setEncPersoEmail(String encPersoEmail) { this.encPersoEmail = encPersoEmail; }

    public String getEncUboEmail() { return encUboEmail; }
    public void setEncUboEmail(String encUboEmail) { this.encUboEmail = encUboEmail; }

    public String getIntNoInsee() { return intNoInsee; }
    public void setIntNoInsee(String intNoInsee) { this.intNoInsee = intNoInsee; }

    public String getIntSocNom() { return intSocNom; }
    public void setIntSocNom(String intSocNom) { this.intSocNom = intSocNom; }

    public String getIntSocAdresse() { return intSocAdresse; }
    public void setIntSocAdresse(String intSocAdresse) { this.intSocAdresse = intSocAdresse; }

    public String getIntSocCp() { return intSocCp; }
    public void setIntSocCp(String intSocCp) { this.intSocCp = intSocCp; }

    public String getIntSocVille() { return intSocVille; }
    public void setIntSocVille(String intSocVille) { this.intSocVille = intSocVille; }

    public String getIntSocPays() { return intSocPays; }
    public void setIntSocPays(String intSocPays) { this.intSocPays = intSocPays; }

    public String getIntFonction() { return intFonction; }
    public void setIntFonction(String intFonction) { this.intFonction = intFonction; }

    public String getIntProfEmail() { return intProfEmail; }
    public void setIntProfEmail(String intProfEmail) { this.intProfEmail = intProfEmail; }

    public String getIntProfTel() { return intProfTel; }
    public void setIntProfTel(String intProfTel) { this.intProfTel = intProfTel; }
}
