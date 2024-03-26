package com.inn.qms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Process_Additional_Info")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessAdditionalInfo extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "processflowid_fk")
    private ProcessFlow processFlow;

    @ManyToOne
    @JoinColumn(name="siteid_fk")
    private Site site;


    // Add other mandatory fields related to additional information, getters, and setters

}