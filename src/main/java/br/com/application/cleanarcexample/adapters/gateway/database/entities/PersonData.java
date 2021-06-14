package br.com.application.cleanarcexample.adapters.gateway.database.entities;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "person")
public class PersonData {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "age")
    private int age;

}
