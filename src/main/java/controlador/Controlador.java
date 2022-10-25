package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;
import modeloDAO.ProductoDAO;

public class Controlador extends HttpServlet {

    ProductoDAO dAO;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String accion = request.getParameter("accion");
        List<Producto> productos = new ArrayList<>();
        switch (accion) {
            case "listar":
                dAO = new ProductoDAO();
                productos = dAO.getProductos();
                request.setAttribute("Productos", productos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "nuevo":
                request.getRequestDispatcher("add.jsp").forward(request, response);
                break;
            case "Agregar":
                int resultado;
                String nombre = request.getParameter("txtNombre");
                String descripcion = request.getParameter("txtDescipcion");
                Integer unidades = Integer.valueOf(request.getParameter("txtUnidades"));
                Double costo = Double.valueOf(request.getParameter("txtCosto"));
                Double precio = Double.valueOf(request.getParameter("txtPrecio"));
                String categoria = request.getParameter("txtCategoria");
                Producto producto = new Producto(nombre, descripcion, unidades, costo, precio, categoria);
                resultado = dAO.add(producto);
                if (resultado != 0){
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "EL PRODUCTO SE HA AGREGADO CON ÉXITO");
                    request.getRequestDispatcher("Controlador?accion=listar").forward(request, response);
                }else{
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "NO SE HA PODIDO GUARDAR EL PRODUCTO");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
                
            default:
                throw new AssertionError();


//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NewServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
