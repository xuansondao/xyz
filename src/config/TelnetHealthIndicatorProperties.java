package config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "management.health.telnet", ignoreUnknownFields = false)
@Configuration
public class TelnetHealthIndicatorProperties {

    private int connectTimeout = 100;

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }


}
