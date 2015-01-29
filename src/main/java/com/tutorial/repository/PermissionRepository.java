package com.tutorial.repository;

import com.tutorial.domain.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created on 28/01/15
 *
 * @author Ming Li
 */
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Query("select permission from Permission permission where permission.user.username = :username and permission.permission = :permission and permission.target = :target")
    public List<Permission> find(@Param("username") String username, @Param("target") String target, @Param("permission") String permission);

    @Query("select count(*) from Permission permission where permission.user.username = :username and permission.permission = :permission and permission.target = :target")
    public int exists(@Param("username") String username, @Param("target") String target, @Param("permission") String permission);
}
