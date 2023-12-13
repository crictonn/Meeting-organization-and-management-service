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

    @Column(name ="name", length = 30, nullable = false)
    private String name;

    @Column(name ="description", length = 300)
    private String description;

    @Column(name ="date")
    private Date date;

    @ManyToMany
    @JoinTable(
            name = "users_participations",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "meeting_id")
    )
    private Set<User> participants;

}
