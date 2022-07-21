package com.study.test;//package com.leetcode.stack;
import java.util.Random;
public class test extends RetryingUtil<String>
{
    public static void main(String[] args) {
        test test = new test();
        Object retry = test.retry();
        System.out.println("重试获得的结果为:"+retry);
        System.out.println("============================");
        test test1 = new test();
        Object retry1 = test.retry("a","b");
        System.out.println("重试获得的结果为:"+retry1);
    }

    @Override
    protected int retryTimes() {
        return 4;
    }

    @Override
    protected String getDataByRetrying(Object... param) {
        System.out.println("重试代码中.....");
        System.out.println("重试人工号"+new Random().nextInt(10));
        return "重试成功";
    }
}
