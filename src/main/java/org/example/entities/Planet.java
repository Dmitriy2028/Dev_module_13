package org.example.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Data
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @NotNull
    @Pattern(regexp = "^[A-Z0-9]+$")
    private String id;

    @Column(name = "name")
    @NotNull
    @Size(min = 1, max = 500)
    private String name;

    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.REMOVE, fetch = EAGER, orphanRemoval = true)
    private List<Ticket> fromPlanet = new ArrayList<>();

    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.REMOVE, fetch = EAGER, orphanRemoval = true)
    private List<Ticket> toPlanet = new ArrayList<>();

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
