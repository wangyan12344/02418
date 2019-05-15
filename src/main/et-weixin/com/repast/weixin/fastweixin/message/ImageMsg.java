package com.repast.weixin.fastweixin.message;


import com.repast.weixin.fastweixin.message.util.MessageBuilder;

/**
 * @author 栾冬
 */
public class ImageMsg extends BaseMsg {

    private String mediaId;

    public ImageMsg() {
    }

    public ImageMsg(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toXml() {
        MessageBuilder mb = new MessageBuilder(super.toXml());
        mb.addData("MsgType", RespType.IMAGE);
        mb.append("<Image>\n");
        mb.addData("MediaId", mediaId);
        mb.append("</Image>\n");
        mb.surroundWith("xml");
        return mb.toString();
    }

}
