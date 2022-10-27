/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query = "SELECT c.idCompra as id,c.no_orden_compra,p.idProveedor,p.proveedor,c.fecha_orden,c.fechaingreso FROM compras as c inner join proveedores as p on c.idProveedor = p.idProveedor;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","no_orden_compra","idProveedor","proveedor","fecha_orden","fechaingreso"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[6];
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("no_orden_compra");
                datos[2] = consulta.getString("idProveedor");
                datos[3] = consulta.getString("proveedor");
                datos[4] = consulta.getString("fecha_orden");
                datos[5] = consulta.getString("fechaingreso");
                tabla.addRow(datos);
            }
            cn.cerrar_conexion();
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
    
    public HashMap drop_compra(){
        HashMap<String,String> drop = new HashMap();
        try{
            cn = new Conexion();
            String query="SELECT idCompra as id,no_orden_compra FROM compras;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while(consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("no_orden_compra"));
            }
            cn.cerrar_conexion();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return drop;
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
