package com.repast.weixin.fastweixin.message;
/**
 * 提交至微信的图文消息素材
 * ====================================================================
 * 沈阳宸阳信息技术有限公司
 * --------------------------------------------------------------------
 * @author 栾冬
 * @version 1.0.beta
 * ====================================================================
 */
public class MpNewsMsg extends BaseMsg {

    private String mediaId;

    public MpNewsMsg() {
    }

    public MpNewsMsg(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
