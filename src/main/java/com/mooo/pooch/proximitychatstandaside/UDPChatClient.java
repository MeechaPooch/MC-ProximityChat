package com.mooo.pooch.proximitychatstandaside;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UDPChatClient {

    //TOPOLOGY:

    // ----NORMAL LOOP:----
    //         UDP:
    // CLIENTS send plain audio to server without headers
    // HEADERS:
    // none
    // BODY:
    // audio buffer of length Consts.bufferByteLength
    //
    // SERVER sends many UDP packets for each person in range of client
    // HEADERS:
    // 1 byte on end of player ID
    // BODY:
    // plain audio buffer
    //
    //     TCP:
    // SERVER sends packet containing positions of all players by ID
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //




    byte[] buffer = new byte[Consts.bufferByteLength];
    TargetDataLine microphone;
    AudioInputStream audioInputStream;
    SourceDataLine audioOutputDevice;


    public static void main(String... args) throws LineUnavailableException {
        UDPChatClient client = new UDPChatClient();
        client.initAudio();
        while(true) {
            client.fillBuffer();
            InputStream audioInput = new ByteArrayInputStream(client.buffer);
            //getFrameSize returns the byte lenght of a single sample of audio (also given channel count)
            //length argument is the number of samples in the audio stream
            client.audioInputStream = new AudioInputStream(audioInput,Consts.defaultAudioFormat,client.buffer.length/Consts.defaultAudioFormat.getFrameSize());
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, Consts.defaultAudioFormat);
            client.audioOutputDevice = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
            client.audioOutputDevice.open(Consts.defaultAudioFormat);
            client.audioOutputDevice.start();
//            new Thread(()->client.playAudio(client.audioInputStream)).start();
            client.playAudio(client.audioInputStream);
        }
    }

    // Copied from page 167 of https://docs.google.com/viewerng/viewer?url=https://www.programmer-books.com/wp-content/uploads/2018/06/Learning-Network-Programming-with-Java-2015.pdf
    private void playAudio(AudioInputStream audio) {
        byte[] buffer = new byte[Consts.bufferByteLength];
        try {
            int count;
            while ((count = audio.read(
                    buffer, 0, buffer.length)) != -1) {
                if (count > 0) {
                    audioOutputDevice.write(buffer, 0, count);
                }
            }
        } catch (Exception e) {
// Handle exceptions
        }
    }


    public int fillBuffer() {
        return microphone.read(buffer,0,buffer.length);
    }


    //Copied from page 154 of https://docs.google.com/viewerng/viewer?url=https://www.programmer-books.com/wp-content/uploads/2018/06/Learning-Network-Programming-with-Java-2015.pdf
    private void initAudio() {
        try {
            DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, Consts.defaultAudioFormat);
            microphone = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
            microphone.open(Consts.defaultAudioFormat);
            microphone.start();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }

}
