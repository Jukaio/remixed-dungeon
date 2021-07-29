package com.nyrds.platform.storage;

import java.io.IOException;
import java.io.InputStream;

public class Assets {
    public static boolean isAssetExits(String resName) {
        return false;
    }

    public static String[] listAssets(String path) {
        return null;
    }

    public static InputStream getStream(String resName) throws IOException {
        throw new IOException("No IO implemented");
    }
}
