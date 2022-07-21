package com.study.mock.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 洁祎~ 任务code枚举类
 */
public enum BusinessEnum {
    test_code("test_ode");
    private String code;

    BusinessEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 保存code的列表
     */
    public static List<String> businessLists = new ArrayList<>();

    public static void businessCodes(){
        for (BusinessEnum i : BusinessEnum.values()){
            businessLists.add(i.getCode());
        }
    }
}
