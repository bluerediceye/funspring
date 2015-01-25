package com.tutorial.repository;

import com.tutorial.domain.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mli on 20/01/15.
 */
public interface GroupRepository extends JpaRepository<Group, Long> {
}
