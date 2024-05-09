package com.example.practicando_lab6.Entity;

import jakarta.persistence.*;


@Entity
@Table(name ="ticket")
public class Ticket {
    @Id
    @Column(name="TicketID")
    private int ticketId;
    @JoinColumn(name="SiteID")
    @ManyToOne
    private Site site;
    @JoinColumn(name="TechnicianId")
    @ManyToOne
    private Technician techhnician;
    private String status;
    private String openedDate;
    private String closedDate;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Technician getTechhnician() {
        return techhnician;
    }

    public void setTechhnician(Technician techhnician) {
        this.techhnician = techhnician;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(String openedDate) {
        this.openedDate = openedDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }
}
