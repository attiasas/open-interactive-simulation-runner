package org.attias.open.interactive.simulation.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import org.attias.open.interactive.simulation.core.backend.engine.AppConfiguration;
import org.attias.open.interactive.simulation.core.backend.engine.InteractiveSimulationEngine;
import org.attias.open.interactive.simulation.core.backend.utils.ProjectUtils;

import java.io.IOException;
import java.io.InputStream;

public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        try {
            initialize(new InteractiveSimulationEngine(getConfigurations(config)), config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AppConfiguration getConfigurations(AndroidApplicationConfiguration config) throws IOException {
        try (InputStream in = getAssets().open(ProjectUtils.getProjectConfigurationsAssetsPath())) {
            AppConfiguration appConfiguration = AppConfiguration.getRunnerConfigurations(in);

            appConfiguration.setType(AppConfiguration.AppType.Android);

            return appConfiguration;
        }
    }

}
