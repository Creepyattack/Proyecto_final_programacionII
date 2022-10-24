<%-- 
    Document   : Productos
    Created on : 24 oct. 2022, 07:23:29
    Author     : ppbet
--%>
<%@page import="javax.swing.table.DefaultTableModel" %>
<%@page import="java.util.HashMap" %>
<%@page import="modelo.Marca" %>
<%@page import="modelo.Productos" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <style>
            
        </style>
    </head>
    <body>
        <h1>Tabla de Productos</h1>
                <form action="sr_productos" method="post" class="form-group">
                <label for="lbl_id"><b>ID:</b></label>
                <input type="text" name="txt_id" id="txt_id" class="form-control" value = "0" readonly>
                <br>
                <label for="lbl_producto"><b>Producto:</b></label>
                <input type="text" name="txt_producto" id="txt_producto" class="form-control" placeholder="Ejemplo: Leche" required >
                <br>
                <label for="lbl_marca"><b>Marca:</b></label>
                <select name="drop_marca" id="drop_marca" class="form-control">
                    <%
                        Marca marca = new Marca();
                        HashMap<String,String> drop = marca.drop_marca();
                        for(String i: drop.keySet()){
                            out.println("<option value='"+ i +"' >"+ drop.get(i) +"</option>");
                        }
                    %>
                </select>
                <br>
                <label for="lbl_descripcion"><b>Descripcion:</b></label>
                <input type="text" name="txt_descripcion" id="txt_descripcion" class="form-control" placeholder="Ejemplo: deslactosada" required >
                <br>
                <label for="lbl_imagen"><b>Imagen:</b></label>
                <img src="" id="imagen" style="width: 250px; height: 300px; border: dashed blueviolet">
                <input type="file" onchange="mostrarimagen();">
                <div id="url">
                  <input type="text" name="txt_imagen" id="txt_imagen" class="form-control">
                </div>
                <br>
                <label for="lbl_preciocosto"><b>Precio costo:</b></label>
                <input type="text" name="txt_preciocosto" id="txt_preciocosto" class="form-control" placeholder="Ejemplo: 12.56" required >
                <br>
                <label for="lbl_precioventa"><b>Precio venta:</b></label>
                <input type="text" name="txt_precioventa" id="txt_precioventa" class="form-control" placeholder="Ejemplo: 13.56" required >
                <br>
                <label for="lbl_existencia"><b>Existencia:</b></label>
                <input type="number" name="txt_existencia" id="txt_existencia" class="form-control" placeholder="Ejemplo: 25" required >
                <br>
                <label for="lbl_fi"><b>Fecha Ingreso:</b></label>
                <input type="datetime-local" name="txt_fi" id="txt_fi" class="form-control" required >
                <br>
                <button name="btn_agregar" id="btn_agregar" value="agregar" class="btn btn-primary">Agregar</button>
                <button name="btn_modificar" id="btn_modificar" value="modificar" class="btn btn-success">Modificar</button>
                <button name="btn_eliminar" id="btn_eliminar" value="eliminar" class="btn btn-danger" onclick="javascript:if(!confirm('Desea Eliminar?'))return false">Eliminar</button>
                </form>
                
    <table class="table table-striped">
    <thead>
      <tr>
        <th>Producto</th>
        <th>Marca</th>
        <th>Descripcion</th>
        <th>Imagen</th>
        <th>Precio Costo</th>
        <th>Precio Venta</th>
        <th>Existencia</th>
        <th>Fecha de Ingreso</th>
      </tr>
    </thead>
    <tbody id="tbl_productos">
        <%
            Productos productos = new Productos();
            DefaultTableModel tabla = new DefaultTableModel();
            tabla = productos.leer();
            for(int t=0; t<tabla.getRowCount();t++){
            out.println("<tr data-id=" + tabla.getValueAt(t,0) + " data-id_m=" + tabla.getValueAt(t,3) + " >");
            out.println("<td>" + tabla.getValueAt(t,1) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,2) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,4) + "</td>");
            out.println("<td><img src=" + tabla.getValueAt(t,5) + "style='width: 250px; height: 300px;'></td>");
            out.println("<td>" + tabla.getValueAt(t,6) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,7) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,8) + "</td>");
            out.println("<td>" + tabla.getValueAt(t,9) + "</td>");
            out.println("</tr>");
            }
        %>
    </tbody>
  </table>             
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function mostrarimagen(){
                var preview=document.querySelector('img');
                var url=document.querySelector("input[name='txt_imagen']");
                var file=document.querySelector('input[type=file]').files[0];
                var leer = new FileReader();
                
                if(file){
                    leer.readAsDataURL(file);
                    leer.onloadend=function(){
                        preview.src=leer.result;
                        url.value=leer.result;
                    }
                    ;
                }
                else{
                    preview.src="";
                    url.value="";
                }
            }
            
            
            $('#tbl_productos').on('click','tr td',function(evt){
               var target,id,id_m,producto,descripcion,imagen,costo,venta,existencia,ingreso;
               target = $(event.target);
               id = target.parent().data('id');
               id_m = target.parent().data('id_m');
               producto = target.parent("tr").find("td").eq(0).html(); 
               descripcion = target.parent("tr").find("td").eq(2).html();
               imagen = target.parent("tr").find("img").eq(3).html();
               costo = target.parent("tr").find("td").eq(4).html();
               venta = target.parent("tr").find("td").eq(5).html();
               existencia = target.parent("tr").find("td").eq(6).html();
               ingreso = target.parent("tr").find("td").eq(7).html();
               
               $("#txt_id").val(id);
               $("#txt_producto").val(producto);
               $("#drop_marca").val(id_m);
               $("#txt_descripcion").val(descripcion);
               $("#txt_imagen").val(imagen);
               $("#txt_preciocosto").val(costo);
               $("#txt_precioventa").val(venta);
               $("#txt_existencia").val(existencia);
               $("#txt_fi").val(ingreso);
            });
            
        </script>
    </body>
</html>
