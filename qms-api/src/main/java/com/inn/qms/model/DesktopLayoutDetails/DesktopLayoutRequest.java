package com.inn.qms.model.DesktopLayoutDetails;

import lombok.Data;

import java.util.List;

@Data
public class DesktopLayoutRequest {
    private String name;
    private List<LayoutDataField> layoutDataFields;
    public void setFieldToSave(String fieldToSave) {
    }
}


