package com.repast.weixin.fastweixin.api.response;

import java.util.List;

import com.repast.weixin.fastweixin.api.entity.UserSummary;

/**
 * @author 栾冬
 */
public class GetUserSummaryResponse extends BaseResponse {

    private List<UserSummary> list;

    public List<UserSummary> getList() {
        return list;
    }

    public void setList(List<UserSummary> list) {
        this.list = list;
    }
}
