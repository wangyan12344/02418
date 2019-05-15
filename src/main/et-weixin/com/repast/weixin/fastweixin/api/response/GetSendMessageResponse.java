package com.repast.weixin.fastweixin.api.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *  获取群发消息结果
 *  ====================================================================
 *  沈阳宸阳信息技术有限公司
 *  --------------------------------------------------------------------
 *  @author 栾冬
 *  @version 1.0.beta
 *  ====================================================================
 */
public class GetSendMessageResponse extends BaseResponse {

    @JSONField(name="msg_id")
    private String msgId;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
