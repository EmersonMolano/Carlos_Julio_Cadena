package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity(name = "pasajero")
public class Pasajero {

    // anotación bean para id de la entidad
    @Id
    // anotación para autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // indicar que el campo es una columna
    @Column(name = "PasajeroID")
    private Integer pasajeroID;

    @Column(name = "Nombre", length = 80)
    private String nombre;

    @Column(name = "Apellido", length = 80)
    private String apellido;

    @Column(name = "Documento", length = 30, unique = true)
    private String documento;

    @Column(name = "Email", length = 120)
    private String email;

    @Column(name = "Telefono", length = 20)
    private String telefono;

    // Relación: un pasajero puede tener muchas reservas
    @OneToMany(mappedBy = "pasajero")
    private List<Reserva> reservas;

    // Getters y Setters
    public Integer getPasajeroID() { return pasajeroID; }
    public void setPasajeroID(Integer pasajeroID) { this.pasajeroID = pasajeroID; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }
}
