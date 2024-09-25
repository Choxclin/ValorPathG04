package pe.edu.upc.valorpath_g04.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.valorpath_g04.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
