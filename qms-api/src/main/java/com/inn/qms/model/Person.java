package com.inn.qms.model;

import com.inn.qms.anotations.PIDGenerater;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="person")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Lob
    @Column(name="profilePhoto",length = 1000)
    private byte[] profilePhoto;
    @Column
    private String firstName;
    @Column
    private  String middleName;
    @Column
    private String  lastName;
    @Column
    private String  title;
    @Column
    private String manager;
    @Column
    private String  gender;
    @Column
    private String salutation;
    @Column
    private String department;
    @Column
    private String  otherDepartment;
    @Column

    private String phoneNum;
    @Column

    private String mobileNum;
    @Column

    private String personEmail;
    @Column

    private String  managerEmail;
    @Column

    private String  status;
    @Column

    private String fax;
    @Column

    private String address;

    @Column
     private String postalCode;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String detailedAddress;

    @Column
    private String comments;

    @Column
    private String reference;

    @Column
    @PIDGenerater
    private String pid;

}
