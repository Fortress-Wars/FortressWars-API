package net.fortresswars.core;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public record Subscription(
        Date endDate,
        int totalDays
) {

    public static String FW_PLUS = "FW_PLUS";

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

    public boolean isActive() {
        final Date now = new Date();
        return endDate.after(now);
    }

    /**
     * Create a new subscription class
     * @param days days until the subscription expires
     * @ a new subscription class
     */
    public static Subscription createSubscription(int days) {
        final Date currentDate = new Date();
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        final Date endDate = calendar.getTime();
        return new Subscription(endDate, days);
    }

    /**
     * Returns a new subscript with the total days updated and end date adjusted
     * @param subscription subscript to update
     * @param days days to add
     * @return a new subscription class
     */
    public static Subscription addDays(Subscription subscription, int days) {
        final int totalDays = subscription.getTotalDays();
        final Date endDate = subscription.getEndDate();

        final Date currentDate = new Date();
        final Calendar calendar = Calendar.getInstance();

        if (endDate.after(currentDate)) {
            calendar.setTime(endDate);
        } else {
            calendar.setTime(currentDate);
        }
        calendar.add(Calendar.DAY_OF_MONTH, days);

        // New Data
        final Date newEndDate = calendar.getTime();
        final int newTotalDays = totalDays + days;
        return new Subscription(newEndDate, newTotalDays);
    }
}
