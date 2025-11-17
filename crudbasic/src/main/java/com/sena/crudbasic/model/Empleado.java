package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpleadoID")
    private Integer empleadoID;

    @Column(name = "Nombre", length = 80)
    private String nombre;

    @Column(name = "Apellido", length = 80)
    private String apellido;

    @Column(name = "Cargo", length = 40)
    private String cargo;

    @Column(name = "FechaContratacion")
    @Temporal(TemporalType.DATE)
    private Date fechaContratacion;

    // Relación: un empleado puede ser piloto de varios vuelos (si ese es el caso)
    @OneToMany(mappedBy = "piloto")
    private List<Vuelo> vuelosComoPiloto;

    // Getters y Setters
    public Integer getEmpleadoID() { return empleadoID; }
    public void setEmpleadoID(Integer empleadoID) { this.empleadoID = empleadoID; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public Date getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(Date fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public List<Vuelo> getVuelosComoPiloto() { return vuelosComoPiloto; }
    public void setVuelosComoPiloto(List<Vuelo> vuelosComoPiloto) { this.vuelosComoPiloto = vuelosComoPiloto; }
}
