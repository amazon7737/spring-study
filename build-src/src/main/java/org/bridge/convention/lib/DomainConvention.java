package org.bridge.convention.lib;

import org.bridge.convention.version.Plugins;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class DomainConvention implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        target.getPluginManager().apply("java");
        target.getPluginManager().apply("org.bridge.convention.test");
        target.getPluginManager().apply(Plugins.SPRING_BOOT);
        target.getPluginManager().apply(Plugins.SPRING_DEPENDENCY_MANAGEMENT);

        target.getDependencies().add("implementation", "com.fasterxml.jackson.core:jackson-databind:" + Plugins.Version.JACKSON);
        target.getDependencies().add("implementation", "org.springframework:spring-context"); // @Service, @Component ...
        target.getDependencies().add("implementation", "org.springframework:spring-tx"); // @Transactional

        // Disable bootJar task
        target.getTasks().named("bootJar", task -> task.setEnabled(false));
    }
}
