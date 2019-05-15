package com.repast.weixin.fastweixin.api.response;

import com.repast.weixin.fastweixin.api.entity.Menu;

/**
 * @author 栾冬
 */
public class GetMenuResponse extends BaseResponse {

    private Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
