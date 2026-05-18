package net.fortresswars.core.subscriptions;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class SubscriptionHelper {

    /**
     * Create a new subscription class
     * @param uuid uuid of player
     * @param subscriptionType type of subscription
     * @param days days until the subscription expires
     * @ a new subscription class
     */
    public static Subscription createSubscription(UUID uuid, SubscriptionType subscriptionType, int days) {
        final Date currentDate = new Date();
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        final Date endDate = calendar.getTime();
        return new Subscription(uuid, subscriptionType, days, endDate);
    }

    /**
     * Returns a new subscript with the total days updated and end date adjusted
     * @param subscription subscript to update
     * @param days days to add
     * @return a new subscription class
     */
    public static Subscription addDays(Subscription subscription, int days) {
        final UUID uuid = subscription.getUUID();
        final SubscriptionType subscriptionType = subscription.getSubscriptionType();
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
        return new Subscription(uuid, subscriptionType, newTotalDays, newEndDate);
    }

}
