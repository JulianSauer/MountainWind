package de.gmx.endermansend.mountainWind.config;

import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class GetValuesFromConfig {

    private ConfigHandler config;

    GetValuesFromConfig(ConfigHandler config) {
        this.config = config;
    }

    /**
     * # Defines at which level the sound effect is going to start
     *
     * @return Block at which the wind should start
     */
    public int blockLevel() {
        return config.getIntFromConfig("blockLevel");
    }

    /**
     * Returns a time interval in seconds until the wind effect is played again.
     *
     * @return Time between the played effects
     */
    public int playInterval() {
        return config.getIntFromConfig("playInterval");
    }

    public int roofHeight() {
        return config.getIntFromConfig("roofHeight");
    }

    /**
     * Returns the game modes and if they are allowed to hear the wind effect.
     *
     * @return A list containing game modes with true if the mode is supposed to hear the effect
     */
    public Map<String, Boolean> allowedGameModes() {
        ConfigurationSection section = config.getConfigurationSectionFromConfig("allowedGamemodes");

        if (section == null) {
            config.noValueFound("allowedGamemodes");
            return new HashMap<String, Boolean>();
        }
        return (Map) section.getValues(false);
    }

    /**
     * Returns world names and if players are allowed to hear wind in that world.
     *
     * @return A list containing world names with true if players are supposed to hear the effect here
     */
    public Map<String, Boolean> allowedWorlds() {
        ConfigurationSection section = config.getConfigurationSectionFromConfig("allowedWorlds");

        if (section == null) {
            config.noValueFound("allowedWorlds");
            return new HashMap<String, Boolean>();
        }
        return (Map) section.getValues(false);
    }

}
