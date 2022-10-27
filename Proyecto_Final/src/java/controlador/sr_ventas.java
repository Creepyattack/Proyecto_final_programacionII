/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import modelo.Ventas;

/**
 *
 * @author ppbet
 */
public class sr_ventas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Ventas venta;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_ventas</title>");            
            out.println("</head>");
            out.println("<body>");
            venta = new Ventas(Integer.valueOf(request.getParameter("txt_id")),Integer.valueOf(request.getParameter("txt_nofactura")),Integer.valueOf(request.getParameter("drop_cliente")),Integer.valueOf(request.getParameter("drop_empleado")),request.getParameter("txt_serie"),request.getParameter("txt_fechafactura"),request.getParameter("txt_fi"));
            
            if("agregar".equals(request.getParameter("btn_agregar"))){
            if(venta.agregar()>0){
                response.sendRedirect("Ventas.jsp");
            }else{
                out.println("<h1>Error................</h1>");
                out.println("<a href='Ventas.jsp'>Regresar</a>");
            }
         }
           if("modificar".equals(request.getParameter("btn_modificar"))){
            if(venta.modificar()>0){
                response.sendRedirect("Ventas.jsp");
            }else{
                out.println("<h1>Error................</h1>");
                out.println("<a href='Ventas.jsp'>Regresar</a>");
            }
           } 
           
           if("eliminar".equals(request.getParameter("btn_eliminar"))){
                if(venta.eliminar()>0){
                response.sendRedirect("Ventas.jsp");
            }else{
                out.println("<h1>Error................</h1>");
                out.println("<a href='Ventas.jsp'>Regresar</a>");
            }
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
