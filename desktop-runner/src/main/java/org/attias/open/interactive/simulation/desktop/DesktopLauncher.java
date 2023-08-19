package org.attias.open.interactive.simulation.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.attias.open.interactive.simulation.core.backend.engine.AppConfiguration;
import org.attias.open.interactive.simulation.core.backend.engine.InteractiveSimulationEngine;

import java.io.IOException;

public class DesktopLauncher {
    public static void main (String[] arg) throws IOException {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new InteractiveSimulationEngine(getConfigurations(config)), config);
    }

    public static AppConfiguration getConfigurations(LwjglApplicationConfiguration config) throws IOException {
        AppConfiguration appConfiguration = AppConfiguration.getFromEnvironment();

        appConfiguration.setType(AppConfiguration.AppType.Desktop);
        config.title = appConfiguration.getProjectConfiguration().name;

        return appConfiguration;
    }
}
