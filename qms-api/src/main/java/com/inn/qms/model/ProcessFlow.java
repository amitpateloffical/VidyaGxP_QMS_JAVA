package com.inn.qms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Process_Flow")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessFlow extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long flowId;
    @Column
    private String flowName;
    @Column
    private String status;
}
