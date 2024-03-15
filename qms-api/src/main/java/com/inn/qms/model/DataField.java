package com.inn.qms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Data_Field")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataField extends  BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long fieldId;

    @ManyToOne
    @JoinColumn(name = "flow_id")
    private ProcessFlow processFlow;

    @Column
    private String fieldName;

    @Column
    private String fieldType;

    // Add other relevant fields, getters, and setters

}