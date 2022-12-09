/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author Guiye
 */
public class Validar extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nombre, contrasenia;
        UsuarioDAO DAO = new UsuarioDAO();

        nombre = request.getParameter("txtNombre");
        contrasenia = request.getParameter("txtContrasenia");
        
        Usuario usuario = DAO.getUsuario(nombre, contrasenia);

        if (Objects.equals(usuario.getNombre(), nombre)) {
            
            if (Objects.equals(usuario.getContrasenia(), contrasenia)) {

                System.out.println(usuario.getAdministrador().toString());
                
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogueado", usuario);
                session.setAttribute("idUsuario", usuario.getId());
                session.setAttribute("nombreUsuario", usuario.getNombre());
                request.getRequestDispatcher("listado.jsp").forward(request, response);
                
            } else {
                
                request.setAttribute("config", "alert alert-danger");
                request.setAttribute("mensaje", "La contraseña ingresada es incorrecta");
                request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                
            }

        } else {

            request.setAttribute("config", "alert alert-danger");
            request.setAttribute("mensaje", "No se ha encontrado el usuario");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
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
