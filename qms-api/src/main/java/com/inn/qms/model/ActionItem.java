package com.inn.qms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

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


   /* private String fileAttachments;*/
   @ElementCollection
   @CollectionTable(name = "action_item_attachments", joinColumns = @JoinColumn(name = "action_item_id"))
   @MapKeyColumn(name = "file_name")
   @Lob
   @Column(name = "file_data", length = 1000000)
   private Map<String, byte[]> fileAttachments; // Map to store file name along with file data
    // Constructor, getters, and setters remain unchanged


    //////Post Completion///////
    private String actionTaken;
    private Date actualStartDate;
    private Date actualEndDate;
    private String comments;

    ///////////Action Approval///////////
    private String qaReviewComments;

    /////////Extension Justification////////
    private String dueDateExtensionJustification;

   /* @Column (name = "status", columnDefinition = "varchar(255) default 'open' " )
    private String status;*/

   @Enumerated(EnumType.STRING)
   private Status status = Status.OPEN;

}
