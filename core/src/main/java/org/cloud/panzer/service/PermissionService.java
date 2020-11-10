package org.cloud.panzer.service;

import org.cloud.panzer.domain.Permission;

public interface PermissionService {

    void save(Permission permission);

    void update(Permission permission);

    void delete(Long id);
}
