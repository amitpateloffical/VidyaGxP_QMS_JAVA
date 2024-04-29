package com.inn.qms.service;

import com.inn.qms.model.ActionItem;

import java.util.List;
import java.util.Optional;

public interface IActionItemService {

    public ActionItem createActionItem(ActionItem actionItem);


    ActionItem updateActionItem(ActionItem updatedActionItem);

    public ActionItem findById(Long id);

    public List<ActionItem> findAll();

}
