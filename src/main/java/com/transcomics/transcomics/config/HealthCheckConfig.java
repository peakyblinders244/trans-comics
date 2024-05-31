package com.transcomics.transcomics.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Le-Hong-Quan
 * Date: 25/05/2024
 * Time: 15:22
 */
@Component("myHealthCheck")
public class HealthCheckConfig implements HealthIndicator {
    @Override
    public Health health() {
        String computerName = null;
        try {
            computerName = InetAddress.getLocalHost().getHostName();
            return Health.up().withDetail("computerName", computerName).build();
        } catch (Exception e) {
            return Health.down().withDetail("Error", e.getMessage()).build();
        }

    }


}
