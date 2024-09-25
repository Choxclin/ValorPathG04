package pe.edu.upc.valorpath_g04.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.valorpath_g04.dtos.ForumDTO;
import pe.edu.upc.valorpath_g04.dtos.MostActiveForumInatMonthDTO;
import pe.edu.upc.valorpath_g04.dtos.QuantityForumByPsychologistDTO;
import pe.edu.upc.valorpath_g04.entities.Forum;
import pe.edu.upc.valorpath_g04.servicesinterfaces.IForumService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/foros")
public class ForumController {
    @Autowired
    private IForumService fS;

    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('VETERANO','PSICOLOGO')")
    public void registrar(@RequestBody ForumDTO forumDTO) {
        ModelMapper m = new ModelMapper();
        Forum forum = m.map(forumDTO, Forum.class);
        fS.insert(forum);
    }

    @PutMapping("/actualizar")
    public void modificar(@RequestBody ForumDTO forumDTO) {
        ModelMapper m = new ModelMapper();
        Forum forum = m.map(forumDTO, Forum.class);
        fS.update(forum);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('PSICOLOGO')")
    public List<ForumDTO> listar() {
        return fS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, ForumDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        fS.delete(id);
    }

    @GetMapping("/listar/{id}")
    @PreAuthorize("hasAnyAuthority('VETERANO','PSICOLOGO')")
    public ForumDTO listarPorId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        ForumDTO forumDTO = m.map(fS.listId(id), ForumDTO.class);
        return forumDTO;
    }
    @GetMapping("/quantity(ForumsByPsy)")
    @PreAuthorize("hasAnyAuthority('VETERANO','PSICOLOGO')")
    public List<QuantityForumByPsychologistDTO> quantityforumsbypsychologist() {
        List<String[]> list= fS.CantidadDeForosQueTieneUnPsicologo();
        List<QuantityForumByPsychologistDTO>listdto=new ArrayList<>();
        for(String[] columna:list){
            QuantityForumByPsychologistDTO dto=new QuantityForumByPsychologistDTO();
            dto.setPsychologistname(columna[0]);
            dto.setPsychologistlastName(columna[1]);
            dto.setForumCount(Integer.parseInt(columna[2]));
            listdto.add(dto);
        }
        return listdto;
    }
    @GetMapping("/quantity(MostActiveForum)")
    @PreAuthorize("hasAnyAuthority('VETERANO','PSICOLOGO')")
    public List<MostActiveForumInatMonthDTO> mostactiveforummonth() {
        List<String[]> list= fS.ForosMasActivosEnunMes();
        List<MostActiveForumInatMonthDTO>listdto=new ArrayList<>();
        for(String[] columna:list){
            MostActiveForumInatMonthDTO dto=new MostActiveForumInatMonthDTO();
            dto.setForumId(Integer.parseInt(columna[0]));
            dto.setForumTitle(columna[1]);
            dto.setNumPosts(Integer.parseInt(columna[2]));
            listdto.add(dto);
        }
        return listdto;
    }
}
