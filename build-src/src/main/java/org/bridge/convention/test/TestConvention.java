package org.bridge.convention.test;

import org.bridge.convention.version.Plugins;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.testing.Test;
import java.util.Map;

public class TestConvention implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        target.getPluginManager().apply("java");
        target.getPluginManager().apply(Plugins.SPRING_BOOT);
        target.getPluginManager().apply(Plugins.SPRING_DEPENDENCY_MANAGEMENT);

        target.getDependencies().add("testImplementation", "org.springframework.boot:spring-boot-starter-test");
        target.getDependencies().add("testImplementation", "org.springframework.boot:spring-boot-starter-log4j2");


        target.getConfigurations().all(configuration -> {
            configuration.exclude(Map.of("group", "org.springframework.boot", "module", "spring-boot-starter-logging"));
        });

        target.getTasks().withType(Test.class).configureEach(Test::useJUnitPlatform);
    }
}
