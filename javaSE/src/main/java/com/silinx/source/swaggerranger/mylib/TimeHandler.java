package com.silinx.source.swaggerranger.mylib;

/**
 * @author ext.liufei5
 * @Description 时间格式化工具
 * @date 2021-01-25
 */
public class TimeHandler {

    /**
     * 将长整型的秒数转化为天时分秒格式的字符串
     * @param timeCount
     * @return
     */
    public static String timeSecondsTrans2Str(Long timeCount) {
        StringBuilder str = new StringBuilder();
        Long dayUnit = 60 * 60 * 24L;
        Long hourUnit = 60 * 60L;
        Long minutesUnit = 60L;
        Boolean daySit = false;
        Boolean hourSit = false;

        Long day = 0L;
        Long hour = 0L;
        Long minutes = 0L;
        Long seconds = 0L;

        day = timeCount / dayUnit;
        timeCount = timeCount % dayUnit;
        if (day != 0L) {
            daySit = true;
            str.append(day);
            str.append("天");
        }

        hour = timeCount / hourUnit;
        timeCount = timeCount % hourUnit;
        if (daySit || hour != 0L) {
            hourSit = true;
            str.append(hour);
            str.append("时");
        }

        minutes = timeCount / minutesUnit;
        seconds = timeCount % minutesUnit;
        if (hourSit || minutes != 0L) {
            str.append(minutes);
            str.append("分");
        }
        str.append(seconds);
        str.append("秒");
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(timeSecondsTrans2Str(12345679L));
        System.out.println(timeSecondsTrans2Str(0L));
    }
}
