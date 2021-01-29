package com.silinx.FFmpeg;

import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.info.AudioInfo;
import ws.schild.jave.info.MultimediaInfo;
import ws.schild.jave.info.VideoInfo;
import ws.schild.jave.info.VideoSize;

import java.io.File;

/**
 * @author ext.liufei5
 * @Description
 * @date 2021-01-20
 */
public class Video2Voice {

    public static void main(String[] args) throws EncoderException {
        testExtractAudioFromVideo();
//        testGetVideoInfo();
    }

    private static void testExtractAudioFromVideo() throws EncoderException {

        //设置要转成的音频格式
        AudioAttributes audio = new AudioAttributes();
        //todo 设置mp3，wav等对应的编码
        audio.setCodec("libmp3lame");
//        audio.setCodec("wav");
        audio.setBitRate(128000);
        audio.setChannels(1);
        audio.setSamplingRate(44100);
        //Encoding attributes
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setAudioAttributes(audio);

        // 设置转码的源和目标文件
        File file = new File("D:\\justFun.mp4");
        File target = new File("D:\\justFun1.wav");
        MultimediaObject sourceObject = new MultimediaObject(file);

        //解码
        Encoder encoder = new Encoder();
        encoder.encode(sourceObject, target, attrs);


    }

    private static void testGetVideoInfo() throws EncoderException {
        File file = new File("D:\\pi.mp4");

        //获取媒体信息
        MultimediaObject multimediaObject = new MultimediaObject(file);
        MultimediaInfo info = multimediaObject.getInfo();
        //音频信息
        AudioInfo ai = info.getAudio();

        //视频信息
        VideoInfo vi = info.getVideo();
        // ------ 音频信息 -------
        System.out.println();
        System.out.println(ai.getDecoder());
        //声道
        System.out.println(ai.getChannels());
        //比特率
        System.out.println(ai.getBitRate());
        //采样率
        System.out.println(ai.getSamplingRate());
        // ------ 视频信息 -------
        System.out.println(vi.getDecoder());
        //比特率
        System.out.println(vi.getBitRate());
        //帧率
        System.out.println(vi.getFrameRate());
        VideoSize size = vi.getSize();
        //视频宽度
        System.out.println(size.getWidth());
        //视频高度
        System.out.println(size.getHeight());
    }

    private static void test1() {
        try {
            File source = new File("D:\\test.wav");
            File target = new File("D:\\test3.mp3");

            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(128000);
            audio.setChannels(2);
            audio.setSamplingRate(44100);

            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
//            attrs.setFormat("mp3");
            attrs.setAudioAttributes(audio);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);

        } catch (Exception ex) {
            System.out.println(ex.getStackTrace());
        }
    }

}
