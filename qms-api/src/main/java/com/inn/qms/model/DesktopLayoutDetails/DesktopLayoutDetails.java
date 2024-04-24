package com.inn.qms.model.DesktopLayoutDetails;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "desktop_lay_out_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesktopLayoutDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "layout_data_fields", columnDefinition = "TEXT")
    private String layoutDataFields; // Store as JSON string
}
