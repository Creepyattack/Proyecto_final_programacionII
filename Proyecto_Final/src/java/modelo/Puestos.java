/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ppbet
 */
public class Puestos extends Persona{
    private int idPuestos;
    private String puesto;
    private Conexion cn;
    public Puestos(){
        
    }
    public Puestos(int idPuestos, String puesto) {
        this.idPuestos = idPuestos;
        this.puesto = puesto;
    }

    public int getIdPuestos() {
        return idPuestos;
    }

    public void setIdPuestos(int idPuestos) {
        this.idPuestos = idPuestos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query = "SELECT p.idPuesto as id,puesto FROM puestos as p;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","puesto"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[2];
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("puesto");
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
            String query="INSERT INTO puestos(puesto) VALUES(?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, this.getPuesto());
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
            String query="UPDATE puestos SET puesto = ? WHERE idPuesto = ?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, this.getPuesto());
            parametro.setInt(2, this.getIdPuestos());
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
            String query="DELETE FROM puestos WHERE idPuesto=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getIdPuestos());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
         return retorno;
    }
}
