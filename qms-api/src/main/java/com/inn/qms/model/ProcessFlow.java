package com.inn.qms.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Process_Flow")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProcessFlow extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "status")
	private String status;
}
