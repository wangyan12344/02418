package com.repast.weixin.fastweixin.api.response;

import java.util.List;

import com.repast.weixin.fastweixin.api.entity.UpstreamMsgDistWeek;

/**
 * @author 栾冬
 */
public class GetUpstreamMsgDistWeekResponse extends BaseResponse {

    private List<UpstreamMsgDistWeek> list;

    public List<UpstreamMsgDistWeek> getList() {
        return list;
    }

    public void setList(List<UpstreamMsgDistWeek> list) {
        this.list = list;
    }
}
