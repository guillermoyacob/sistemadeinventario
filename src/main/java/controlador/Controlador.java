package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Auditoria;
import modelo.Producto;
import modelo.Usuario;
import modeloDAO.AuditoriaDAO;
import modeloDAO.ProductoDAO;

public class Controlador extends HttpServlet {

    ProductoDAO DaoProducto;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
        
        Auditoria registro;
        String accion = request.getParameter("accion");
        List<Producto> productos = new ArrayList<>();
        HttpSession session = request.getSession();
            
        switch (accion) {
            case "listar":
                DaoProducto = new ProductoDAO();
                productos = DaoProducto.getProductos();
                request.setAttribute("Productos", productos);
                request.getRequestDispatcher("listado.jsp").forward(request, response);
                break;
            case "nuevo":
                request.getRequestDispatcher("add.jsp").forward(request, response);
                break;
            case "Agregar":
                int resultado;
                String nombre = request.getParameter("txtNombre");
                String descripcion = request.getParameter("txtDescripcion");
                Integer unidades = Integer.valueOf(request.getParameter("txtUnidades"));
                Double costo = Double.valueOf(request.getParameter("txtCosto"));
                Double precio = Double.valueOf(request.getParameter("txtPrecio"));
                String categoria = request.getParameter("txtCategoria");
                Producto producto = new Producto(nombre, descripcion, unidades, costo, precio, categoria);
                resultado = DaoProducto.add(producto);
                if (resultado != 0){
                    String nombreUsuario = (String) session.getAttribute("nombreUsuario");
                    Integer idUsuario = (Integer) session.getAttribute("idUsuario");
                    registro = new Auditoria(nombre, descripcion, unidades, costo, precio, categoria, idUsuario, nombreUsuario, "Agregó");
                    AuditoriaDAO DaoAuditoria = new AuditoriaDAO();
                    DaoAuditoria.agregarRegistro(registro);
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "EL PRODUCTO SE HA AGREGADO CON ÉXITO");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }else{
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "NO SE HA PODIDO GUARDAR EL PRODUCTO");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
            case "Editar":
                int id = Integer.valueOf(request.getParameter("id"));
                Producto p = DaoProducto.getId(id);
                request.setAttribute("producto", p);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "Actualizar":
                String nombre1 = request.getParameter("txtNombre");
                String descripcion1 = request.getParameter("txtDescripcion");
                Integer unidades1 = Integer.valueOf(request.getParameter("txtUnidades"));
                Double costo1 = Double.valueOf(request.getParameter("txtCosto"));
                Double precio1 = Double.valueOf(request.getParameter("txtPrecio"));
                String categoria1 = request.getParameter("txtCategoria");
                int idProducto = Integer.valueOf(request.getParameter("txtId"));
                Producto prod = new Producto (idProducto, nombre1, descripcion1, unidades1, costo1, precio1, categoria1);
                int respuesta = DaoProducto.update(prod);
                if (respuesta != 0){
                    request.setAttribute("config", "alert alert-success");
                    request.setAttribute("mensaje", "EL PRODUCTO SE HA ACTUALIZADO CON ÉXITO");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }else{
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "NO SE HA PODIDO ACTUALIZAR EL PRODUCTO");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
            case "Delete":
                int idPerson = Integer.valueOf(request.getParameter("id"));
                int res = DaoProducto.delete(idPerson);
                if (res != 0){
                    request.setAttribute("config", "alert alert-warning");
                    request.setAttribute("mensaje", "EL PRODUCTO SE HA ELIMINADO CON ÉXITO");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }else{
                    request.setAttribute("config", "alert alert-danger");
                    request.setAttribute("mensaje", "NO SE HA PODIDO ELIMINAR EL PRODUCTO");
                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                }
                break;
            default:
                throw new AssertionError();

        }
        

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
