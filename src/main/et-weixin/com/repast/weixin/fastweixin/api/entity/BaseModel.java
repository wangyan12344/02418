package com.repast.weixin.fastweixin.api.entity;

import com.repast.weixin.fastweixin.util.JSONUtil;

/**
 * 抽象实体类
 *
 * @author 栾冬
 */
public abstract class BaseModel implements Model {
    @Override
    public String toJsonString() {
        return JSONUtil.toJson(this);
    }
}
