package com.nyrds.platform.audio;


import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.NonNull;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Pool;

public enum Sample {
    INSTANCE;

    public int play(String id) {
        return play(id, 1, 1, 1);
    }

    public int play(String id, float volume) {
        return play(id, volume, volume, 1);
    }

    public int play(String id, float leftVolume, float rightVolume, float rate) {
        if(!enabled) {
            return -1;
        }
        Integer sampleId = ids.get(id);
        if (sampleId!=null) {
            //return pool.play(sampleId, leftVolume, rightVolume, 0, 0, rate);
        } else {
            playOnComplete = id;
            load(id);
            return -1;
        }

        throw new RuntimeException("Stub!");
    }

    public static final int MAX_STREAMS = 8;
    String playOnComplete;

    protected Pool<Sound> pool = new Pool<Sound>(MAX_STREAMS);
    //protected SoundPool pool =
    //        new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);



    @NonNull
    protected Set<String> missingAssets = new HashSet<>();

    @NotNull
    protected Map<String, Integer> ids =
            new HashMap<>();

    private boolean enabled = true;

    public void reset() {

    }

    public void pause() {

    }

    public void resume() {

    }

    private void load(String asset) {
        //Sound sample = Gdx.audio.newSound(Gdx.files.internal(asset)); // load sound. GDX loading etc
        if (!ids.containsKey(asset) && !missingAssets.contains(asset)) {
            try {
                String assetFile = ModdingMode.getSoundById("sound/" + asset);
                int streamID;

                File file = ModdingMode.getFile(assetFile);
                if (file != null && file.exists()) {
                    streamID = pool.load(file.getAbsolutePath(), 1);
                } else {
                    streamID = fromAsset(manager, assetFile);
                }

                ids.put(asset, streamID);

            } catch (IOException e) {
                missingAssets.add(asset);
                playOnComplete = null;
                EventCollector.logException(e,asset);
            }
        }
    }



    public void enable(boolean value) {
        enabled = value;
    }
}
