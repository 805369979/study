package com.study.test;
import lombok.extern.slf4j.Slf4j;
/**
 * 锁重试工具类
 * @author qinbinbin
 * @param <T> 泛型，指定返回结果类型
 */
@Slf4j
public abstract class RetryingUtil<T> {
    /**
     * 指定重试次数，必须重写
     * @return
     */
    protected abstract int retryTimes();
    /**
     * 重试业务逻辑，需要用户自己实现
     * @return
     */
    protected abstract T getDataByRetrying(Object... param);

    public T retry(Object... param) {
        // 获取重试次数
        int retryTimes = retryTimes();
        // 重试次数条件限制
        if (retryTimes <= 0){
            log.warn("重试次数必须大于0");
            throw new RuntimeException("重试次数必须大于0");
        }
        // 辅助判断是否重试成功
        boolean retryIsSuccess = Boolean.FALSE;
        T result = null;
        // 开始重试
        for (int cnt = 0; cnt < retryTimes; cnt++) {
            try {
                //TODO 测试代码 , 可以扔掉的
                if (cnt == 0){
                    throw new RuntimeException("测试异常");
                }
                // 调用重试逻辑
                result = this.getDataByRetrying(param);
                //设置重试成功的flag
                retryIsSuccess = true;
                break;
            } catch (Exception e) {
                log.info("第:{}次重试失败,方法参数是:{},异常信息是:{}",cnt,param,e.getMessage());
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException interruptedexception) {
                    log.warn("线程等待异常,异常信息是:{}", interruptedexception.getMessage());
                }
            }
        }
        // 查询正常
        if (retryIsSuccess) {
            return result;
        }
        log.info("重试失败");
        return null;
    }
}
