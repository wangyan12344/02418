package com.repast.weixin.fastweixin.api.entity;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.repast.weixin.fastweixin.api.enums.MenuType;
import com.repast.weixin.fastweixin.exception.WeixinException;

/**
 * 菜单按钮对象
 *
 * @author 栾冬
 */
public class MenuButton extends BaseModel {

    /**
     * 菜单类别
     */
    private MenuType type;

    /**
     * 菜单上显示的文字
     */
    private String name;

    /**
     * 菜单key，当MenuType值为CLICK时用于区别菜单
     */
    private String key;

    /**
     * 菜单跳转的URL，当MenuType值为VIEW时用
     */
    private String url;

    /**
     * 菜单下发消息是调用，当MenuType值为MEDIA_ID调用
     */
    @JSONField(name = "media_id")
    private String mediaid;
    /**
     * 二级菜单列表，每个一级菜单下最多5个
     */
    @JSONField(name = "sub_button")
    private List<MenuButton> subButton;

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuButton> getSubButton() {
        return subButton;
    }

    public void setSubButton(List<MenuButton> subButton) {
        if (null == subButton || subButton.size() > 5) {
            throw new WeixinException("子菜单最多只有5个");
        }
        this.subButton = subButton;
    }

	public String getMediaid() {
		return mediaid;
	}

	public void setMediaid(String mediaid) {
		this.mediaid = mediaid;
	}
    
}
