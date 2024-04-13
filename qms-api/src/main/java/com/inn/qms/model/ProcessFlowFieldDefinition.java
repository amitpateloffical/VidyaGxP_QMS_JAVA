package com.inn.qms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "processflowfield_definition")
@ToString(includeFieldNames = true)

public class ProcessFlowFieldDefinition {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "flow_id", referencedColumnName = "id")
	    private ProcessFlowDefinition flowDefinition;

	    @Column(name = "field_name")
	    private String fieldName;

	    @Column(name = "data_type")
	    private String dataType;
	    
}

