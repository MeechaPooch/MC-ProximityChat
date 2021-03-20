package com.mooo.pooch.proximitychatstandaside;

import javax.sound.sampled.AudioFormat;
import java.util.function.Supplier;

public class Consts {

    public static int maxHearingRange = 20;

    public static int SERVER_VOIP_PORT = 9720;
    public static int CLIENT_VOIP_PORT = 9720;

    public static int bufferByteLength = 10000;
    public static AudioFormat defaultAudioFormat = new Supplier<AudioFormat>() {
        @Override
        public AudioFormat get() {
            float sampleRate = 16000F;
            int sampleSizeInBits = 16;
            int channels = 1;
            boolean signed = true;
            boolean bigEndian = false;
            return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
        }
    }.get();
}