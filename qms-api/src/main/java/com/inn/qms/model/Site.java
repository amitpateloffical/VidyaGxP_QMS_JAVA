package com.inn.qms.model;



import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Site")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Site extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

	
	}




