package pe.edu.upc.valorpath_g04.servicesinterfaces;
import pe.edu.upc.valorpath_g04.entities.Resource;

import java.time.LocalDate;
import java.util.List;

public interface IResourceService {
    public List<Resource> list();
    public void insert(Resource resour);
    List<String[]> Rmenosutilizado();
    List<String[]> tiporecursomasutilizad(LocalDate fechaInicio, LocalDate fechaFin);
}
