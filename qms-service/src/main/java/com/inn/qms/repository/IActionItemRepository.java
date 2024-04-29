package com.inn.qms.repository;

import com.inn.qms.model.ActionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IActionItemRepository extends JpaRepository<ActionItem, Long> {

}
