package org.bridge.convention.application;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.bundling.Jar;
import org.springframework.boot.gradle.tasks.bundling.BootJar;

public class ApplicationConvention implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        target.getPluginManager().apply("java");
        target.getPluginManager().apply("org.bridge.convention.spring");
        target.getPluginManager().apply("org.bridge.convention.test");
        target.getPluginManager().apply("org.bridge.convention.spring-web");

        target.getTasks().withType(Jar.class).configureEach(task -> task.setEnabled(false));
        target.getTasks().withType(BootJar.class).configureEach(task -> task.setEnabled(true));
    }
}
