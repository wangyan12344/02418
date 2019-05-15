package com.zhiliang.business.weixin.servlet;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.repast.weixin.fastweixin.handle.EventHandle;
import com.repast.weixin.fastweixin.handle.MessageHandle;
import com.repast.weixin.fastweixin.message.BaseMsg;
import com.repast.weixin.fastweixin.message.TextMsg;
import com.repast.weixin.fastweixin.message.req.TextReqMsg;
import com.repast.weixin.fastweixin.servlet.WeixinSupport;

/**
 * 用户自行实现的微信消息收发处理器 项目扩展
 * 
 * @author luandong
 *
 */
public class MyServletWeixinSupport extends WeixinSupport {
	private static final Logger log = LoggerFactory
			.getLogger(MyServletWeixinSupport.class);

	@Override
	protected String getToken() {
		return "PalaceSun";
	}

	@Override
	protected BaseMsg handleTextMsg(TextReqMsg msg) {
		String content = msg.getContent();
		log.debug("用户发送到服务器的内容:{}", content);
		return new TextMsg("服务器回复用户消息!");
	}
	
	


    /*1.1版本新增，重写父类方法，加入自定义微信消息处理器
     *不是必须的，上面的方法是统一处理所有的文本消息，如果业务觉复杂，上面的会显得比较乱
     *这个机制就是为了应对这种情况，每个MessageHandle就是一个业务，只处理指定的那部分消息
     */
    @Override
    protected List<MessageHandle> initMessageHandles() {
            List<MessageHandle> handles = new ArrayList<MessageHandle>();
     //       handles.add(new MyMessageHandle());
            return handles;
    }
    //1.1版本新增，重写父类方法，加入自定义微信事件处理器，同上
    @Override
    protected List<EventHandle> initEventHandles() {
            List<EventHandle> handles = new ArrayList<EventHandle>();
            handles.add(new CourseScanCodeEventHandle());
            return handles;
    }
}
