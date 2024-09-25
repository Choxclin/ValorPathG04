package pe.edu.upc.valorpath_g04.servicesinterfaces;
import pe.edu.upc.valorpath_g04.entities.Role;
import java.util.List;

public interface IRoleService {
    public void insert(Role rol);

    public List<Role> list();

    public void delete(Integer idRol);

    public Role listarId(Integer idRol);
}
