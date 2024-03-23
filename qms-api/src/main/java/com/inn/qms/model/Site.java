package com.inn.qms.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Site")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Site extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "siteid")
    private Long siteId;

    @Column
    private String siteName;


}

