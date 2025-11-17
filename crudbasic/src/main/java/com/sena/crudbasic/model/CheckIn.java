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

@Entity(name = "checkin")
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CheckInID")
    private Integer checkInID;

    // FK -> Reserva
    @ManyToOne
    @JoinColumn(name = "ReservaID")
    private Reserva reserva;

    // FK -> Asiento
    @ManyToOne
    @JoinColumn(name = "AsientoID")
    private Asiento asiento;

    @Column(name = "FechaCheckIn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCheckIn;

    // Relación: un checkin puede tener equipajes
    @OneToMany(mappedBy = "checkIn")
    private List<Equipaje> equipajes;

    // Getters y Setters
    public Integer getCheckInID() { return checkInID; }
    public void setCheckInID(Integer checkInID) { this.checkInID = checkInID; }

    public Reserva getReserva() { return reserva; }
    public void setReserva(Reserva reserva) { this.reserva = reserva; }

    public Asiento getAsiento() { return asiento; }
    public void setAsiento(Asiento asiento) { this.asiento = asiento; }

    public Date getFechaCheckIn() { return fechaCheckIn; }
    public void setFechaCheckIn(Date fechaCheckIn) { this.fechaCheckIn = fechaCheckIn; }

    public List<Equipaje> getEquipajes() { return equipajes; }
    public void setEquipajes(List<Equipaje> equipajes) { this.equipajes = equipajes; }
}
