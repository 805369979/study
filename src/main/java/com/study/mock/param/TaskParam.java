package com.study.mock.param;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 不同的参数定制
 */
@Data
public class TaskParam implements Param {
    private Map<String,Object> params = new HashMap<>();

    @Override
    public Object getParam(String key) {
        return this.params.get(key);
    }

    @Override
    public void addParam(String key, Object value) {
        if (key != null && value != null) {
            this.params.put(key, value);
        }
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
