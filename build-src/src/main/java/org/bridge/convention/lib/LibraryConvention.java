package org.bridge.convention.lib;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class LibraryConvention implements Plugin<Project> {
    @Override
    public void apply(Project target) {
        target.getPluginManager().apply("java");
        target.getPluginManager().apply("org.bridge.convention.spring");
        target.getPluginManager().apply("org.bridge.convention.test");

        target.getTasks().named("bootJar", task -> task.setEnabled(false));
    }
}
