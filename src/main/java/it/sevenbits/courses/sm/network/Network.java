package it.sevenbits.courses.sm.network;

import java.util.concurrent.ConcurrentLinkedDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Network implements INetwork {

    private static final Logger LOGGER = LoggerFactory.getLogger(Network.class);
    private final int maxSize;
    private ConcurrentLinkedDeque<NetworkPackage> packages = new ConcurrentLinkedDeque<NetworkPackage>();

    public Network(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean hasPackage() {
        return packages.size() > 0;
    }

    @Override
    public NetworkPackage getPackage() {
        LOGGER.debug("Get package");
        return packages.removeFirst();
    }

    @Override
    public void addPackage(String message, String type) {
        if (packages.size() < maxSize) {
            //LOGGER.debug("Add package");
            packages.addLast(new NetworkPackage(type, message));
        }
        //LOGGER.error("Not memory to add package");
    }
}
