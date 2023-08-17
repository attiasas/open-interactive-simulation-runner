package org.attias.open.interactive.simulation.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.attias.open.interactive.simulation.core.engine.AppConfiguration;
import org.attias.open.interactive.simulation.core.engine.InteractiveSimulationEngine;

public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new InteractiveSimulationEngine(getConfigurations(config)), config);
    }

    public static AppConfiguration getConfigurations(LwjglApplicationConfiguration config) {
        AppConfiguration appConfiguration = AppConfiguration.getFromEnvironment();

        config.title = appConfiguration.getTitle();

        return appConfiguration;
    }
}
