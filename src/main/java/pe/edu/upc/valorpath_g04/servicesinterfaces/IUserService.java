package pe.edu.upc.valorpath_g04.servicesinterfaces;
import pe.edu.upc.valorpath_g04.entities.Users;

import java.util.List;

public interface IUserService {
    public void insert(Users usuario);

    public List<Users> list();

    public void delete(Integer idUsuario);

    public Users listarId(Integer idUsuario);
}
