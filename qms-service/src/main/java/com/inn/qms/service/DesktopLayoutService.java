package com.inn.qms.service;

import com.inn.qms.model.DesktopLayoutDetails.DesktopLayoutDetails;
import com.inn.qms.model.DesktopLayoutDetails.DesktopLayoutRequest;

import java.util.List;

public interface DesktopLayoutService {
    DesktopLayoutDetails saveLayout(DesktopLayoutRequest request);

    DesktopLayoutDetails updateLayout(Long id, DesktopLayoutRequest request);

    DesktopLayoutDetails findLayoutByName(String name);

    DesktopLayoutDetails getById(Long id);

    List<DesktopLayoutDetails> getAll();

    void deleteLayoutDetails(List<Long> ids);
}
