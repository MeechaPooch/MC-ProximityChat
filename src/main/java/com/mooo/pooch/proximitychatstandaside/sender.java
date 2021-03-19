//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//import javax.sound.sampled.AudioFormat;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.DataLine;
//import javax.sound.sampled.LineUnavailableException;
//import javax.sound.sampled.Mixer;
//import javax.sound.sampled.SourceDataLine;
//import javax.sound.sampled.TargetDataLine;
//
//public class sender {
//    ServerSocket MyService;
//    Socket clientSocket = null;
//    BufferedInputStream input;
//    TargetDataLine targetDataLine;
//
//    BufferedOutputStream out;
//    ByteArrayOutputStream byteArrayOutputStream;
//    AudioFormat audioFormat;
//
//    SourceDataLine sourceDataLine;
//    byte tempBuffer[] = new byte[10000];
//
//    sender() throws LineUnavailableException{
//        try {
//            audioFormat = getAudioFormat();
//            DataLine.Info dataLineInfo = new DataLine.Info( SourceDataLine.class,audioFormat);
//            sourceDataLine = (SourceDataLine)
//                    AudioSystem.getLine(dataLineInfo);
//            sourceDataLine.open(audioFormat);
//            sourceDataLine.start();
//            MyService = new ServerSocket(500);
//            clientSocket = MyService.accept();
//            captureAudio();
//            input = new BufferedInputStream(clientSocket.getInputStream());
//            out=new BufferedOutputStream(clientSocket.getOutputStream());
//
//            while(input.read(tempBuffer)!=-1){
//                sourceDataLine.write(tempBuffer,0,10000);
//            }
//        } catch (IOException e) {
//
//            e.printStackTrace();
//        }
//
//    }
//    private AudioFormat getAudioFormat(){
//        float sampleRate = 8000.0F;
//        int sampleSizeInBits = 16;
//        int channels = 1;
//        boolean signed = true;
//        boolean bigEndian = false;
//        return new AudioFormat(
//                sampleRate,
//                sampleSizeInBits,
//                channels,
//                signed,
//                bigEndian);
//    }
//    public static void main(String s[]) throws LineUnavailableException{
//        sender s2=new sender();
//    }
//
//
//    private void captureAudio() {
//        try {
//
//            Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
//            System.out.println("Available mixers:");
//            for (int cnt = 0; cnt < audioformat =" getAudioFormat();" datalineinfo =" new" mixer =" AudioSystem.getMixer(mixerInfo[3]);" targetdataline =" (TargetDataLine)" capturethread =" new" cnt =" targetDataLine.read(tempBuffer," stopcapture =" false;" out =" null;" in =" null;" sock =" null;" tx =" new" sock =" new" out =" new" in =" new" mixerinfo =" AudioSystem.getMixerInfo();" cnt =" 0;" audioformat =" getAudioFormat();" datalineinfo =" new" mixer =" AudioSystem.getMixer(mixerInfo[3]);" targetdataline =" (TargetDataLine)" capturethread =" new" datalineinfo1 =" new" sourcedataline =" (SourceDataLine)" playthread =" new" bytearrayoutputstream =" new" stopcapture =" false;" cnt =" targetDataLine.read(tempBuffer,"> 0) {
//
//                byteArrayOutputStream.write(tempBuffer, 0, cnt);
//
//            }
//        }
//        byteArrayOutputStream.close();
//    } catch (Exception e) {
//        System.out.println(e);
//        System.exit(0);
//    }
//}
//}
//
//private AudioFormat getAudioFormat() {
//        float sampleRate = 8000.0F;
//
//        int sampleSizeInBits = 16;
//
//        int channels = 1;
//
//        boolean signed = true;
//
//        boolean bigEndian = false;
//
//        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed,
//        bigEndian);
//        }
//
//class PlayThread extends Thread {
//    byte tempBuffer[] = new byte[10000];
//
//    public void run() {
//        try {
//            while (in.read(tempBuffer) != -1) {
//                sourceDataLine.write(tempBuffer, 0, 10000);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//}
//
//        ----------------------------------------------
//
//        import java.io.BufferedInputStream;
//        import java.io.BufferedOutputStream;
//        import java.io.ByteArrayOutputStream;
//        import java.io.IOException;
//        import java.net.Socket;
//        import javax.sound.sampled.AudioFormat;
//        import javax.sound.sampled.AudioInputStream;
//        import javax.sound.sampled.AudioSystem;
//        import javax.sound.sampled.DataLine;
//        import javax.sound.sampled.Mixer;
//        import javax.sound.sampled.SourceDataLine;
//
//        import javax.sound.sampled.TargetDataLine;
//
//public class Tx {
//    boolean stopCapture = false;
//
//    ByteArrayOutputStream byteArrayOutputStream;
//
//    AudioFormat audioFormat;
//
//    TargetDataLine targetDataLine;
//
//    AudioInputStream audioInputStream;
//
//    BufferedOutputStream out = null;
//
//    BufferedInputStream in = null;
//
//    Socket sock = null;
//
//    SourceDataLine sourceDataLine;
//
//    public static void main(String[] args) {
//        Tx tx = new Tx();
//        tx.captureAudio();
//
//    }
//
//    private void captureAudio() {
//        try {
//
//            sock = new Socket("192.168.1.51", 500);
//
//            out = new BufferedOutputStream(sock.getOutputStream());
//            in = new BufferedInputStream(sock.getInputStream());
//
//            Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
//            System.out.println("Available mixers:");
//            for (int cnt = 0; cnt < audioformat =" getAudioFormat();" datalineinfo =" new" mixer =" AudioSystem.getMixer(mixerInfo[3]);" targetdataline =" (TargetDataLine)" capturethread =" new" datalineinfo1 =" new" sourcedataline =" (SourceDataLine)" playthread =" new" bytearrayoutputstream =" new" stopcapture =" false;" cnt =" targetDataLine.read(tempBuffer,"> 0) {
//
//                byteArrayOutputStream.write(tempBuffer, 0, cnt);
//
//            }
//        }
//        byteArrayOutputStream.close();
//    } catch (Exception e) {
//        System.out.println(e);
//        System.exit(0);
//    }
//}
//}
//
//private AudioFormat getAudioFormat() {
//        float sampleRate = 8000.0F;
//
//        int sampleSizeInBits = 16;
//
//        int channels = 1;
//
//        boolean signed = true;
//
//        boolean bigEndian = false;
//
//        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed,
//        bigEndian);
//        }
//
//class PlayThread extends Thread {
//    byte tempBuffer[] = new byte[10000];
//
//    public void run() {
//        try {
//            while (in.read(tempBuffer) != -1) {
//                sourceDataLine.write(tempBuffer, 0, 10000);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//}
