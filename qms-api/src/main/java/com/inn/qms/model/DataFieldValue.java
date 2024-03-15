package com.inn.qms.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Data_Field_Values")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DataFieldValue extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long valueId;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private DataField dataField;

    @Column
    private Long entityId; // Assuming this is a reference to info_id or attachment_id

    @Column
    private String value;

    // Add other relevant fields, getters, and setters

}