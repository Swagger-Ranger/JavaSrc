package com.silinx.source.swaggerranger.JavaCore.Enum;

/**
 * 使用抽象方法来是的实现不同抽象方法的枚举实例具备不同的行为
 */

public enum Enum_Advance_Abstract {

    FLY {
        @Override
        public String action() {
            return "I CAN FLY";
        }
    },
    WALK {
        @Override
        public String action() {
            return "I CAN WALK";
        }
    },
    SWIM {
        @Override
        public String action() {
            return "I CAN SWIM";
        }
    };

    public abstract String action();

    public static void main( String[] args ) {
        for (Enum_Advance_Abstract e: Enum_Advance_Abstract.values()) System.out.println(e.action());
    }

}
