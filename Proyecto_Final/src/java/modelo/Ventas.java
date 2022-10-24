/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ppbet
 */
public class Ventas extends Persona{
    private int idVenta,nofactura,idCliente,idEmpleado;
    private String serie,fechafactura,fechaIngreso;
    private Conexion cn;
    
    public Ventas(){
        
    }
    
    public Ventas(int idVenta, int nofactura, int idCliente, int idEmpleado, String serie, String fechafactura, String fechaIngreso) {
        this.idVenta = idVenta;
        this.nofactura = nofactura;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.serie = serie;
        this.fechafactura = fechafactura;
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getNofactura() {
        return nofactura;
    }

    public void setNofactura(int nofactura) {
        this.nofactura = nofactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFechafactura() {
        return fechafactura;
    }

    public void setFechafactura(String fechafactura) {
        this.fechafactura = fechafactura;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    
    @Override
    public int agregar(){
       int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query="INSERT INTO ventas(nofactura,serie,facturafecha,idCliente,idEmpleado,fechaingreso) VALUES(?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getNofactura());
            parametro.setString(2, this.getSerie());
            parametro.setString(3, this.getFechafactura());
            parametro.setInt(4, this.getIdCliente());
            parametro.setInt(5, this.getIdEmpleado());
            parametro.setString(6, this.getFechaIngreso());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
       
       return retorno;
     }
    
    @Override
    public int modificar(){
         int retorno = 0;
         try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query="UPDATE ventas SET nofactura=?,serie=?,facturafecha=?,idCliente=?,idEmpleado=?,fechaingreso=? WHERE idVenta=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getNofactura());
            parametro.setString(2, this.getSerie());
            parametro.setString(3, this.getFechafactura());
            parametro.setInt(4, this.getIdCliente());
            parametro.setInt(5, this.getIdEmpleado());
            parametro.setString(6, this.getFechaIngreso());
            parametro.setInt(7, this.getIdVenta());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
         return retorno;
     }
    
    @Override
    public int eliminar(){
         int retorno = 0;
          try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query="DELETE FROM ventas WHERE idVenta=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getIdVenta());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
         return retorno;
     }
    
}
