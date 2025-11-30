/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author liza_
 */
public class Accesorio {
    
    private int id_accesorio;
    private String tipo;
    private String marca;
    private String modelo;
    private int precio;
    private Date fecha_ingreso;

    public Accesorio() {
    }

    public Accesorio(int id_accesorio, String tipo, String marca, String modelo, int precio, Date fecha_ingreso) {
        this.id_accesorio = id_accesorio;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_accesorio() {
        return id_accesorio;
    }

    public void setId_accesorio(int id_accesorio) {
        this.id_accesorio = id_accesorio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    @Override
    public String toString() {
        return "Accesorio{" + "id_accesorio=" + id_accesorio + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", fecha_ingreso=" + fecha_ingreso + '}';
    }
    
}
