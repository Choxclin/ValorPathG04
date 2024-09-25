package pe.edu.upc.valorpath_g04.dtos;

import jakarta.persistence.*;
import pe.edu.upc.valorpath_g04.entities.Post;
import pe.edu.upc.valorpath_g04.entities.Users;

import java.time.LocalDate;

public class ForumDTO {

    private Integer id;
    private String title;
    private String description;
    private LocalDate date;
    private Users psychologist;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Users getPsychologist() {
        return psychologist;
    }

    public void setPsychologist(Users psychologist) {
        this.psychologist = psychologist;
    }


}
