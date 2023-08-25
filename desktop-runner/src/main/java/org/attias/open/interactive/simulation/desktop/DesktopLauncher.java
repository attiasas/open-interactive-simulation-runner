package org.attias.open.interactive.simulation.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.attias.open.interactive.simulation.core.backend.engine.AppConfiguration;
import org.attias.open.interactive.simulation.core.backend.engine.InteractiveSimulationEngine;
import org.attias.open.interactive.simulation.core.backend.utils.ProjectUtils;

import java.io.IOException;

public class DesktopLauncher {
    public static void main (String[] arg) throws IOException {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new InteractiveSimulationEngine(getConfigurations(config)), config);
    }

    public static AppConfiguration getConfigurations(LwjglApplicationConfiguration config) throws IOException {
        AppConfiguration appConfiguration = AppConfiguration.getRunnerConfigurations();

        appConfiguration.setType(AppConfiguration.AppType.Desktop);
        config.title = appConfiguration.getProjectConfiguration().title;

        addIcons(config);

        return appConfiguration;
    }

    public static void addIcons(LwjglApplicationConfiguration config) {
        if (System.getenv("OIS_ENV_PROJECT_ASSETS_DIR") != null) {
            // Running not in publish mode
            return;
        }
        String extension = ".png";
        String osName = System.getenv("os.name");
        if (osName != null && osName.contains("darwin")) {
            extension = ".icns";
        }
        int[] sizes = new int[]{128, 32};
        System.out.println("Loading icons");
        for (int size : sizes) {
            try {
                System.out.println("loading icon" + extension + ": " + size);
                config.addIcon(ProjectUtils.OIS_DIRECTORY_NAME + "/icons/icon" + size + extension, Files.FileType.Internal);
            } catch (Exception e) {
                System.out.println("found exception");
            }
        }
    }
}
