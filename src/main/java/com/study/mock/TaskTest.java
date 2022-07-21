package com.study.mock;

import com.study.mock.enums.BusinessEnum;
import com.study.mock.param.Param;
import com.study.mock.param.TaskParam;
import com.study.mock.task.Task;

public class TaskTest {
    public static void main(String[] args) {
        BusinessEnum.businessCodes();
        // 1. 初始化测试类
        Task task = new Task("insert","add","delete");

        Param taskParam = new TaskParam();
        taskParam.addParam("param","任务1的参数设置完成");

        if (BusinessEnum.businessLists.contains(task.getAlarmCode())){
            task.handle(taskParam);
        }
    }
}
