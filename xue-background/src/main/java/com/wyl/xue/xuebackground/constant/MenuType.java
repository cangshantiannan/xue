package com.wyl.xue.xuebackground.constant;

/**
 * @ClassName: MenuType
 * @Function:  菜单类型
 * @Date:      2019/12/18 22:27
 * @author     wangyl
 * @version    V1.0
 */ 
public enum MenuType {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }