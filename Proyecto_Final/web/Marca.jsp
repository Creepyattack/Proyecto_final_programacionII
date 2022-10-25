<%-- 
    Document   : Marca
    Created on : 18 oct. 2022, 15:34:11
    Author     : ppbet
--%>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page import="java.util.HashMap" %>
<%@page import="modelo.Marca" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marcas</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
             <!-- Brand -->
            <a class="navbar-brand" href="Marca.jsp">Tabla de Marcas</a>
            <ul class="navbar-nav">
              <!-- Dropdown -->
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                  Productos
                </a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="Productos.jsp">Tabla de Productos</a>
                </div>
              </li>
              <!-- Dropdown -->
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                  Ventas
                </a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="Ventas.jsp">Tabla de Ventas</a>
                  <a class="dropdown-item" href="Clientes.jsp">Tabla de Clientes</a>
                  <a class="dropdown-item" href="Empleados.jsp">Tabla de Empleados</a>
                  <a class="dropdown-item" href="Puestos.jsp">Tabla de Puestos</a>
                </div>
              </li>
              <!-- Dropdown -->
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                  Compras
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="Compras.jsp">Tabla de Compras</a>
                  <a class="dropdown-item" href="Proveedor.jsp">Tabla de Proveedores</a>
                </div>
              </li>
              
            </ul>
          </nav>
        
        <div style="text-align: center;">
            <button type="button" class="btn btn-primary" id="nuevo" data-toggle="modal" data-target="#modal_marca" onclick="limpiar()">Ingresar un registro</button>
            </div>
        <div class="container">
            <div class="modal" id="modal_marca">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-body">
        <form action="sr_marca" method="post" class="form-group" >
        <label for="lbl_id"><b>ID:</b></label>
        <input type="text" name="txt_id" id="txt_id" class="form-control" value = "0" readonly>
        <label for="lbl_marca"><b>Marca:</b></label>
        <input type="text" name="txt_marca" id="txt_marca" class="form-control" placeholder="Ejemplo: Dos Pinos" required >
        <br>
        <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
        <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
        <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" onclick="javascript:if(!confirm('Desea Eliminar?'))return false">Eliminar</button>
        <button type="button" class="btn btn-warning" data-dismiss="modal">Cerrar</button>
        </form>
   </div>
      </div>
    </div>
  </div>

        
        
    <table class="table">
    <thead class="thead-light">
      <tr>
        <th>Marca</th>
      </tr>
    </thead>
    <tbody id="tbl_marcas">
        <% 
        Marca marcas = new Marca();
        DefaultTableModel tabla = new DefaultTableModel();
        tabla = marcas.leer();
        for(int t=0; t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " >");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("</tr>");
            }
        %>
    </tbody>
  </table> 
 </div>   
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function limpiar(){
               $("#txt_id").val(0);
               $("#txt_marca").val('');
            }
            $('#tbl_marcas').on('click','tr td',function(evt){
               var target,id,marca;
               target = $(event.target);
               id = target.parent().data('id');
               marca = target.parent("tr").find("td").eq(0).html(); 
               
               $("#txt_id").val(id);
               $("#txt_marca").val(marca);
               $("#modal_marca").modal('show');
            });
            </script>
            
            
<footer  style="bottom: 0px;width:100%; margin-top: -10px; padding: 50px;position: absolute;clear: both; background: gainsboro; text-align: center; color: black;"  >

    <p> ©  Copyright: Jose Alberto Najera Mendez</p>
</footer>    
</body>
</html>
