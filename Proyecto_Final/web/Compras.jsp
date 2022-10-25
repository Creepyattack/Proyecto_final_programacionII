<%-- 
    Document   : Compras
    Created on : 25 oct. 2022, 11:31:00
    Author     : ppbet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
         <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
             <!-- Brand -->
            <a class="navbar-brand" href="Compras.jsp">Tabla de Compras</a>
            <ul class="navbar-nav">
              <!-- Dropdown -->
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                  Productos
                </a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="Productos.jsp">Tabla de Productos</a>
                  <a class="dropdown-item" href="Marca.jsp">Tabla de Marcas</a>
                </div>
              </li>
              <!-- Dropdown -->
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                  Ventas
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="Ventas.jsp">Tabla de Ventas</a>
                  <a class="dropdown-item" href="Empleados.jsp">Tabla de Empleados</a>
                  <a class="dropdown-item" href="Clientes.jsp">Tabla de Clientes</a>
                  <a class="dropdown-item" href="Puestos.jsp">Tabla de Puestos</a>
                </div>
              </li>
              <!-- Dropdown -->
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                  Compras
                </a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="Proveedor.jsp">Tabla de Proveedores</a>
                </div>
              </li>
              
            </ul>
          </nav>
        
        
        <div style="text-align: left;">
            <button type="button" class="btn btn-primary" id="nuevo" data-toggle="modal" data-target="#modal_compras" onclick="limpiar()">Ingresar una Compra</button>
            </div>
        <div class="container">
            <div class="modal" id="modal_compras">
    <div class="modal-dialog">
      <div class="modal-content">
                <div class="modal-body">
                
                <label for="lbl_id"><b>ID:</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value = "0" readonly>
                <br>
                <label for="lbl_orden"><b>No de Orden de Compra:</b></label>
                <input type="number" name="txt_orden" id="txt_orden" class="form-control" placeholder="Ejemplo: Nombre1 Nombre2" required >
                <br>
                <label for="lbl_proveedor"><b>Proveedor:</b></label>
                <select name="drop_proveedor" id="drop_proveedor" class="form-control">
                    
                </select>
                <br>
                <label for="lbl_fechaorden"><b>Fecha de orden:</b></label>
                <input type="date" name="txt_fechaorden" id="txt_fechaorden" class="form-control" placeholder="Ejemplo: 541515156168" required >
                <br>
                <label for="lbl_fi"><b>Fecha Ingreso:</b></label>
                <input type="datetime-local" name="txt_fi" id="txt_fi" class="form-control" required >
                <br>
                <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" onclick="javascript:if(!confirm('Desea Eliminar?'))return false">Eliminar</button>
                <button type="button" class="btn btn-warning" data-dismiss="modal">Cerrar</button>
                
           </div>
      </div>
    </div>
  </div>
 </div>
        
        
        <div style="text-align: right;">
            <button type="button" class="btn btn-secondary" id="nuevo" data-toggle="modal" data-target="#modal_comprasdetalle" onclick="limpiar()">Ingresar un detalle de Compra</button>
            </div>
        <div class="container">
            <div class="modal" id="modal_comprasdetalle">
    <div class="modal-dialog">
      <div class="modal-content">
                <div class="modal-body">
                
                <label for="lbl_id"><b>ID:</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value = "0" readonly>
                <br>
                <label for="lbl_compra"><b>Orden de Compra:</b></label>
                <select name="drop_compra" id="drop_compra" class="form-control">
                    
                </select>
                <br>
                <label for="lbl_producto"><b>Producto:</b></label>
                <select name="drop_producto" id="drop_producto" class="form-control">
                    
                </select>
                <br>
                <label for="lbl_cantidad"><b>Cantidad:</b></label>
                <input type="number" name="txt_cantidad" id="txt_cantidad" class="form-control" placeholder="Ejemplo: 541515156168" required >
                <br>
                <label for="lbl_preciocosto"><b>Precio Costo Unitario:</b></label>
                <input type="text" name="txt_preciocosto" id="txt_preciocosto" class="form-control" required >
                <br>
                <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" onclick="javascript:if(!confirm('Desea Eliminar?'))return false">Eliminar</button>
                <button type="button" class="btn btn-warning" data-dismiss="modal">Cerrar</button>
                
           </div>
      </div>
    </div>
  </div>
 </div>
        
  <table class="table">
    <thead class="thead-light">
      <tr>
        <th>No. de Orden compra</th>
        <th>Proveedor</th>
        <th>Fecha de Orden</th>
        <th>Fecha de Ingreso</th>
      </tr>
    </thead>
    <tbody id="tbl_compras">
        
    </tbody>
  </table>      
        <br>
        
        <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>Compra</th>
        <th>Producto</th>
        <th>Cantidad</th>
        <th>Precio costo Unitario</th>
      </tr>
    </thead>
    <tbody id="tbl_compras">
        
    </tbody>
  </table>      
        
        
        
        
         <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
       <footer  style="bottom: 0px;width:100%; margin-top: -10px; padding: 50px;position: absolute;clear: both; background: gainsboro; text-align: center; color: black;"  >

    <p> ©  Copyright: Jose Alberto Najera Mendez</p>
</footer>   
    </body>
</html>
