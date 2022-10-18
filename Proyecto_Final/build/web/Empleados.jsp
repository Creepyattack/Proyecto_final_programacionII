<%-- 
    Document   : Empleados
    Created on : 17 oct. 2022, 13:53:15
    Author     : ppbet
--%>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page import="java.util.HashMap" %>
<%@page import="modelo.Puestos" %>
<%@page import="modelo.Empleados" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <h1>Ingreso Tabla Empleados</h1>
        <form action="sr_empleado" method="post" class="form-group" >
                <label for="lbl_id"><b>ID:</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value = "0" readonly>
                <br>
                <label for="lbl_nombres"><b>Nombres:</b></label>
                <input type="text" name="txt_nombres" id="txt_nombres" class="form-control" placeholder="Ejemplo: Nombre1 Nombre2" required >
                <br>
                <label for="lbl_apellidos"><b>Apellidos:</b></label>
                <input type="text" name="txt_apellidos" id="txt_apellidos" class="form-control" placeholder="Ejemplo: Apellido1 Apellido2" required >
                <br>
                <label for="lbl_direccion"><b>Direccion:</b></label>
                <input type="text" name="txt_direccion" id="txt_direccion" class="form-control" placeholder="Ejemplo: No. Casa Calle Zona Ciudad" required >
                <br>
                <label for="lbl_telefono"><b>Telefono:</b></label>
                <input type="number" name="txt_telefono" id="txt_telefono" class="form-control" placeholder="Ejemplo: 5555555555" required >
                <br>
                <label for="lbl_dpi"><b>DPI:</b></label>
                <input type="text" name="txt_dpi" id="txt_dpi" class="form-control" placeholder="5555555555555555" required >
                <br>
                <label for="lbl_genero"><b>Genero:</b></label>
                <input type="text" name="txt_genero" id="txt_genero" class="form-control" placeholder="Ejemplo: M o F" required >
                <br>
                <label for="lbl_fn"><b>Fecha de Nacimiento:</b></label>
                <input type="date" name="txt_fn" id="txt_fn" class="form-control" required >
                <br>
                <label for="lbl_puesto"><b>Puesto:</b></label>
                <select name="drop_puesto" id="drop_puesto" class="form-control">
                    <%
                        Puestos puesto = new Puestos();
                        HashMap<String,String> drop = puesto.drop_puesto();
                        for(String i: drop.keySet()){
                            out.println("<option value='"+ i +"' >"+ drop.get(i) +"</option>");
                        }
                    %>
                </select>
                <a href="Puestos.jsp">No existe el Puesto Ingresalo Aqui</a>
                <br>
                <label for="lbl_fil"><b>Fecha Inicio de Labores:</b></label>
                <input type="date" name="txt_fil" id="txt_fil" class="form-control" required >
                <br>
                <label for="lbl_fi"><b>Fecha Ingreso:</b></label>
                <input type="datetime-local" name="txt_fi" id="txt_fi" class="form-control" required >
                <br>
                <button type="button" class="btn btn-primary" onclick="limpiar()">Nuevo</button>
                <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" onclick="javascript:if(!confirm('Desea Eliminar?'))return false">Eliminar</button>
        </form>
     <table class="table table-striped">
    <thead>
      <tr>
        <th>Nombres</th>
        <th>Apellidos</th>
        <th>Direccion</th>
        <th>Telefono</th>
        <th>DPI</th>
        <th>Genero</th>
        <th>Nacimiento</th>
        <th>Puesto</th>
        <th>Inicio Labores</th>
        <th>Ingreso</th>
      </tr>
    </thead>
    <tbody id="tbl_empleados">
        <% 
        Empleados empleado = new Empleados();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = empleado.leer();
        for(int t=0; t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_p=" + tabla.getValueAt(t,9) + " >");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,3) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,5) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,7) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,8) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,10) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,11) + "</td>");
            out.println("</tr>");
            }
        %>
    
    </tbody>
  </table> 
                
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function limpiar(){
               $("#txt_id").val(0);
               $("#txt_nombres").val('');
               $("#txt_apellidos").val('');
               $("#txt_direccion").val('');
               $("#txt_telefono").val('');
               $("#txt_dpi").val('');
               $("#txt_genero").val('');
               $("#txt_fn").val('');
               $("#drop_puesto").val('');
               $("#txt_fil").val('');
               $("#txt_fi").val('');
            }
            $('#tbl_empleados').on('click','tr td',function(evt){
               var target,id,id_p,nombres,apellidos,direccion,telefono,dpi,genero,nacimiento,inicio,ingreso;
               target = $(event.target);
               id = target.parent().data('id');
               id_p = target.parent().data('id_p');
               nombres = target.parent("tr").find("td").eq(0).html(); 
               apellidos = target.parent("tr").find("td").eq(1).html();
               direccion = target.parent("tr").find("td").eq(2).html();
               telefono = target.parent("tr").find("td").eq(3).html();
               dpi = target.parent("tr").find("td").eq(4).html();
               genero = target.parent("tr").find("td").eq(5).html();
               nacimiento = target.parent("tr").find("td").eq(6).html();
               inicio = target.parent("tr").find("td").eq(8).html();
               ingreso = target.parent("tr").find("td").eq(9).html();
               
               $("#txt_id").val(id);
               $("#txt_nombres").val(nombres);
               $("#txt_apellidos").val(apellidos);
               $("#txt_direccion").val(direccion);
               $("#txt_telefono").val(telefono);
               $("#txt_dpi").val(dpi);
               $("#txt_genero").val(genero);
               $("#txt_fn").val(nacimiento);
               $("#drop_puesto").val(id_p);
               $("#txt_fil").val(inicio);
               $("#txt_fi").val(ingreso);
            });
            </script>
    </body>
</html>
