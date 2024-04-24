package com.inn.qms.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "EntityDetails")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntityDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sales_person")
    private String salesPerson ;

    @Column(name = "account_manager")
    private String accountManager;

    @Column(name = "territory")
    private String territory;

    @Column(name = "External_Id")
    private String externalId;

    @Column(name = "is_Customer")
    private String isCustomer ;

    @Column(name = "Customer_Id")
    private String customerId;

    @Column(name = "is_Active")
    private String isActive;

    @Column(name = "Date_Customer")
    private Date dateCustomer;

    @Column(name = "Date_Expired")
    private Date dateExpired;

    @Column(name = "Persons_In_Entity")
    private String personsInEntity;

    @Column(name = "Business_Description")
    private String businessDescription;
}
