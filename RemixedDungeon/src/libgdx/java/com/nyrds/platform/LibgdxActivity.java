package com.nyrds.platform;

import android.content.Intent;

import com.nyrds.pixeldungeon.mobs.npc.SociologistNPC;
import com.watabou.noosa.InterstitialPoint;
import com.watabou.pixeldungeon.ui.ImageButton;

import java.io.InputStream;

// Port Android Activity so we can use it the same way on desktop!
public class LibgdxActivity {
    public final void runOnUiThread (Runnable action)
    {
        
    }

    public void openUrl(String visit_us_on_social_network, String s) {
    }

    public void doPermissionsRequest(InterstitialPoint sociologistNPC, String[] requiredPermissions) {
    }

    public void startActivity(Intent chooser) {
    }

    public InputStream openFileInput(String bonesFile) {
        return null;
    }

    public boolean deleteFile(String gameFile) {
        return false;
    }

    public String[] fileList() {
        return null;
    }
}
