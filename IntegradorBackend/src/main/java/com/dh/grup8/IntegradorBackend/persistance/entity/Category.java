package com.dh.grup8.IntegradorBackend.persistance.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
/**me crea un contructor con todo menos con el id por que el se crea autoincremental en la bd*/
@AllArgsConstructor
/**me crea un contructor vacio*/
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String urlImage;

}
