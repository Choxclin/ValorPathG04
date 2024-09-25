package pe.edu.upc.valorpath_g04.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.valorpath_g04.entities.Forum;
import pe.edu.upc.valorpath_g04.repositories.IForumRepository;
import pe.edu.upc.valorpath_g04.servicesinterfaces.IForumService;

import java.time.LocalDate;
import java.util.List;


@Service

public class ForumServiceImplement implements IForumService {

    @Autowired
    private IForumRepository fR;

    @Override
    public void insert(Forum forum) {
        fR.save(forum);
    }

    @Override
    public void update(Forum forum) {
        fR.save(forum);
    }

    @Override
    public void delete(int id) {
        fR.deleteById(id);
    }

    @Override
    public List<Forum> list() {

        return fR.findAll();
    }

    @Override
    public Forum listId(int id) {
        return fR.findById(id).orElse(new Forum());
    }

    @Override
    public List<String[]> CantidadDeForosQueTieneUnPsicologo() {
        return fR.QuantityForumsByPsychologist();
    }

    @Override
    public List<String[]> ForosMasActivosEnunMes() {
        return fR.MostActiveForumsInTheLastMonth();
    }


}

