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
public class Compras_detalle extends Persona{
    private int idcompra_detalle,idcompra,idproduto,cantidad;
    private float precio_costo;
    private Conexion cn;
    
    public Compras_detalle(){
        
    }
    public Compras_detalle(int idcompra_detalle, int idcompra, int idproduto, int cantidad, float precio_costo) {
        this.idcompra_detalle = idcompra_detalle;
        this.idcompra = idcompra;
        this.idproduto = idproduto;
        this.cantidad = cantidad;
        this.precio_costo = precio_costo;
    }

    public int getIdcompra_detalle() {
        return idcompra_detalle;
    }

    public void setIdcompra_detalle(int idcompra_detalle) {
        this.idcompra_detalle = idcompra_detalle;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(float precio_costo) {
        this.precio_costo = precio_costo;
    }
    
    @Override
    public int agregar(){
       int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query="INSERT INTO compras_detalle(idCompra,idProducto,cantidad,precio_costo_unitario) VALUES(?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getIdcompra());
            parametro.setInt(2, this.getIdproduto());
            parametro.setInt(3, this.getCantidad());
            parametro.setFloat(4, this.getPrecio_costo());
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
            String query="UPDATE compras_detalle SET idCompra_detalle=?,idCompra=?,idProducto=?,cantidad=?,precio_costo_unitario=? WHERE idCompra_detalle=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getIdcompra());
            parametro.setInt(2, this.getIdproduto());
            parametro.setInt(3, this.getCantidad());
            parametro.setFloat(4, this.getPrecio_costo());
            parametro.setInt(5, this.getIdcompra_detalle());
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
            String query="DELETE FROM compras_detalle WHERE idCompra_detalle=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getIdcompra_detalle());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
         return retorno;
     }
}
