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
public class ProcessFlow extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(name = "flow_name")
	private String flowName;
	
	@Column(name = "status")
	private String status;
}
