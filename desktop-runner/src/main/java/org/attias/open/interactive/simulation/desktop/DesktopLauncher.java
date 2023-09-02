package org.attias.open.interactive.simulation.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.attias.open.interactive.simulation.core.backend.engine.AppConfiguration;
import org.attias.open.interactive.simulation.core.backend.engine.InteractiveSimulationEngine;
import org.attias.open.interactive.simulation.core.backend.utils.ProjectUtils;

import java.io.IOException;
import java.io.InputStream;

public class DesktopLauncher {
    public static void main (String[] arg) throws IOException {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new InteractiveSimulationEngine(getConfigurations(config)), config);
    }

    public static AppConfiguration getConfigurations(LwjglApplicationConfiguration config) throws IOException {
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(ProjectUtils.getProjectConfigurationsAssetsPath())) {
            AppConfiguration appConfiguration = AppConfiguration.getRunnerConfigurations(in);

            appConfiguration.setType(AppConfiguration.AppType.Desktop);
            config.title = appConfiguration.getProjectConfiguration().title;

            addIcons(config);

            return appConfiguration;
        }
    }

    public static void addIcons(LwjglApplicationConfiguration config) {
        if (System.getenv(AppConfiguration.ENV_PROJECT_ASSETS_DIR) != null) {
            // Running not in publish mode
            return;
        }
        ProjectUtils.IconExtension extension = ProjectUtils.IconExtension.PNG;
        if (ProjectUtils.DesktopOS.Mac.equals(ProjectUtils.getCurrentOS())) {
            extension = ProjectUtils.IconExtension.ICNS;
        }
        for (int size : ProjectUtils.DESKTOP_ICON_SIZES) {
            try {
                config.addIcon(ProjectUtils.getDesktopIconResourcePath(extension, size), Files.FileType.Internal);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
