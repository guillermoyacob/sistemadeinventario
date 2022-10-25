package modeloDAO;

import config.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

public class ProductoDAO implements InterfazProductoDAO {

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto;";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setUnidades(rs.getInt("unidades"));
                producto.setCosto(rs.getDouble("costo"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setCategoria(rs.getString("categoria"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return productos;
    }

    @Override
    public Producto getId(int id) {
        String sql = "SELECT * FROM PERSONA WHERE id = ?;";
        Producto producto = new Producto();
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setUnidades(rs.getInt("unidades"));
                producto.setCosto(rs.getDouble("costo"));
                producto.setPrecio(rs.getDouble("Precio"));
                producto.setCategoria(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
        return producto;
    }

    @Override
    public int add(Producto producto) {
        int resultado = 0;
        String sql = "INSERT INTO producto(nombre, descripcion, unidades, costo, precio, categoria) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getUnidades());
            ps.setDouble(4, producto.getCosto());
            ps.setDouble(5, producto.getPrecio());
            ps.setString(6, producto.getCategoria());
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al agregar en la base de datos" + e);
        }
        return resultado;
    }

    @Override
    public int update(Producto producto) {
        int resultado = 0;
        String sql = "UPDATE producto SET nombre = ?, descripcion = ?, unidades = ?, costo = ?, precio = ?, categoria = ? WHERE id = ?;";
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al agregar en la base de datos" + e);
        }
        return resultado;
    }

    @Override
    public int delete(int id) {
        int resultado = 0;
        String sql = "DELETE FROM producto WHERE id = "+id;
        try {
            PreparedStatement ps = Conexion.Conectar().prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error durante el borrado" + e);
        }
        return resultado;
    }

}
