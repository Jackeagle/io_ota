package org.io.ota.changelog;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ChangeConfig {
    public static final String KEY_CHANGES_TO_FETCH = "changes_to_fetch";

    public int changesToFetch;

    private static ChangeConfig sInstance;

    private ChangeConfig(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        changesToFetch = Integer.parseInt(prefs.getString(KEY_CHANGES_TO_FETCH, "75"));
    }

    public static ChangeConfig get(Context context) {
        if (sInstance == null) {
            sInstance = new ChangeConfig(context);
        }
        return sInstance;
    }
}
