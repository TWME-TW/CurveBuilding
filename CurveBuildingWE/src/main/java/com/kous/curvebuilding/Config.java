package com.kous.curvebuilding;

import org.bukkit.Color;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Color.fromRGB;

/**
 * config.ymlのデータを読み込む。
 */
public final class Config{
    public int fineness;
    public int maxSetLength;
    public boolean tCenter;

    public Color posColor;
    public Color startColor;
    public Color endColor;
    public Color fColor;
    public Color bColor;

    public int posDensity;
    public int lineDensity;
    public int lineMaxLength;

    public String messageFilePath;

    private final CurveBuilding plugin;

    public Config(@NotNull CurveBuilding plugin) {
        this.plugin = plugin;

        plugin.saveDefaultConfig();
        road();

        if (fineness <= 0 || maxSetLength <= 0 || posDensity <= 0 || lineDensity <= 0 || lineMaxLength <= 0) {
            plugin.reloadConfig();
            plugin.getLogger().info("Fill config.yml has been reloaded.");
            road();
        }
    }

    @SuppressWarnings("ConstantConditions")
    private void road() {
        fineness = (int) plugin.getConfig().get("curve.fineness");
        maxSetLength = (int) plugin.getConfig().get("curve.max-set-length");
        tCenter = (boolean) plugin.getConfig().get("curve.thicken-center");

        posColor = fromRGB((int) plugin.getConfig().get("particles.pos.color.pos"));
        startColor = fromRGB((int) plugin.getConfig().get("particles.pos.color.start_pos"));
        endColor = fromRGB((int) plugin.getConfig().get("particles.pos.color.end_pos"));
        fColor = fromRGB((int) plugin.getConfig().get("particles.pos.color.f"));
        bColor = fromRGB((int) plugin.getConfig().get("particles.pos.color.b"));

        posDensity = (int) plugin.getConfig().get("particles.pos.density");
        lineDensity = (int) plugin.getConfig().get("particles.line.density");
        lineMaxLength = (int) plugin.getConfig().get("particles.line.max-length");

        messageFilePath = (String) plugin.getConfig().get("message-file");
    }
}