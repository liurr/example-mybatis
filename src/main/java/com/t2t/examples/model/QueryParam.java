package com.t2t.examples.model;

import java.util.Map;

public interface QueryParam extends Map<String, Object> {

    /**
     * 新增查询参数
     *
     * @param key   参数名
     * @param value 参数值
     * @return
     */
    QueryParam put(String key, Object value);
}