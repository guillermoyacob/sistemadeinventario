/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloDAO;

import java.util.List;
import modelo.Auditoria;

/**
 *
 * @author Guiye
 */
public interface InterfazAuditoriaDAO {
    
    public List<Auditoria> getRegistros();
    
    public void agregarRegistro(Auditoria auditoria);
}
