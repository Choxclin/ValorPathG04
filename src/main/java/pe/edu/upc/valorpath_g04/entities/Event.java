package pe.edu.upc.valorpath_g04.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvent;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 100, nullable = false)
    private String description;

    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;

    @Column(name = "registrationDate", nullable = false)
    private LocalDate registrationDate;


    @ManyToOne
    @JoinColumn(name = "idVeterano")
    private Users veterano;

    @ManyToOne
    @JoinColumn(name = "idPisicologo")
    private Users psicologo;

    @ManyToOne
    @JoinColumn(name = "idTipoEvento")
    private EventType eventType;

    public Event() {
    }

    public Event(Integer idEvent, String name, String description, LocalDate startDate, LocalDate endDate, LocalDate registrationDate, Users veterano, Users psicologo, EventType eventType) {
        this.idEvent = idEvent;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationDate = registrationDate;
        this.veterano = veterano;
        this.psicologo = psicologo;
        this.eventType = eventType;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Users getVeterano() {
        return veterano;
    }

    public void setVeterano(Users veterano) {
        this.veterano = veterano;
    }

    public Users getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Users psicologo) {
        this.psicologo = psicologo;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
