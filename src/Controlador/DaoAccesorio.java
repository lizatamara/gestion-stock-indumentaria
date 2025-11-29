/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import BD.Conexion;
import Modelo.Accesorio;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement; 
import java.sql.Date;
/**
 *
 * @author liza_
 */
public class DaoAccesorio {
    
    private Connection conexion;

    public DaoAccesorio() {
    }
    
    // agregar
    
    public boolean agregarAccesorio(Accesorio a) throws SQLException{
        boolean centinela = false;
        try {
            this.conexion = new Conexion().obtenerConexion();
            String query = "insert into ACCESORIO values(?,?,?,?,?,?,?)";
            CallableStatement cs = this.conexion.prepareCall(query);
            cs.setInt(1, a.getId_accesorio());
            cs.setString(2, a.getTipo());
            cs.setString(3, a.getMarca());
            cs.setString(4, a.getModelo());
            cs.setString(5, String.valueOf(a.getTemporada()));
            cs.setInt(6, a.getPrecio());
            if (a.getFecha_ingreso() != null) {
                cs.setDate(7, new Date(a.getFecha_ingreso().getTime()));
            } else {
                cs.setDate(7, new Date(System.currentTimeMillis()));
            }
            if(cs.executeUpdate()>0){centinela=true;}
        } catch (Exception e) {
            System.err.println("Error add "+e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
    }
}
