package com.inn.qms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="Authentication_Source")
public class AuthenticationSource extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    private String name;
    private String type;
    private String serverUrl;
    private String rootSuffix;
    private String searchFilter;
    private String LdapUserName;
    private String LdapPassword;
    @Column(name="status", columnDefinition = "varchar(255) default 'Active'")
    private String status;
}
