package org.example.backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Date;

@Entity
@Table(name = "PROMOTION")
public class Promotion {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "ANNEE_PRO", length = 10, nullable = false)
    private int anneePro;

    @ManyToOne
    @JoinColumn(name = "CODE_FORMATION", referencedColumnName = "CODE_FORMATION")
    @JsonProperty("formation")
    private Formation formation;

    @ManyToOne
    @JoinColumn(name = "NO_ENSEIGNANT", referencedColumnName = "NO_ENSEIGNANT")
    @JsonProperty("enseignant")
    private Enseignant enseignant;

    @Column(name = "SIGLE_PRO", length = 5, nullable = false)
    @JsonProperty("siglePro")
    private String siglePro;


    @Column(name = "NB_ETU_SOUHAITE", nullable = false)
    @JsonProperty("nbEtuSouhaite")
    private Integer nbEtuSouhaite;


    @Column(name = "ETAT_PRESELECTION", length = 3, nullable = false)
    @JsonProperty("etatPreselection")
    private String etatPreselection;


    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_RENTREE")
    @JsonProperty("dateRentree")
    private Date dateRentree;

    @Column(name = "LIEU_RENTREE", length = 255)
    @JsonProperty("lieuRentree")
    private String lieuRentree;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_REPONSE_LP")
    @JsonProperty("dateReponseLp")
    private Date dateReponseLp;

    @Column(name = "COMMENTAIRE", length = 255)
    @JsonProperty("commentaire")
    private String commentaire;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_REPONSE_LALP")
    @JsonProperty("dateReponseLalp")
    private Date dateReponseLalp;

    @Column(name = "PROCESSUS_STAGE", length = 5, nullable = false)
    @JsonProperty("processusStage")
    private String processusStage = "RECH";

    @Column(name = "NO_EVALUATION")
    @JsonProperty("noEvaluation")
    private Integer noEvaluation;

    @Column(name = "NO_BAREME")
    @JsonProperty("noBareme")
    private Integer noBareme;


    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    @JsonProperty("etudiants")
    private List<Etudiant> etudiants;

    // Getters et Setters

    public int getAnneePro() {
        return anneePro;
    }

    public void setAnneePro(int anneePro) {
        this.anneePro = anneePro;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public String getSiglePro() {
        return siglePro;
    }

    public void setSiglePro(String siglePro) {
        this.siglePro = siglePro;
    }

    public Integer getNbEtuSouhaite() {
        return nbEtuSouhaite;
    }

    public void setNbEtuSouhaite(Integer nbEtuSouhaite) {
        this.nbEtuSouhaite = nbEtuSouhaite;
    }

    public String getEtatPreselection() {
        return etatPreselection;
    }

    public void setEtatPreselection(String etatPreselection) {
        this.etatPreselection = etatPreselection;
    }

    public Date getDateRentree() {
        return dateRentree;
    }

    public void setDateRentree(Date dateRentree) {
        this.dateRentree = dateRentree;
    }

    public String getLieuRentree() {
        return lieuRentree;
    }

    public void setLieuRentree(String lieuRentree) {
        this.lieuRentree = lieuRentree;
    }

    public Date getDateReponseLp() {
        return dateReponseLp;
    }

    public void setDateReponseLp(Date dateReponseLp) {
        this.dateReponseLp = dateReponseLp;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDateReponseLalp() {
        return dateReponseLalp;
    }

    public void setDateReponseLalp(Date dateReponseLalp) {
        this.dateReponseLalp = dateReponseLalp;
    }

    public String getProcessusStage() {
        return processusStage;
    }

    public void setProcessusStage(String processusStage) {
        this.processusStage = processusStage;
    }

    public Integer getNoEvaluation() {
        return noEvaluation;
    }

    public void setNoEvaluation(Integer noEvaluation) {
        this.noEvaluation = noEvaluation;
    }

    public Integer getNoBareme() {
        return noBareme;
    }

    public void setNoBareme(Integer noBareme) {
        this.noBareme = noBareme;
    }


    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}
