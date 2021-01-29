//package com.silinx.FFmpeg;
//
//import com.google.common.collect.Lists;
//import com.jd.analysis.common.utils.SuffixUtils;
//import com.jd.dassist.utils.Assert;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import ws.schild.jave.Encoder;
//import ws.schild.jave.EncoderException;
//import ws.schild.jave.MultimediaObject;
//import ws.schild.jave.encode.AudioAttributes;
//import ws.schild.jave.encode.EncodingAttributes;
//import ws.schild.jave.encode.VideoAttributes;
//
//import java.io.File;
//import java.util.List;
//
///**
// * @author ext.liufei5
// * @Description 视频转音频工具
// * @date 2021-01-28
// */
//public class AudioExtractHandler {
//
//    /**
//     * 音频编码库，另一个库 libvorbis
//     */
//    private static final String       LIB_AUDIO_MP3_CODEC = "libmp3lame";
//    /**
//     * 视频编码库
//     */
//    private static final String       LIB_VIDEO_MP4_CODEC = "mpeg4";
//    /**
//     * bit率
//     */
//    private static final Integer      BIT_RATE            = 128000;
//    /**
//     * 采样率
//     */
//    private static final Integer      SAMPLING_RATE       = 44100;
//    /**
//     * 通道：1单通道，2双通道
//     */
//    private static final Integer      CHANNELS            = 1;
//    /**
//     * 视频帧率
//     */
//    private static final Integer      FRAME_RATE          = 30;
//    /**
//     * 支持的视频格式
//     */
//    private static final List<String> VIDEO_FILE_SUFFIX   = Lists.newArrayList("mp4", "mov", "avi");
//
//
//    /**
//     * 从视频文件中提取音频
//     *
//     * @param source
//     * @param target
//     * @param taskKey
//     * @throws EncoderException
//     */
//    public void videoExtractAudio(File source, File target, String taskKey, VideoExtractAudioService service) throws EncoderException {
//
////        Assert.notNull(source, "视频文件不能为空");
////        Assert.notNull(target, "目标文件不能为空");
//        String fileSuffix = SuffixUtils.getSuffix(source.getPath());
//        Assert.isTrue(VIDEO_FILE_SUFFIX.contains(fileSuffix), "文件格式不支持");
//
//        //设置要转成的音频格式
//        AudioAttributes audio = new AudioAttributes();
//        audio.setCodec(LIB_AUDIO_MP3_CODEC);
//        audio.setBitRate(BIT_RATE);
//        audio.setChannels(CHANNELS);
//        audio.setSamplingRate(SAMPLING_RATE);
//        // 设置编码属性
//        EncodingAttributes attrs = new EncodingAttributes();
//        attrs.setAudioAttributes(audio);
//
//        // 设置转码的源和目标文件
//        MultimediaObject sourceObject = new MultimediaObject(source);
//
//        // 编码到文件
//        Encoder encoder = new Encoder();
//        encoder.encode(sourceObject, target, attrs, new AudioExtractListener(taskKey, service));
//    }
//
//    /**
//     * 修改音频文件格式
//     *
//     * @param source
//     * @param target
//     * @return
//     */
//    public String videoFormatTrans(File source, File target) throws EncoderException {
//
//        AudioAttributes audio = new AudioAttributes();
//        audio.setCodec(LIB_AUDIO_MP3_CODEC);
//        VideoAttributes video = new VideoAttributes();
//        video.setCodec(LIB_VIDEO_MP4_CODEC);
//        video.setBitRate(BIT_RATE);
//        video.setFrameRate(FRAME_RATE);
//        EncodingAttributes attrs = new EncodingAttributes();
//        attrs.setAudioAttributes(audio);
//        attrs.setVideoAttributes(video);
//
//        //Encode
//        Encoder encoder = new Encoder();
//        encoder.encode(new MultimediaObject(source), target, attrs, new AudioExtractListener());
//        return target.getPath();
//    }
//
//
//    public static void main(String[] args) throws EncoderException {
////        System.out.println(videoExtractAudio(new File("D:\\pi.mp4"), new File("D:\\temp\\pi2.wav")));
////        System.out.println(videoFormatTrans(new File("D:\\tmp\\justFun.avi"),new File("D:\\tmp\\justFun.mp4")));
//
//    }
//}
