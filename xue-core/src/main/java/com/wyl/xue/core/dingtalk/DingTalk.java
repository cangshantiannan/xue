/**
 * @Author wangyl
 * @E-mail wangyl0629@foxmail.com
 **/
package com.wyl.xue.core.dingtalk;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: DingTalk
 * @Function: 发送钉钉消息的工具类
 * @Date: 2020/5/2 0:05
 * @author wyl
 * @version V1.0
 */
@Slf4j
public class DingTalk {
    private OapiRobotSendRequest request;
    private DingTalkClient client;

    public DingTalk(final String serverUrl) {
        client = new DefaultDingTalkClient(serverUrl);
        request = new OapiRobotSendRequest();
    }

    /**
     * @Description 发送文字消息
     * @param msg 文字消息
     * @param phones 需要AT的人 null 为所有人
     * @return void
     * @Date 2020/5/12 3:25 下午
     * @Author wangyl
     * @Version V1.0
     */
    public void sendText(@NotNull final String msg, final List<String> phones) throws ApiException {
        request.setAt(makeAt(phones));
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(msg);
        request.setMsgtype("text");
        request.setText(text);
        sendToDingTalk();
    }

    /**
     * @Description
     * @param link
     * @param phones
     * @return void
     * @Date 2020/5/12 3:26 下午
     * @Author wangyl
     * @Version V1.0
     */
    public void sendLink(OapiRobotSendRequest.Link link, final List<String> phones) throws ApiException {
        request.setAt(makeAt(phones));
        request.setMsgtype("link");
        request.setLink(link);
        sendToDingTalk();
    }

    /**
     * @Description
     * @param markdown
     * @param phones
     * @return void
     * @Date 2020/5/12 3:26 下午
     * @Author wangyl
     * @Version V1.0
     */
    public void sendMarkdown(OapiRobotSendRequest.Markdown markdown, final List<String> phones) throws ApiException {
        request.setAt(makeAt(phones));
        request.setMsgtype("markdown");
        request.setMarkdown(markdown);
        sendToDingTalk();
    }


    /**
     * @Description
     * @param actioncard
     * @param phones
     * @return void
     * @Date 2020/5/12 3:26 下午
     * @Author wangyl
     * @Version V1.0
     */
    public void sendActionCard(OapiRobotSendRequest.Actioncard actioncard, final List<String> phones) throws ApiException {
        request.setAt(makeAt(phones));
        request.setMsgtype("actionCard");
        request.setActionCard(actioncard);
        sendToDingTalk();
    }


    /**
     * @Description
     * @param feedcard
     * @param phones
     * @return void
     * @Date 2020/5/12 3:26 下午
     * @Author wangyl
     * @Version V1.0
     */
    public void sendFeedCard(OapiRobotSendRequest.Feedcard feedcard, final List<String> phones) throws ApiException {
        request.setAt(makeAt(phones));
        request.setFeedCard(feedcard);
        sendToDingTalk();
    }

    /**
     * @Description 组装At人 null为所有人
     * @param phones
     * @return com.dingtalk.api.request.OapiRobotSendRequest.At
     * @Date 2020/5/12 3:26 下午
     * @Author wangyl
     * @Version V1.0
     */
    private OapiRobotSendRequest.At makeAt(final List<String> phones) {
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        if (Objects.isNull(phones) || phones.isEmpty()) {
            at.setIsAtAll("true");
            return at;
        }
        at.setIsAtAll("false");
        at.setAtMobiles(phones);
        return at;
    }

    /**
     * @Description 给钉钉发送消息
     * @param
     * @return void
     * @Date 2020/5/12 3:26 下午
     * @Author wangyl
     * @Version V1.0
     */
    private void sendToDingTalk() throws ApiException {
        OapiRobotSendResponse response = client.execute(request);
        if (log.isDebugEnabled()) {
            log.debug("发送钉钉消息返回信息为[{}]", response);
        }
        //TODO 需要增加异常处理
        log.error(response.getErrmsg());
    }
}
