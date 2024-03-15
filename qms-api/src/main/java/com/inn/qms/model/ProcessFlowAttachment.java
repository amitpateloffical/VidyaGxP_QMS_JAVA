package com.inn.qms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Process_Flow_Attachment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessFlowAttachment extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;

    @ManyToOne
    @JoinColumn(name = "flow_id")
    private ProcessFlow processFlow;

    @Column
    private String path;
}
