package com.nyrds.platform.app;

import com.nyrds.util.Util;

public class RemixedDungeonApp {
    static public boolean checkOwnSignature() {
        //Log.i("Game", Utils.format("own signature %s", Util.getSignature(this)));
        if(Util.isDebug()) {
            return true;
        }

        return false; // changed from android platform
    }
}
