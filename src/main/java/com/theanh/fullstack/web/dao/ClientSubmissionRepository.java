package com.theanh.fullstack.web.dao;

import com.theanh.fullstack.web.entity.ClientSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientSubmissionRepository extends JpaRepository<ClientSubmission,Long> {

}
