package net.fortresswars;

import org.bukkit.plugin.java.JavaPlugin;

public class Logger {
    private LogLevel logLevel = LogLevel.WARN;

    public enum LogLevel {
        SILLY(4), // highest
        DEBUG(3), // high
        INFO(2), // low
        WARN(1); // lowest, default

        private final int value;

        LogLevel(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    private final JavaPlugin plugin;

    public Logger(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void silly(String msg) {
        if (logLevel.value() < LogLevel.SILLY.value()) return;
        plugin.getLogger().info("[SILLY]: " + msg);
    }

    public void debug(String msg) {
        if (logLevel.value() < LogLevel.DEBUG.value()) return;
        plugin.getLogger().info("[DEBUG]: " + msg);
    }

    public void debug(Exception e) {
        if (logLevel.value() < LogLevel.DEBUG.value()) return;
        plugin.getLogger().warning("[DEBUG]: " + e.getMessage());
        e.printStackTrace();
    }

    public void info(String msg) {
        if (logLevel.value() < LogLevel.INFO.value()) return;
        plugin.getLogger().info("[INFO]: " + msg);
    }

    public void warn(String msg, Exception e) {
        warn(msg);
        warn(e);
    }

    public void warn(String msg) {
        if (logLevel.value() < LogLevel.WARN.value()) return;
        plugin.getLogger().warning("[WARN]: " + msg);
    }

    public void warn(Exception e) {
        if (logLevel.value() < LogLevel.WARN.value()) return;
        plugin.getLogger().warning("[WARN]: " + e.getMessage());
        e.printStackTrace();
    }

    public void error(String msg, Exception e) {
        error(msg);
        error(e);
    }

    public void error(String msg) {
        plugin.getLogger().severe("[ERROR]: " + msg);
    }

    public void error(Exception e) {
        if (logLevel.value() < LogLevel.WARN.value()) return;
        plugin.getLogger().warning("[ERROR]: " + e.getMessage());
        e.printStackTrace();
    }

    public String setLogLevel(String s) {
        switch (s.toLowerCase()) {
            case "silly" -> {
                logLevel = LogLevel.SILLY;
                return "silly";
            }
            case "debug" -> {
                logLevel = LogLevel.DEBUG;
                return "debug";
            }
            case "info" -> {
                logLevel = LogLevel.INFO;
                return "info";
            }
            default -> {
                logLevel = LogLevel.WARN;
                return "warn";
            }
        }
    }

    public void disable() {
        logLevel = LogLevel.WARN;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }
}
