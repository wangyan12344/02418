package com.repast.weixin.fastweixin.api.response;

import java.util.List;

import com.repast.weixin.fastweixin.api.entity.InterfaceSummaryHour;

/**
 * @author 栾冬
 */
public class GetInterfaceSummaryHourResponse extends BaseResponse {

    private List<InterfaceSummaryHour> list;

    public List<InterfaceSummaryHour> getList() {
        return list;
    }

    public void setList(List<InterfaceSummaryHour> list) {
        this.list = list;
    }
}
