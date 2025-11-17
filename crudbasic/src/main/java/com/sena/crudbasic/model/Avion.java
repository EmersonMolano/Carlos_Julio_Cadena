package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity(name = "avion")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AvionID")
    private Integer avionID;

    @Column(name = "Modelo", length = 50)
    private String modelo;

    @Column(name = "Capacidad")
    private Integer capacidad;

    @Column(name = "Fabricante", length = 50)
    private String fabricante;

    // Relación: un avión puede tener varios vuelos
    @OneToMany(mappedBy = "avion")
    private List<Vuelo> vuelos;

    // Relación: un avión tiene muchos asientos
    @OneToMany(mappedBy = "avion")
    private List<Asiento> asientos;

    // Getters y Setters
    public Integer getAvionID() { return avionID; }
    public void setAvionID(Integer avionID) { this.avionID = avionID; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public List<Vuelo> getVuelos() { return vuelos; }
    public void setVuelos(List<Vuelo> vuelos) { this.vuelos = vuelos; }

    public List<Asiento> getAsientos() { return asientos; }
    public void setAsientos(List<Asiento> asientos) { this.asientos = asientos; }
}
