package com.lothus.core.servers;

import com.lothus.core.servers.configuration.ServerConfiguration;
import com.lothus.core.servers.status.ServerStatus;
import com.lothus.core.servers.type.ProxyType;
import com.lothus.core.servers.type.ServerType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ServerInfo {

    private int id;

    private String name;

    private ServerType type;
    private ProxyType proxyType;
    private ServerStatus status;

    private ServerConfiguration configuration;

    private String address;
    private int port;

    private int players;

    public ServerInfo(int id, String name, ServerType type, int port) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.proxyType = (type == ServerType.PROXY ? ProxyType.PREMIUM : ProxyType.UNDEFINED);
        this.address = "172.18.0.1";
        this.port = port;

        this.configuration = new ServerConfiguration();

        status = ServerStatus.ONLINE;

        players = 0;
    }
}
