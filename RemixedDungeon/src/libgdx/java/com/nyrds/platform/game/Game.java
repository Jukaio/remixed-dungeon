/*
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

package com.nyrds.platform.game;

import com.nyrds.pixeldungeon.support.Iap;
import com.nyrds.pixeldungeon.support.PlayGames;
import com.nyrds.platform.LibgdxActivity;
import com.watabou.pixeldungeon.scenes.TitleScene;

public class Game extends LibgdxActivity {
    public static String version = "";
    public static boolean softPaused;
    public static int versionCode;

    private static Game instance;
    public PlayGames playGames;
    public Iap iap;
    
    // Actual size of the screen
    private static int width;
    private static int height;

    private static volatile boolean paused = true;

    public Game() {

    }

    public Game(Class<TitleScene> titleSceneClass) {
    }

    public static String getVar(int id) {
        throw new RuntimeException("Stub!");
    }
    public static String[] getVars(int id) {
        throw new RuntimeException("Stub!");
    }

    public static void toast(final String text, final Object... args) {
        throw new RuntimeException("Stub!");
    }
    public synchronized static Game instance() {
        return instance;
    }
    public static int width() {
        return width;
    }

    private static void width(int width) {
        Game.width = width;
    }

    public static int height() {
        return height;
    }

    private static void height(int height) {
        Game.height = height;
    }

    public static boolean isPaused() {
        return paused;
    }

    public static void shutdown() {
    }

    public static boolean smallResScreen() {
        return false;
    }

    public static void vibrate(int i) {
    }

    public static void syncAdsState() {
    }

    public void doRestart() {
    }
}
