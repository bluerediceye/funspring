package com.tutorial.security;

import com.tutorial.repository.PermissionJpaRepository;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;

/**
 * Created on 28/01/15
 *
 * @author Ming Li
 */
public class CustomPermissionEvaluator implements PermissionEvaluator {

    private PermissionJpaRepository permissionJpaRepository;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {

        String username = ((User) authentication.getPrincipal()).getUsername();
        String target = targetDomainObject.getClass().getName();
        int count = permissionJpaRepository.exists(username, target, permission.toString());

        return count == 1;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }

    public void setPermissionJpaRepository(PermissionJpaRepository permissionJpaRepository) {
        this.permissionJpaRepository = permissionJpaRepository;
    }
}
