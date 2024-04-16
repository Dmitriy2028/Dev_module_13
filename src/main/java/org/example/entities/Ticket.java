package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false, updatable = false)
    private Timestamp createdAt;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", client=" + client.getId() +
                ", fromPlanet=" + fromPlanet +
                ", toPlanet=" + toPlanet +
                '}';
    }
}
