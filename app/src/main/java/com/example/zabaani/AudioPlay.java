package com.example.zabaani;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;

public class AudioPlay {

    public static MediaPlayer mediaPlayer;
    public static boolean isplayingaudio = false;

    public static void playAudio(Context c, int id) {
        mediaPlayer = mediaPlayer.create(c, id);

        if (!mediaPlayer.isPlaying()) {
            isplayingaudio = true;
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }
    }

    public static void stopAudio() {
        isplayingaudio = false;
        mediaPlayer.stop();
    }

}
