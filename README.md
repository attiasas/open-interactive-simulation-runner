<div align="center">

# open-interactive-simulation-runner

[![Test](https://github.com/attiasas/open-interactive-simulation-runner/actions/workflows/test.yml/badge.svg)](https://github.com/attiasas/open-interactive-simulation-runner/actions/workflows/test.yml?branch=master)

</div>

---

## Table of Contents
- [📚 Overview](#-overview)
- [📦 Installation](#-installation)
- [🏗️ Usage](#-usage)
- [🐞 Reporting Issues](#-reporting-issues)
- [🤝 Contributions](#-contributions)

---
## 📚 Overview

This project is built on the [LibGdx](https://libgdx.com/) framework and provides the capability to run OIS projects on various platforms. It achieves this by utilizing the [OIS core](https://github.com/attiasas/open-interactive-simulation-core) library, which defines an API for seamless execution of different OIS projects along this project.

To streamline deployment, we've developed the [OIS deployer](https://github.com/attiasas/open-interactive-simulation-deployer) Gradle plugin. This plugin leverages the platform's features to facilitate the deployment of OIS projects on specific platforms based on your requirements by using this project.


### 🚥 Requirements
* Java version `15` or a more recent release.
* Gradle version `7` or a newer version.

---
## 📦 Installation

The project is not available in Maven central, required to be used locally
Install locally OIS core library:

1. Clone the [core library](https://github.com/attiasas/open-interactive-simulation-core)
    ```bash
     git clone https://github.com/attiasas/open-interactive-simulation-core.git
   ```
2. Navigate to the cloned directory and publish the library to maven local
   ```bash
    ./gradlew publishToMavenLocal
   ```

---
## 🏗️ Usage

Each sub module coresponse to a different project that is used to run/deploy to a specific platform.
Use the task configured by the project.

### Running
When running the gradle commands configure the following environment variables:

| Environment Variable        | Description                                             |
|-----------------------------|---------------------------------------------------------|
| OIS_ENV_PROJECT_CONFIG_PATH | path to the `simulation.ois` project configuration file |
| OIS_ENV_PROJECT_JAR_PATH    | path to the OIS project Jar location                    |
| OIS_ENV_PROJECT_ASSETS_DIR  | (Optional) path to your project resource directory      |

### Distributing
When running the gradle commands configure the following environment variables:

| Environment Variable     | Description                              |
|--------------------------|------------------------------------------|
| OIS_ENV_PROJECT_NAME     | the base name of the generated artifacts |
| OIS_ENV_PROJECT_JAR_PATH | path to the OIS project Jar location     |

The resources needs to be placed at the `assets` directory at the root project
Create a directory named `.ois` and place the `simulation.ois` file inside.
Icons may be placed inside an `icons` directory.

## 🐞 Reporting Issues

We highly recommend running Gradle with the ```-d```
option to get useful and readable debug information if something goes wrong with your build.

Please help us improve the library
by [reporting any issues](https://github.com/attiasas/open-interactive-simulation-runner/issues/new/choose) you encounter.

## 🤝 Contributions

We welcome pull requests from the community. To help us improve this project, please read
our [Contribution](./CONTRIBUTING.md) guide.