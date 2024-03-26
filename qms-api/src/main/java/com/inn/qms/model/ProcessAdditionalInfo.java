package com.inn.qms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Process_Additional_Info")
@AllArgsConstructor
@NoArgsConstructor
@Data
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