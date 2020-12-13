package com.github.nntk.elfinder;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "logos")
@Data
public class LogosProperties {
    private Map<String, Map<String, String>> filePath;
}
