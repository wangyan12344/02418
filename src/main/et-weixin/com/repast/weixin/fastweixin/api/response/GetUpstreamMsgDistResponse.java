package com.repast.weixin.fastweixin.api.response;

import java.util.List;

import com.repast.weixin.fastweixin.api.entity.UpstreamMsgDist;

/**
 * @author 栾冬
 */
public class GetUpstreamMsgDistResponse extends BaseResponse {

    private List<UpstreamMsgDist> list;

    public List<UpstreamMsgDist> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDist> list) {
        this.list = list;
    }
}
