package com.inn.qms.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "column_values")
public class ColumnValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flow_id", referencedColumnName = "id")
    private ProcessFlowDefinition flowDefinition;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;

    @ManyToOne
    @JoinColumn(name = "column_id", referencedColumnName = "id")
    private ColumnNames columnName;

    @Column(name = "value")
    private String value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_recorded")
    private Date dateRecorded;

    
}
