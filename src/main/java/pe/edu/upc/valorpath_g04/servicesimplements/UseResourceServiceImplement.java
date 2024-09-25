package pe.edu.upc.valorpath_g04.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.valorpath_g04.entities.UseResources;
import pe.edu.upc.valorpath_g04.repositories.IUseResourceRepository;
import pe.edu.upc.valorpath_g04.servicesinterfaces.IUseResourcesService;

import java.util.List;

@Service
public class UseResourceServiceImplement implements IUseResourcesService {

    @Autowired
    private IUseResourceRepository iur;
    @Override
    public List<UseResources> listaruso() {
        return iur.findAll();
    }

    @Override
    public void insert(UseResources useResources) {
        iur.save(useResources);
    }
}
