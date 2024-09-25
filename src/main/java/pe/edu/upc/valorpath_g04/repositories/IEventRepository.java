package pe.edu.upc.valorpath_g04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.valorpath_g04.entities.Event;

import java.util.List;

@Repository
public interface IEventRepository extends JpaRepository<Event, Integer> {
    @Query(value = "SELECT u.id AS userId, \n" +
            "COUNT(u.Id) as userxEvent \n" +
            "From users u \n" +
            "JOIN evento e \n" +
            "ON u.id = e.id_veterano \n" +
            "GROUP BY u.id",nativeQuery = true)
    public List<String[]> quatityVeteransinEvent();


    @Query(value = "SELECT e.id_event AS eventId, \n" +
            "COUNT(e.id_event) AS qpsicoevent \n" +
            "FROM evento e \n" +
            "JOIN users u \n" +
            "ON e.id_psicologo = u.id \n" +
            "GROUP BY e.id_event",nativeQuery = true)
    public List<String[]> quatityPsicoEvent();

}
