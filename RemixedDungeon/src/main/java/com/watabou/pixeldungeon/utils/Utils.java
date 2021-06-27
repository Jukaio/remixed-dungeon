/*
 * Pixel Dungeon
 * Copyright (C) 2012-2014  Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.watabou.pixeldungeon.utils;

import com.nyrds.pixeldungeon.ml.R;
import com.nyrds.platform.EventCollector;
import com.nyrds.platform.game.Game;
import com.nyrds.util.Util;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.SneakyThrows;

public class Utils {

    public static final String UNKNOWN = "unknown";
    public static final String EMPTY_STRING = "";
    public static final String[] EMPTY_STRING_ARRAY = new String[0];


    @NotNull
    private static final Class<?> strings = getR_Field("string");
    @NotNull
    private static final Class<?> stringArrays = getR_Field("array");

    @SneakyThrows
    static private Class<?> getR_Field(String field) {
        return Class.forName("com.nyrds.pixeldungeon.ml.R$" + field);
    }

    public static String capitalize(String str) {
        if(str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static String format(int StringFormatId, Object... args) {
        return String.format(Locale.ENGLISH, Game.getVar(StringFormatId), args);
    }

    public static String format(String format, Object... args) {
        return String.format(Locale.ENGLISH, format, args);
    }

    public static String indefinite(String noun) {
        //In a pt_BR language(and another), there is no specific rule.
        if (Game.getVar(R.string.Utils_IsIndefinte).equals("0")) {
            return noun;
        }

        if (noun.length() == 0) {
            return "a";
        } else {
            String VOWELS = "aoeiu";
            return (VOWELS.indexOf(Character.toLowerCase(noun.charAt(0))) != -1 ? "an " : "a ") + noun;
        }
    }

    @SneakyThrows
    public static String[] getClassParams(String className, String paramName, String[] defaultValues, boolean warnIfAbsent) {

        if (className.length() == 0) { // isEmpty() require api level 9
            return defaultValues;
        }

        try {
            return Game.getVars(stringArrays.getField(className + "_" + paramName).getInt(null));
        } catch (NoSuchFieldException e) {
            if (warnIfAbsent) {
                GLog.w("no definition for  %s_%s :(", className, paramName);
            }
        }

        return defaultValues;
    }

    public static String getClassParam(String className, String paramName, String defaultValue, boolean warnIfAbsent) {
        if (className==null || className.isEmpty()) {
            return defaultValue;
        }

        try {
            return Game.getVar(strings.getField(className + "_" + paramName).getInt(null));
        } catch (NoSuchFieldException e) {
            if (Util.isDebug() && warnIfAbsent) {
                GLog.w("no definition for  %s_%s :(", className, paramName);
            }
        } catch (Exception e) {
            EventCollector.logException(e);
        }

        return defaultValue;
    }

    public static int genderFromString(String sGender) {
        int gender = Utils.NEUTER;

        if (sGender.equals("masculine")) {
            gender = Utils.MASCULINE;
        }
        if (sGender.equals("feminine")) {
            gender = Utils.FEMININE;
        }
        return gender;
    }

    public static final int NEUTER = 0;
    public static final int MASCULINE = 1;
    public static final int FEMININE = 2;


    public static boolean canUseClassicFont(String localeCode) {
        return !(localeCode.startsWith("ko")
                || localeCode.startsWith("zh")
                || localeCode.startsWith("ja")
                || localeCode.startsWith("tr"));
    }

    @SafeVarargs
    public static<T> boolean isOneOf(T value, T... array ) {
        for (T item:array) {
            if(value.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public static int max(int a, int b, int c) {
        return Math.max(a,Math.max(b,c));
    }
    public static int min(int a, int b, int c) {
        return Math.min(a,Math.min(b,c));
    }


    public static float max(float a, float b, float c) {
        return Math.max(a,Math.max(b,c));
    }
    public static float min(float a, float b, float c) {
        return Math.min(a,Math.min(b,c));
    }

    public static boolean differentVersions(String v1, String v2) {
        try {
            Pattern p = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher m = p.matcher(v1);
            if (m.find()) {
                v1 = m.group();
            }


            m = p.matcher(v2);
            if (m.find()) {
                v2 = m.group();
            }

            return !v1.equals(v2);

        } catch (Exception e) {
            EventCollector.logException(e);
        }
        return false;
    }
}
