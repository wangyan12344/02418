package com.repast.weixin.fastweixin.api.response;

import java.util.List;

import com.repast.weixin.fastweixin.api.entity.InterfaceSummary;

/**
 * @author 栾冬
 */
public class GetInterfaceSummaryResponse extends BaseResponse {

    private List<InterfaceSummary> list;

    public List<InterfaceSummary> getList() {
        return list;
    }

    public void setList(List<InterfaceSummary> list) {
        this.list = list;
    }
}
