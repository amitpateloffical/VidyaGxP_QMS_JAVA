package com.inn.qms.dao;

import com.inn.qms.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiteRepository extends JpaRepository<Site,Long> {
}
