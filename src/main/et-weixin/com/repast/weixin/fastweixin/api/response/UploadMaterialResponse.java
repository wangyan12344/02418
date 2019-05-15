package com.repast.weixin.fastweixin.api.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 *  
 *  ====================================================================
 *  沈阳宸阳信息技术有限公司
 *  --------------------------------------------------------------------
 *  @author 栾冬
 *  @version 1.0.beta
 *  ====================================================================
 */
public class UploadMaterialResponse extends BaseResponse  {

    @JSONField(name = "media_id")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
