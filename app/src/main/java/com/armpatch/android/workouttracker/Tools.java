package com.armpatch.android.workouttracker;

import android.content.Context;

import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatter;

public class Tools {

    public static String getRelativeDate(Context activityContext, int days) {
        LocalDate today = LocalDate.now().plusDays(days);

        if (days == 0)
            return activityContext.getString(R.string.today);
        if (days == 1)
            return activityContext.getString(R.string.tomorrow);
        if (days == -1)
            return activityContext.getString(R.string.yesterday);

        return getFormattedDate(today);
    }

    public static String getFormattedDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("EEEE, MMMM d"));
    }


}
