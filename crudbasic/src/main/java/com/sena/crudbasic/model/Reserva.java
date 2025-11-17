package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReservaID")
    private Integer reservaID;

    // FK -> Pasajero
    @ManyToOne
    @JoinColumn(name = "PasajeroID")
    private Pasajero pasajero;

    // FK -> Vuelo
    @ManyToOne
    @JoinColumn(name = "VueloID")
    private Vuelo vuelo;

    @Column(name = "FechaReserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReserva;

    @Column(name = "Estado", length = 20)
    private String estado;

    // Relacion: una reserva puede tener un checkin, pagos, etc.
    @OneToMany(mappedBy = "reserva")
    private List<CheckIn> checkIns;

    @OneToMany(mappedBy = "reserva")
    private List<Pago> pagos;

    // Getters y Setters
    public Integer getReservaID() { return reservaID; }
    public void setReservaID(Integer reservaID) { this.reservaID = reservaID; }

    public Pasajero getPasajero() { return pasajero; }
    public void setPasajero(Pasajero pasajero) { this.pasajero = pasajero; }

    public Vuelo getVuelo() { return vuelo; }
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }

    public Date getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(Date fechaReserva) { this.fechaReserva = fechaReserva; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public List<CheckIn> getCheckIns() { return checkIns; }
    public void setCheckIns(List<CheckIn> checkIns) { this.checkIns = checkIns; }

    public List<Pago> getPagos() { return pagos; }
    public void setPagos(List<Pago> pagos) { this.pagos = pagos; }
}
