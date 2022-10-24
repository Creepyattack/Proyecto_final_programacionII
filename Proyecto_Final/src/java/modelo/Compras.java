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
public class Compras extends Persona{
    private int idCompra, no_compra, idProveedor;
    private String fechaorden,fechaingreso;
    private Conexion cn;
    
    public Compras(){
        
    }
    public Compras(int idCompra, int no_compra, int idProveedor, String fechaorden, String fechaingreso) {
        this.idCompra = idCompra;
        this.no_compra = no_compra;
        this.idProveedor = idProveedor;
        this.fechaorden = fechaorden;
        this.fechaingreso = fechaingreso;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getNo_compra() {
        return no_compra;
    }

    public void setNo_compra(int no_compra) {
        this.no_compra = no_compra;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(String fechaorden) {
        this.fechaorden = fechaorden;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    
    @Override
    public int agregar(){
       int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query="INSERT INTO compras(no_orden_compra,idProveedor,fecha_orden,fechaingreso) VALUES(?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getNo_compra());
            parametro.setInt(2, this.getIdProveedor());
            parametro.setString(3, this.getFechaorden());
            parametro.setString(4, this.getFechaingreso());
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
            String query="UPDATE compras SET idCompra=?,no_orden_compra=?,idProveedor=?,fecha_orden=?,fechaingreso=? WHERE idCompra=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getNo_compra());
            parametro.setInt(2, this.getIdProveedor());
            parametro.setString(3, this.getFechaorden());
            parametro.setString(4, this.getFechaingreso());
            parametro.setInt(5, this.getIdCompra());
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
            String query="DELETE FROM compras WHERE idCompra=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getIdCompra());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
         return retorno;
     }
    
}
