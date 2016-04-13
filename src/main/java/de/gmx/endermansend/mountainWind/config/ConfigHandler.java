package de.gmx.endermansend.mountainWind.config;


import de.gmx.endermansend.mountainWind.main.MountainWind;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.logging.Logger;

public class ConfigHandler {

    public GetValuesFromConfig get;

    private MountainWind main;
    private Logger logger;
    private FileConfiguration config;

    public ConfigHandler(MountainWind main) {

        get = new GetValuesFromConfig(this);

        this.main = main;
        this.logger = this.main.getLogger();

        if (!loadConfig())
            createDefaultConfig();

    }

    /**
     * Tries to convert the value found under the given path to an integer. If it cannot be found in config.yml, an
     * error message will be printed and a default one will be used.
     *
     * @param path Path to the variable
     * @return Value found in config.yml (default value if none is found)
     */
    protected int getIntFromConfig(String path) {
        if (!config.isSet(path) || !config.isInt(path))
            noValueFound(path);
        return config.getInt(path);
    }

    /**
     * Tries to convert the values found under the given path to a ConfigurationSection. If it cannot be found in
     * config.yml, an error message will be printed and a default one is used.
     *
     * @param path Path to the variable
     * @return ConfigurationSection found in config.yml (default value if none is found)
     */
    protected ConfigurationSection getConfigurationSectionFromConfig(String path) {
        if (!config.isSet(path) || !config.isConfigurationSection(path))
            noValueFound(path);
        return config.getConfigurationSection(path);
    }

    /**
     * Saves the default configuration file and stores it's content to config.
     */
    private void createDefaultConfig() {

        logger.info("Creating default config");
        main.saveDefaultConfig();

        config = main.getConfig();
        logger.info("Config loaded");

    }

    /**
     * Tries to load the config.yml from disk. This method returns false if no matching file was found. In this case a
     * default config should be loaded.
     *
     * @return True if the config could be loaded
     */
    private boolean loadConfig() {

        logger.info("Loading config");

        if (this.configExists()) {
            config = main.getConfig();
            logger.info("Config loaded");
            return true;
        }

        return false;

    }

    /**
     * Prints a warning to the log if a value was not found under the specified path.
     *
     * @param path Path to the missing value
     */
    protected void noValueFound(String path) {
        logger.warning("Value is missing or of wrong type: " + path);
        logger.warning("Using default value");
        logger.warning("Delete config.yml to get a default one");
    }

    /**
     * Checks if a config.yml exists in the plugin folder.
     *
     * @return True if a config.yml was found
     */
    private boolean configExists() {

        File[] files = main.getDataFolder().listFiles();
        if (files == null)
            return false;

        for (File file : files) {
            if (file.getName().equals("config.yml")) {
                return true;
            }
        }

        return false;

    }

}
