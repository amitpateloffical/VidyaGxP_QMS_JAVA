package com.inn.qms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Action_Item")
public class ActionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String recordNumber;
    private String divisionCode;
    private String initiator;
    private Date dateOfInitiation;
    private String assignedTo;
    private Date dueDate;


    @NotEmpty(message = "Short description is required")

    private String shortDescription;
    private String actionItemRelatedRecords;
    private String hodPersons;
    private String description;
    private String responsibleDepartment;
    private String fileAttachments;

    //////Post Completion///////
    private String actionTaken;
    private Date actualStartDate;
    private Date actualEndDate;
    private String comments;

    ///////////Action Approval///////////
    private String qaReviewComments;

    /////////Extension Justification////////
    private String dueDateExtensionJustification;

    @Enumerated(EnumType.STRING)
    private Status status = Status.OPEN;

}
