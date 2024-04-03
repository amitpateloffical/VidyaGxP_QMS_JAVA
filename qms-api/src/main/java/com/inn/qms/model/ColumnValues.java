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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "column_id", referencedColumnName = "id")
    private ColumnNames columnName;

    @Column(name = "value")
    private String value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_recorded")
    private Date dateRecorded;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProcessFlowDefinition getFlowDefinition() {
		return flowDefinition;
	}

	public void setFlowDefinition(ProcessFlowDefinition flowDefinition) {
		this.flowDefinition = flowDefinition;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ColumnNames getColumnName() {
		return columnName;
	}

	public void setColumnName(ColumnNames columnName) {
		this.columnName = columnName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDateRecorded() {
		return dateRecorded;
	}

	public void setDateRecorded(Date dateRecorded) {
		this.dateRecorded = dateRecorded;
	}
    
    

    
}
