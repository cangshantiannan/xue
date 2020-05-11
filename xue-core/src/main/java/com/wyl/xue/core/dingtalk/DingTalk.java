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

    public void sentText(@NotNull final String msg, final List<String> phones) throws ApiException {
        request.setAt(makeAt(phones));
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent(msg);
        request.setMsgtype("text");
        request.setText(text);
        sendToDingTalk();
    }

    public void sendLink(OapiRobotSendRequest.Link link, final List<String> phones) throws ApiException {
        request.setAt(makeAt(phones));
        request.setMsgtype("link");
        request.setLink(link);
        sendToDingTalk();
    }


    public void sendMarkdown(OapiRobotSendRequest.Markdown markdown, final List<String> phones) throws ApiException {
        request.setAt(makeAt(phones));
        request.setMsgtype("markdown");
        request.setMarkdown(markdown);
        sendToDingTalk();
    }


    public void sendActionCard(OapiRobotSendRequest.Actioncard actioncard, final List<String> phones) throws ApiException {
        request.setAt(makeAt(phones));
        request.setMsgtype("actionCard");
        request.setActionCard(actioncard);
        sendToDingTalk();
    }


    public void sendFeedCard(OapiRobotSendRequest.Feedcard feedcard, final List<String> phones) throws ApiException {
        request.setAt(makeAt(phones));
        request.setFeedCard(feedcard);
        sendToDingTalk();
    }

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

    private void sendToDingTalk() throws ApiException {
        OapiRobotSendResponse response = client.execute(request);
        if (log.isDebugEnabled()) {
            log.debug("发送钉钉消息返回信息为[{}]", response);
        }
        System.out.println(response.getErrmsg());
    }
}
