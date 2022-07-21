package com.study.mock.task;

import com.study.mock.enums.BusinessEnum;
import com.study.mock.param.Param;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 洁祎~   任务执行模板
 */

@Slf4j
//@Service
public class Task extends AbstractTaskTemplate {

    public Task(String insertDao,
                String addDataDao,
                String deleteDao) {
        super.insertDao = insertDao;
        super.addDataDao = addDataDao;
        super.deleteDao = deleteDao;
    }

    /**
     * 设置业务处理code
     * @return
     */
    @Override
    public String getAlarmCode() {
        return BusinessEnum.test_code.getCode();
    }

    /**
     * 统一数据获取渠道
     * @return map
     */
    @Override
    protected Map<String, String> getBusinessDataMap() {
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("data1", "获取的业务数据1");
        dataMap.put("data2", "获取的业务数据2");
        return dataMap;
    }

    /**
     * 任务处理入口函数
     */
    @Override
    public void handle(Param parm) {
        preHandle();
        // 1. 获取数据操作
        Map<String, String> businessDataMap = getBusinessDataMap();
        // 2. 业务逻辑处理操作
        System.out.println("任务参数为"+parm+"开始运行了");
        System.out.println("现在正在进行"+this.addDataDao+"操作");
        System.out.println("任务1需要用的业务数据是"+businessDataMap.toString());
        //3.持久化数据库操作
        insertData("插入数据");
        postHandle();
    }

    /**
     * 前置处理
     */
    @Override
    public void preHandle() {
        System.out.println("前置处理，可用于数据准备工作操作");
    }

    /**
     * 后置处理
     */
    @Override
    public void postHandle() {
        System.out.println("后置处理，可用于回收资源等操作");
    }
}