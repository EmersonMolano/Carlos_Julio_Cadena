package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity(name = "asiento")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AsientoID")
    private Integer asientoID;

    // FK -> Avion
    @ManyToOne
    @JoinColumn(name = "AvionID")
    private Avion avion;

    @Column(name = "NumeroAsiento", length = 5)
    private String numeroAsiento;

    @Column(name = "Tipo", length = 20)
    private String tipo;

    // Relación: un asiento puede estar vinculado a varios checkins a lo largo del tiempo
    @OneToMany(mappedBy = "asiento")
    private List<CheckIn> checkIns;

    // Getters y Setters
    public Integer getAsientoID() { return asientoID; }
    public void setAsientoID(Integer asientoID) { this.asientoID = asientoID; }

    public Avion getAvion() { return avion; }
    public void setAvion(Avion avion) { this.avion = avion; }

    public String getNumeroAsiento() { return numeroAsiento; }
    public void setNumeroAsiento(String numeroAsiento) { this.numeroAsiento = numeroAsiento; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public List<CheckIn> getCheckIns() { return checkIns; }
    public void setCheckIns(List<CheckIn> checkIns) { this.checkIns = checkIns; }
}
