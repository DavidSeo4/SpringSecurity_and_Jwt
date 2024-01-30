package com.basic.SecurityJwt.SecurityJwt.model;

import java.util.Arrays;
import java.util.List;

public enum Role {

    STUDENT(Arrays.asList(Permission.READ_STUDENT_MARKS)),

    TEACHER(Arrays.asList(Permission.READ_ALL_MARKS));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
