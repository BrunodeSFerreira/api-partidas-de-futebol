
package com.meli.api_futebol.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CLUBE_PARTIDA")
public class ClubePartida {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "clube_id")
    private Clube clube;

    private int gols;
    private boolean mandante;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clube getClube() {
        return clube;
    }

    public void setClube(Clube clube) {
        this.clube = clube;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public boolean isMandante() {
        return mandante;
    }

    public void setMandante(boolean mandante) {
        this.mandante = mandante;
    }
}
