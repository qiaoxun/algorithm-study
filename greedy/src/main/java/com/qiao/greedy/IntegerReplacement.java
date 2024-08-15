package com.qiao.greedy;

public class IntegerReplacement {

    public static void main(String[] args) {
//        IntegerReplacement integerReplacement3 = new IntegerReplacement();
//        int result3 = integerReplacement3.integerReplacement(3);
//        System.out.println("result3 = " + result3);
//        assert result3 == 2;
//
        IntegerReplacement integerReplacement = new IntegerReplacement();
//        int result4 = integerReplacement.integerReplacement(4);
//        System.out.println("result4 = " + result4);
//        assert result4 == 2;
//
//        int result8 = integerReplacement.integerReplacement(8);
//        System.out.println("result8 = " + result8);
//        assert result8 == 3;
//
//        int result7 = integerReplacement.integerReplacement(7);
//        System.out.println("result7 = " + result7);
//        assert result7 == 4;
//
//        int result1234 = integerReplacement.integerReplacement(1234);
//        System.out.println("result123 = " + result1234);
//        assert result1234 == 14;
//
//        int result65535 = integerReplacement.integerReplacement(65535);
//        System.out.println("result65535 = " + result65535);
//        assert result65535 == 17;

        int result2147483647 = integerReplacement.integerReplacement(2147483647);
        System.out.println("result2147483647 = " + result2147483647);
        assert result2147483647 == 17;
    }

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        int result = 0;

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                result++;
            } else {
                if (n == 3) {
                    n = 1;
                    result += 2;
                } else if (n % 4 == 1) {
                    n = (n - 1) / 2;
                    result += 2;
                } else {
                    n = n / 2 + 1;
                    result += 2;
                }
            }
        }
        return result;
    }

    public int integerReplacement1(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            } else if (n % 4 == 1) {
                ans += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }



//    public int integerReplacement(int n) {
//        int ans = 0;
//        while (n != 1) {
//            if (n % 2 == 0) {
//                ++ans;
//                n /= 2;
//            } else if (n % 4 == 1) {
//                ans += 2;
//                n /= 2;
//            } else {
//                if (n == 3) {
//                    ans += 2;
//                    n = 1;
//                } else {
//                    ans += 2;
//                    n = n / 2 + 1;
//                }
//            }
//        }
//        return ans;
//    }

}
