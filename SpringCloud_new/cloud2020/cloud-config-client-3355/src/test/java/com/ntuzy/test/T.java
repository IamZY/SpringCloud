package com.ntuzy.test;

/**
 * @Author IamZY
 * @create 2020/4/8 13:17
 */
public class T {

    public String t(int n) {
        String one_num = "";
        String zero_num = "";
        if (n == 0) {
            // 1的个数在前 0的个数在后
            return "0" + "," + "1";
        }
        // 判断正数负数
        boolean flag = n > 0 ? true : false;
        if (flag) {
            // 正数
            int state = 1;
            int _one_num = 0;
            int index = 0;
            int temp = 0;
            while (state != 0) {
                if ((n & state) != 0) {
                    _one_num += 1;
                    // 标记最后一个1的位置 也就是最高位1的位置
                    temp = index;
                }
                state = state << 1;
                index++;
            }
            // temp + 1 就是二进制的总长度
            one_num = _one_num + "";
            zero_num = (temp + 1 - _one_num) + "";
        } else {
            // 负数
            int state = 1;
            int _one_num = 0;
            while (state != 0) {
                if ((n & state) != 0) {
                    _one_num += 1;
                }
                state = state << 1;
            }
            one_num = _one_num + "";
            zero_num = 32 - _one_num + "";

        }
        return one_num + "," + zero_num;
    }

    public static void main(String[] args) {
        int num = -1;
        System.out.println(new T().t(num));
        System.out.println(Integer.toBinaryString(num));
    }
}
