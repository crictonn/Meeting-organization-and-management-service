package com.example.meetingsmanagmentandorganization.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "meetings")
@Data
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "participant_id")
    private Long participant_id;

    @Column(name ="name", length = 30, nullable = false)
    private String name;

    @Column(name = "owner")
    private String owner;

    @Column(name ="description", length = 300)
    private String description;

    @Column(name ="date")
    private Date date;

    @ManyToMany(mappedBy = "participations")
    private Set<User> participants;

}
