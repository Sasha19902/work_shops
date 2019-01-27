package it.sevenbits.courses.sm.manager.cmd;


import it.sevenbits.courses.sm.network.NetworkPackage;

public interface Updatable {
    void update(StringBuilder stringBuilder, NetworkPackage networkPackage);
}
