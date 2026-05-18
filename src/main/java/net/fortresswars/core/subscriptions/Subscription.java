package net.fortresswars.core.subscriptions;

import org.bukkit.ChatColor;

import java.time.Duration;
import java.util.Date;
import java.util.UUID;

public class Subscription {

    private final UUID uuid;
    private final SubscriptionType subscriptionType;
    private final Date endDate;
    private final int totalDays;

    public Subscription(UUID uuid, SubscriptionType subscriptionType, int totalDays, Date endDate) {
        this.uuid = uuid;
        this.subscriptionType = subscriptionType;
        this.totalDays = totalDays;
        this.endDate = endDate;
    }

    public UUID getUUID() {
        return uuid;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public Duration getTimeLeft() {
        if (!isActive()) {
            return Duration.ofMillis(0);
        }
        final Date now = new Date();
        return Duration.ofMillis(endDate.getTime() - now.getTime());
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getPrefix() {
        final String shortName = subscriptionType.getName();
        final ChatColor color = subscriptionType.getColor();
        return color + "[" + shortName + "]";
    }

    public boolean isActive() {
        final Date now = new Date();
        return endDate.after(now);
    }
}
