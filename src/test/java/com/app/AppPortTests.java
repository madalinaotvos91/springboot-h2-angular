package com.app;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;

public class AppPortTests {
    //Application default port
    private final int APP_PORT = 8080;

    // h2 in memory database port
    private final int DB_PORT = 9092;

    @Test
    public void isLocalHostAppDefaultPortFree() {
        Assert.assertFalse(isLocalPortInUse(APP_PORT));
    }

    @Test
    public void isH2InMemoryDatabaseDefaultPortFree() {
        Assert.assertFalse(isLocalPortInUse(DB_PORT));
    }

    /**
     * Function that checks if server socket can be instantiated on given port.
     * */
    private boolean isLocalPortInUse(int port) {
        try {
            new ServerSocket(port).close();
            return false;
        } catch (IOException e) {
            return true;
        }
    }


}