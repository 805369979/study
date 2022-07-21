package com.study.mock.task;

import com.study.mock.param.Param;

/**
 * 接口前后置处理
 */
public interface PrePostHandler {
    /**
     * 前置处理
     */
    void preHandle();
    /**
     * 业务处理
     */
    void handle(Param parm);
    /**
     * 后置处理
     */
    void postHandle();
}
