
package modeloDAO;

import java.util.List;
import modelo.Producto;

public interface InterfazProductoDAO {
    public List<Producto> getProductos();
    public Producto getId(int id);
    public int add(Producto producto);
    public int update(Producto producto);
    public int delete(int id);
}
