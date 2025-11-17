package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VueloID")
    private Integer vueloID;

    // FK -> Avion
    @ManyToOne
    @JoinColumn(name = "AvionID")
    private Avion avion;

    // FK -> Aeropuerto origen
    @ManyToOne
    @JoinColumn(name = "AeropuertoOrigenID")
    private Aeropuerto aeropuertoOrigen;

    // FK -> Aeropuerto destino
    @ManyToOne
    @JoinColumn(name = "AeropuertoDestinoID")
    private Aeropuerto aeropuertoDestino;

    // FK -> Piloto (Empleado)
    @ManyToOne
    @JoinColumn(name = "PilotoID")
    private Empleado piloto;

    @Column(name = "FechaSalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;

    @Column(name = "FechaLlegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;

    // Relación: un vuelo puede tener muchas reservas
    @OneToMany(mappedBy = "vuelo")
    private List<Reserva> reservas;

    // Getters y Setters
    public Integer getVueloID() { return vueloID; }
    public void setVueloID(Integer vueloID) { this.vueloID = vueloID; }

    public Avion getAvion() { return avion; }
    public void setAvion(Avion avion) { this.avion = avion; }

    public Aeropuerto getAeropuertoOrigen() { return aeropuertoOrigen; }
    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) { this.aeropuertoOrigen = aeropuertoOrigen; }

    public Aeropuerto getAeropuertoDestino() { return aeropuertoDestino; }
    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) { this.aeropuertoDestino = aeropuertoDestino; }

    public Empleado getPiloto() { return piloto; }
    public void setPiloto(Empleado piloto) { this.piloto = piloto; }

    public Date getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(Date fechaSalida) { this.fechaSalida = fechaSalida; }

    public Date getFechaLlegada() { return fechaLlegada; }
    public void setFechaLlegada(Date fechaLlegada) { this.fechaLlegada = fechaLlegada; }

    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }
}
