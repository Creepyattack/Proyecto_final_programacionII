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
public class Empleados extends Persona{
    private String DPI,genero,fecha_incio_labores,fechaingreso;
    private int idPuestos;
    private Conexion cn;
    
    public Empleados(){
        
    }
    public Empleados(String DPI, String genero, String fecha_incio_labores, String fechaingreso, int idPuestos, int id, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(id, nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.DPI = DPI;
        this.genero = genero;
        this.fecha_incio_labores = fecha_incio_labores;
        this.fechaingreso = fechaingreso;
        this.idPuestos = idPuestos;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_incio_labores() {
        return fecha_incio_labores;
    }

    public void setFecha_incio_labores(String fecha_incio_labores) {
        this.fecha_incio_labores = fecha_incio_labores;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public int getIdPuestos() {
        return idPuestos;
    }

    public void setIdPuestos(int idPuestos) {
        this.idPuestos = idPuestos;
    }
    
     public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        
        try{
            cn = new Conexion();
            cn.abrir_conexion();
            String query = "SELECT e.idEmpleado as id,e.nombres,e.apellidos,e.direccion,e.telefono,e.DPI,e.genero,e.fecha_nacimiento,p.puesto,p.idPuesto,e.fecha_inicio_labores,e.fechaingreso FROM empleados as e inner join puestos as p on e.idPuesto = p.idPuesto;";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","nombres","apellidos","direccion","telefono","DPI","genero","nacimiento","puesto","idPuesto","fecha_inicio","fecha_ingreso"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[12];
            while(consulta.next()){
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("nombres");
                datos[2] = consulta.getString("apellidos");
                datos[3] = consulta.getString("direccion");
                datos[4] = consulta.getString("telefono");
                datos[5] = consulta.getString("DPI");
                datos[6] = consulta.getString("genero");
                datos[7] = consulta.getString("fecha_nacimiento");
                datos[8] = consulta.getString("puesto");
                datos[9] = consulta.getString("idPuesto");
                datos[10] = consulta.getString("fecha_inicio_labores");
                datos[11] = consulta.getString("fechaingreso");
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
            String query="INSERT INTO empleados(nombres,apellidos,direccion,telefono,DPI,genero,fecha_nacimiento,idPuesto,fecha_inicio_labores,fechaingreso) VALUES(?,?,?,?,?,?,?,?,?,?);";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, this.getNombres());
            parametro.setString(2, this.getApellidos());
            parametro.setString(3, this.getDireccion());
            parametro.setString(4, this.getTelefono());
            parametro.setString(5, this.getDPI());
            parametro.setString(6, this.getGenero());
            parametro.setString(7, this.getFecha_nacimiento());
            parametro.setInt(8, this.getIdPuestos());
            parametro.setString(9, this.getFecha_incio_labores());
            parametro.setString(10, this.getFechaingreso());
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
            String query="UPDATE empleados SET nombres=?,apellidos=?,direccion=?,telefono=?,DPI=?,genero=?,fecha_nacimiento=?,idPuesto=?,fecha_inicio_labores=?,fechaingreso=? WHERE idEmpleado=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1, this.getNombres());
            parametro.setString(2, this.getApellidos());
            parametro.setString(3, this.getDireccion());
            parametro.setString(4, this.getTelefono());
            parametro.setString(5, this.getDPI());
            parametro.setString(6, this.getGenero());
            parametro.setString(7, this.getFecha_nacimiento());
            parametro.setInt(8, this.getIdPuestos());
            parametro.setString(9, this.getFecha_incio_labores());
            parametro.setString(10, this.getFechaingreso());
            parametro.setInt(11, this.getId());
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
            String query="DELETE FROM empleados WHERE idEmpleado=?;";
            cn.abrir_conexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, this.getId());
            retorno = parametro.executeUpdate();
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
         return retorno;
     }
}
