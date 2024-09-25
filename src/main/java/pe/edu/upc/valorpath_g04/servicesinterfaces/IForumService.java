package pe.edu.upc.valorpath_g04.servicesinterfaces;


import pe.edu.upc.valorpath_g04.entities.Forum;

import java.time.LocalDate;
import java.util.List;

public interface IForumService {
    public void insert (Forum forum);
    public void update (Forum forum);
    public void delete (int id);
    public List<Forum> list();
    public Forum listId (int id);
    public List<String[]> CantidadDeForosQueTieneUnPsicologo();

    public List<String[]> ForosMasActivosEnunMes();
}
