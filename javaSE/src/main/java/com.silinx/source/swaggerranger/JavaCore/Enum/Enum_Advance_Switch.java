package com.silinx.source.swaggerranger.JavaCore.Enum;

public class Enum_Advance_Switch {

    public static void main( String[] args ) {
        printDay(Day.MONDAY);
        printDay(Day.TUESDAY);
        printDay(Day.WEDNESDAY);
        printDay(Day.THURSDAY);
        printDay(Day.FRIDAY);
        printDay(Day.SATURDAY);
        printDay(Day.SUNDAY);
    }

    /**
     * switch语句后不加break,那么代码会一直顺序执行下去(忽略后面的case条件判断),直到break或是end语句
     * @param day
     */
    private static void printDay(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("星期一");
                break;
            case TUESDAY:
                System.out.println("星期二");
                break;
            case WEDNESDAY:
                System.out.println("星期三");
                break;
            case THURSDAY:
                System.out.println("星期四");
                break;
            case FRIDAY:
                System.out.println("星期五");
                break;
            case SATURDAY:
                System.out.println("星期六");
                break;
            case SUNDAY:
                System.out.println("星期天");
                break;
        }
    }
}

