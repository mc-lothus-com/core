package com.lothus.core.player.group;

import com.lothus.core.player.group.perm.Permission;
import com.lothus.core.player.group.rank.Rank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class Group {

    private Rank rank;
    private Rank tag;

    private List<Permission> permissions;

    private long created;
    private long lastModified;

    private long expires;

    public void addPermission(String permission, long expires) {

        for (Permission perm : permissions) {
            if (perm.getPermission().equalsIgnoreCase(permission)) {
                perm.setExpires(expires);
                return;
            }
        }
        permissions.add(new Permission(permission, expires));
    }

    public boolean containsPermission(String permission) {
        for (Permission perm : permissions) {
            if (perm.getPermission().equalsIgnoreCase(permission)) {
                return true;
            }
        }
        return false;
    }
}
