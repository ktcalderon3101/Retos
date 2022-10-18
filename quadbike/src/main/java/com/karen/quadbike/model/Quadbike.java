package com.karen.quadbike.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quadbike")
@Getter
@Setter
public class Quadbike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String brand;
    @Column(name = "years")
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("quadbikes")
    private Category category;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "quadbike")
    @JsonIgnoreProperties({ "quadbike", "client" })
    private List<Message> messages;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "quadbike")
    @JsonIgnoreProperties({ "quadbike", "messages" })
    public List<Reservation> reservations;
}
