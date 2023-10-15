package de.segoy.springframework.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column
    private String address;

    @Column
    private String telephone;

    @Column
    private String city;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();


    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String telephone, String city, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.telephone = telephone;
        this.city = city;
        this.pets = pets;
    }
}
