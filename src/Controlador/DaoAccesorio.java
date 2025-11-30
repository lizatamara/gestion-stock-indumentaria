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
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author liza_
 */
public class DaoAccesorio {
    
    private Connection conexion;

    public DaoAccesorio() {
    }
    
    // Agregar
    
    public boolean agregarAccesorio(Accesorio a) throws SQLException{
        boolean centinela = false;
        try {
            this.conexion = new Conexion().obtenerConexion();
            String query = "insert into ACCESORIO values(?,?,?,?,?,?)";
            CallableStatement cs = this.conexion.prepareCall(query);
            cs.setInt(1, a.getId_accesorio());
            cs.setString(2, a.getTipo());
            cs.setString(3, a.getMarca());
            cs.setString(4, a.getModelo());
            cs.setInt(5, a.getPrecio());
            if (a.getFecha_ingreso() != null) {
                cs.setDate(6, new Date(a.getFecha_ingreso().getTime()));
            } else {
                cs.setDate(6, new Date(System.currentTimeMillis()));
            }
            if(cs.executeUpdate()>0){centinela=true;}
        } catch (Exception e) {
            System.err.println("Error add "+e.getMessage());
        } finally {
            this.conexion.close();
        }
        return centinela;
    }
    
    // Listar
    public List<Accesorio> listarAccesorio() throws SQLException{
        List<Accesorio> listado = new ArrayList<>();
        try {
            this.conexion = new Conexion().obtenerConexion();
            String query = "select * from ACCESORIO order by id_accesorio";
            CallableStatement cs = this.conexion.prepareCall(query);
            
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                Accesorio a = new Accesorio();
                a.setId_accesorio(rs.getInt("ID_ACCESORIO"));
                a.setTipo(rs.getString("TIPO"));
                a.setMarca(rs.getString("MARCA"));
                a.setModelo(rs.getString("MODELO"));
                a.setPrecio(rs.getInt("PRECIO"));
                a.setFecha_ingreso(rs.getDate("FECHA_INGRESO"));
                listado.add(a);
            }
        } catch (Exception e) {
            System.err.println("Error Listar "+e.getMessage());
            
        } finally {
            this.conexion.close();
        }
        return listado;
    }
    
}
