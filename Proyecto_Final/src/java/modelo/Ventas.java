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
    
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query = "SELECT v.idVenta as id,v.nofactura,v.serie,v.facturafecha,c.idCliente,c.nombres,e.idEmpleado,e.nombres,v.fechaingreso FROM ventas as v inner join clientes as c on v.idCliente = c.idCliente inner join empleados as e on v.idEmpleado = e.idEmpleado;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","nofactura","serie","facturafecha","idCliente","nombres","idEmpleado","nombres","fechaingreso"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[9];
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("nofactura");
                datos[2] = consulta.getString("serie");
                datos[3] = consulta.getString("facturafecha");
                datos[4] = consulta.getString("idCliente");
                datos[5] = consulta.getString("nombres");
                datos[6] = consulta.getString("idEmpleado");
                datos[7] = consulta.getString("nombres");
                datos[8] = consulta.getString("fechaingreso");
                tabla.addRow(datos);
            }
            cn.cerrar_conexion();
        }catch(SQLException ex){
           System.out.println(ex.getMessage());
        }
        
        return tabla;
    }
    
    public HashMap drop_venta(){
        HashMap<String,String> drop = new HashMap();
        try{
            cn = new Conexion();
            String query="SELECT idVenta as id,nofactura FROM ventas;";
            cn.abrir_conexion();
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            while(consulta.next()){
                drop.put(consulta.getString("id"), consulta.getString("nofactura"));
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
