/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.alumnos;
import modelo.alumnosDAO;
/**
 *
 * @author Carlos
 */
@WebServlet(name = "AlumnosControler", urlPatterns = {"/AlumnosControler"})
public class AlumnosControler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        /*    out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AlumnosControler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlumnosControler at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } */

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
        
        alumnosDAO alumnosDao = new alumnosDAO();  
        String accion;
        RequestDispatcher dispactcher = null;
        accion = request.getParameter("accion");
        if(accion == null || accion.isEmpty()){
            dispactcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
        }else if(accion.equals("modificar")){
            dispactcher = request.getRequestDispatcher("Vistas/modificarAlumno.jsp");
            
        }else if(accion.equals("actualizar")){
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            
            alumnos alumno = new alumnos(id,nombre,apellido,email);
            alumnosDao.actualizarAlumno(alumno);
            
            dispactcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
        }else if(accion.equals("eliminar")){
        
            int id = Integer.parseInt(request.getParameter("id"));
            alumnosDao.eliminarAlumno(id);
            
            dispactcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
        }else if(accion.equals("nuevo")){
            dispactcher = request.getRequestDispatcher("Vistas/crearAlumno.jsp");
        }else if(accion.equals("insert")){
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            
            alumnos alumno = new alumnos(0,nombre,apellido,email);
            alumnosDao.insertarAlumnos(alumno);
            
            dispactcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
        }else{
            dispactcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
        }
        dispactcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
