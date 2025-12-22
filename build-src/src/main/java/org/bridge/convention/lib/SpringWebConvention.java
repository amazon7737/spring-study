package org.bridge.convention.lib;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class SpringWebConvention implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        target.getPluginManager().apply("org.bridge.convention.spring");

        target.getDependencies().add("implementation", "org.springframework.boot:spring-boot-starter-web");
    }
}
