package com.mapei.javatest.test_stream;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/2
 */
public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
        prefs.put("Location", "Oz");
        prefs.put("Footwear", "Ruby Slippers");
        prefs.putInt("Companions", 4);
        prefs.putBoolean("Are there witches?", true);
        int usageCount = prefs.getInt("UsageCount", 0);
        usageCount++;
        prefs.putInt("UsageCount", usageCount);
        for (String key : prefs.keys()){
            System.out.println(key + ":" + prefs.get(key, null));
        }
        System.out.println("How many companions does Doroty have? " + prefs.getInt("Companions", 0));

    }
}
