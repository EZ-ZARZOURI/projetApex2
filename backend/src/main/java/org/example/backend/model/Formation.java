package org.example.backend.model;


import jakarta.persistence.*;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "FORMATION")
public class Formation {

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
    @Column(name = "CODE_FORMATION", length = 8, nullable = false)
    private int codeFormation;

    @Column(name = "DIPLOME", length = 3, nullable = false)
    @JsonProperty("diplome")
    private String diplome;

    @Column(name = "N0_ANNEE", nullable = false)
    @JsonProperty("noAnnee")
    private Integer noAnnee = 1;

    @Column(name = "NOM_FORMATION", length = 68, nullable = false)
    @JsonProperty("nomFormation")
    private String nomFormation;

    @Column(name = "DOUBLE_DIPLOME", length = 1, nullable = false)
    @JsonProperty("doubleDiplome")
    private char doubleDiplome;

    @Temporal(TemporalType.DATE)
    @Column(name = "DEBUT_HABILITATION")
    @JsonProperty("debutHabilitation")
    private Date debutHabilitation;

    @Temporal(TemporalType.DATE)
    @Column(name = "FIN_HABILITATION")
    @JsonProperty("finHabilitation")
    private Date finHabilitation;



    // Getters et Setters

    public int getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(int codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public Integer getNoAnnee() {
        return noAnnee;
    }

    public void setNoAnnee(Integer noAnnee) {
        this.noAnnee = noAnnee;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public char getDoubleDiplome() {
        return doubleDiplome;
    }

    public void setDoubleDiplome(char doubleDiplome) {
        this.doubleDiplome = doubleDiplome;
    }

    public Date getDebutHabilitation() {
        return debutHabilitation;
    }

    public void setDebutHabilitation(Date debutHabilitation) {
        this.debutHabilitation = debutHabilitation;
    }

    public Date getFinHabilitation() {
        return finHabilitation;
    }

    public void setFinHabilitation(Date finHabilitation) {
        this.finHabilitation = finHabilitation;
    }
}
