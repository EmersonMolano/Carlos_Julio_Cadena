package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity(name = "aeropuerto")
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AeropuertoID")
    private Integer aeropuertoID;

    @Column(name = "Nombre", length = 90)
    private String nombre;

    @Column(name = "Ciudad", length = 60)
    private String ciudad;

    @Column(name = "Pais", length = 60)
    private String pais;

    @Column(name = "CodigoIATA", length = 3)
    private String codigoIATA;

    // Relación: un aeropuerto puede ser origen de muchos vuelos
    @OneToMany(mappedBy = "aeropuertoOrigen")
    private List<Vuelo> vuelosOrigen;

    // Relación: un aeropuerto puede ser destino de muchos vuelos
    @OneToMany(mappedBy = "aeropuertoDestino")
    private List<Vuelo> vuelosDestino;

    // Getters y Setters
    public Integer getAeropuertoID() { return aeropuertoID; }
    public void setAeropuertoID(Integer aeropuertoID) { this.aeropuertoID = aeropuertoID; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getCodigoIATA() { return codigoIATA; }
    public void setCodigoIATA(String codigoIATA) { this.codigoIATA = codigoIATA; }

    public List<Vuelo> getVuelosOrigen() { return vuelosOrigen; }
    public void setVuelosOrigen(List<Vuelo> vuelosOrigen) { this.vuelosOrigen = vuelosOrigen; }

    public List<Vuelo> getVuelosDestino() { return vuelosDestino; }
    public void setVuelosDestino(List<Vuelo> vuelosDestino) { this.vuelosDestino = vuelosDestino; }
}
