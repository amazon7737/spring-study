package org.bridge.convention.lib;

import org.bridge.convention.version.Plugins;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import java.util.Map;

public class SpringConvention implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        target.getPluginManager().apply("java");
        target.getPluginManager().apply(Plugins.SPRING_BOOT);
        target.getPluginManager().apply(Plugins.SPRING_DEPENDENCY_MANAGEMENT);

        target.getDependencies().add("implementation", "org.springframework.boot:spring-boot-starter");
        target.getDependencies().add("implementation", "org.springframework.boot:spring-boot-starter-log4j2");
        target.getDependencies().add("implementation", "org.springframework.boot:spring-boot-configuration-processor");

        target.getConfigurations().all(configuration -> {
            configuration.exclude(Map.of("group", "org.springframework.boot", "module", "spring-boot-starter-logging"));
        });
    }
}
