package net.fortresswars.core.effects;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public enum StatusEffectType {
    SLIME_ARMOR(MiniMessage.miniMessage().deserialize("<color:#00FF6E>⬤</color>")),
    ROOTING(MiniMessage.miniMessage().deserialize("<color:#FF9100>⸙</color>")),
    FROZEN(MiniMessage.miniMessage().deserialize("<color:#00F5FF>❄</color>")),
    BLOOD_BOND(MiniMessage.miniMessage().deserialize("<color:#FF0000>\uD83C\uDF22</color>")),
    KILLSTREAK_INCREASE(null),
    SNOW_TRAIL_SUPPORT(MiniMessage.miniMessage().deserialize("<color:#00FF64>❄</color>")),
    WEAVING(MiniMessage.miniMessage().deserialize("<color:#FFFFFF>\uD83D\uDD78</color>"));

    private final Component icon;

    StatusEffectType(Component icon) {
        this.icon = icon;
    }

    public Component getIcon() {
        return icon;
    }
}
