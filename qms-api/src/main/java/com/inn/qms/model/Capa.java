package com.inn.qms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.File;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Capa")
public class Capa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Record Number")
    private String record_Number;
    @Column(name = "Site/Location Code")
    private String site_Location_Code;
    @Column(name = "Initiator")
    private String initiator;
    @Column(name = "Date of Initiation")
    private Date date_of_Initiation;
    @Column(name = "Assigned To")
    private String assigned_To;
    @Column(name = "Due Date")
    private Date due_Date;
    @Column(name = "Initiator Group")
    private String initiator_Group;
    @Column(name = "Initiator Group Code")
    private String initiator_Group_Code;

    //this field is mendatory
//    @Column(name = "Short Description")
    @NotEmpty(message = "Description is mandatory")
    private String short_Description;
    @Column(name = "Severity Level")
    private String severity_Level;
    @Column(name = "Initiated_Through")
    private String initiated_Through;
    @Column(name = "Others")
    private String others;
    @Column(name = "Capa_Repeat")
    private String repeat;
    @Column(name = "Repeat_Nature")
    private String rrepeat_Nature;
    @Column(name = "Problem Description")
    private String problem_Description;
    @Column(name = "CAPA Team")
    private String capaTeam;
    @Column(name = "Reference Records")
    private String reference_Records;
    @Column(name = "Initial Observation")
    private String initial_Observation;
    @Column(name = "Interim Containnment")
    private String interim_Containnment;
    @Column(name = "Containment Comments")
    private String containment_Comments;
    @Column(name = "CAPA Attachment")
    private String capa_Attachment;
    @Column(name = "CAPA QA Comments")
    private String capa_QA_Comments;

    //Equipment/Material Info
    @Column(name = "Material Details")
    private String material_Details;
    //Material Details with rows and columns
    @Column(name = "Equipment/Instruments Details")
    private String equipment_Instruments_Details;
    //Equipment/Instruments Details with rows and columns
    @Column(name = "Details")
    private String details;

    @Column(name = "Equipment CAPA QA Comments")
    private String c_QA_Comments;

//Other type CAPA Details for Details & Capa QA Comments

    //CAPA Details
    @Column(name = "CAPA Type")
    private String capa_Type;
    @Column(name = "Corrective Action")
    private String corrective_Action;
    @Column(name = "Preventive Action")
    private String preventive_Action;
    @Column(name = "Supervisor Review Comments")
    private String supervisor_Review_Comments;

    //Capa Closure
    @Column(name = "QA Review & Closure")
    private String qa_Review_and_Closure;
    @Column(name = "Closure Attachment")
    private String closure_Attachment;
    //Extension Justification
    @Column(name = "Due Date Extension Justification")
    private String due_Date_Extension_Justification;

//ActivityLog.....

}
