/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ppbet
 */
public class Proveedor extends Persona{
    private int idProveedor;
    private String proveedor,nit,telefono,direccion;
    private Conexion cn;
    
    public Proveedor(){
        
    }
    public Proveedor(int idProveedor, String proveedor, String nit, String telefono, String direccion) {
        this.idProveedor = idProveedor;
        this.proveedor = proveedor;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public HashMap drop_proveedor(){
        HashMap<String,String> drop = new HashMap();
        try{
            cn = new Conexion();
            String query="SELECT idProveedor as id,proveedor FROM proveedores;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while(consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("proveedor"));
            }
            cn.cerrar_conexion();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return drop;
    }
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query = "SELECT p.idProveedor as id,proveedor,NIT,direccion,telefono FROM proveedores as p;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","proveedor","nit","direccion","telefono"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[5];
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("proveedor");
                datos[2] = consulta.getString("NIT");
                datos[3] = consulta.getString("direccion");
                datos[4] = consulta.getString("telefono");
                tabla.addRow(datos);
            }
            cn.cerrar_conexion();
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
    
    @Override
    public int agregar(){
       int retorno = 0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query="INSERT INTO proveedores(proveedor,NIT,direccion,telefono) VALUES(?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, this.getProveedor());
            parametro.setString(2, this.getNit());
            parametro.setString(3, this.getDireccion());
            parametro.setString(4, this.getTelefono());
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
            String query="UPDATE proveedores SET proveedor=?,NIT=?,direccion=?,telefono=? WHERE idProveedor=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, this.getProveedor());
            parametro.setString(2, this.getNit());
            parametro.setString(3, this.getDireccion());
            parametro.setString(4, this.getTelefono());
            parametro.setInt(5, this.getIdProveedor());
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
            String query="DELETE FROM proveedores WHERE idProveedor=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getIdProveedor());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
         return retorno;
     }
}
