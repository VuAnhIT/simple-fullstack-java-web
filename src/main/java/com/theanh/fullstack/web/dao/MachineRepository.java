package com.theanh.fullstack.web.dao;

import com.theanh.fullstack.web.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {

    @Query("SELECT m FROM Machine m where m.quantity>0 order by m.publishedDate")
    List<Machine> findAllRemainedByOrderByPublishedDateAsc();

    List<Machine> findAllByOrderByPublishedDateAsc();
}
