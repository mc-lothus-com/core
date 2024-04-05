package com.lothus.core.controller.server;

import com.lothus.core.servers.ServerInfo;
import com.lothus.core.servers.type.ServerType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServerController {

    private HashMap<String, ServerInfo> s = new HashMap<>();

    public void load(ServerInfo serverInfo) {
        s.put(serverInfo.getName(), serverInfo);
    }

    public void unload(String name) {
        s.remove(name);
    }

    public void update(ServerInfo serverInfo) {
        if (s.containsKey(serverInfo.getName())) {
            s.replace(serverInfo.getName(), serverInfo);
        } else {
            load(serverInfo);
        }
    }

    public ServerInfo get(String name) {
        return s.get(name);
    }

    public List<ServerInfo> get(ServerType type) {
        List<ServerInfo> servers = new ArrayList<>();
        for (ServerInfo serverInfo : s.values()) {
            if (serverInfo.getType() == type) {
                servers.add(serverInfo);
            }
        }
        return servers;
    }

    public List<ServerInfo> getAll() {
        List<ServerInfo> servers = new ArrayList<>();
        for (ServerInfo serverInfo : s.values()) {
            servers.add(serverInfo);
        }
        return servers;
    }
}
