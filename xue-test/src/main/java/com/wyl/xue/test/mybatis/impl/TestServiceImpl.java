package com.wyl.xue.test.mybatis.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyl.xue.test.conf.HttpsClientRequestFactory;
import com.wyl.xue.test.mybatis.entity.Test;
import com.wyl.xue.test.mybatis.mapper.TestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * @ClassName: SystemDepartmentServiceImpl
 * @Function: 部门
 * @Date: 2019/12/18 22:11
 * @author wyl
 * @version V1.0
 */
@Service
@Slf4j
@AllArgsConstructor
@DS("slave_1")
@Configuration
@EnableScheduling
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

    @Override
    public void test() {
        test2();
    }

    private void test1() {
        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Host", "crm.iy-cd.com");
        headers.set("Connection", "keep-alive");
        headers.set("Content-Length", "120");
        headers.set("Accept", "*/*");
        headers.set("Origin", "https://crm.iy-cd.com");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("User-Agent", "Mozilla/5.0 (Linux; Android 7.1.1; OPPO R11 Build/NMF26X; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36 Html5Plus/1.0 (Immersed/18.0)");
        headers.set("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set("Referer", "https://crm.iy-cd.com/wns-ciycrmapp/pages/ciycrm/app/login/lr0202.ftl");
//        headers.set("Accept-Encoding", "gzip, deflate");
        headers.set("Accept-Language", "zh-CN,en-US;q=0.8");
        headers.set("Cookie", "SERVER_ID=d9a61b75-f61552d5");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("phoneNumber", "17793132945");
        map.add("password", "Zu1jzyiWjFk0xAtLQgFq7w==");
        map.add("memberid", "");
        map.add("memberId", "");
        map.add("mobile", "");
        map.add("token", "");
        map.add("language", "zh");
        map.add("store", "002");
        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("https://crm.iy-cd.com/wns-ciycrmapp/appLoginController/passwordLogin", formEntity, String.class);
        System.out.println(response.getBody());
    }

    private void test2() {
        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Host", "crm.iy-cd.com");
        headers.set("Connection", "keep-alive");
        headers.set("Content-Length", "158");
        headers.set("Accept", "application/json, text/javascript, */*; q=0.01");
        headers.set("Origin", "https://crm.iy-cd.com");
        headers.set("X-Requested-With", "XMLHttpRequest");
        headers.set("User-Agent", "Mozilla/5.0 (Linux; Android 7.1.1; OPPO R11 Build/NMF26X; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/55.0.2883.91 Mobile Safari/537.36 Html5Plus/1.0 (Immersed/18.0)");
        headers.set("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.set("Referer", "https://crm.iy-cd.com/wns-ciycrmapp/pages/ciycrm/app/home/pt0102.ftl?recordid=218&store=%E5%8F%8C%E6%A5%A0%E5%BA%97&storeId=002&level=1&goodsId=467&eid=544&pikeId=&isspike=2");
//        headers.set("Accept-Encoding", "gzip, deflate");
        headers.set("Accept-Language", "zh-CN,en-US;q=0.8");
//        headers.set("Cookie", "SERVER_ID=d9a61b75-f61552d5; gdxidpyhxdE=fBR5tVxRDQjH%2FiDSpN1dUstHQR0i2qmBNNJaLavYMQupTOSy50the37t6wWoI86vX%5CCjrU%2FtJ%2BhrHOErzbSrSC55T7u%5CjJfZrK%2FdnPW%2FaisLliajvJXXHUAP5Wuae%2FKqEsmf1KBTMu8i%5CSdDisY7BYIAT6gcm83ouPHtVIVJ48ZeGqb5%3A1587485191182; _9755xjdesxxd_=32; YD00967685163033%3AWM_NI=BHNLGKEYNX%2FyNwRxjaDxifuDlFrn4yDkkDTrLI%2BRvALa33eKy4YJbwWcjpU5Uzrw1ogZTfd0XNaP%2FFEaF8blPNtvhYNdMncr13udwqPANhFdQluY67TEdpsEOf9p1awbUlU%3D; YD00967685163033%3AWM_NIKE=9ca17ae2e6ffcda170e2e6ee97f64081b4ba87f04fed9a8eb6d55b938b9faab64ab190a6adb179f39bbbb2f72af0fea7c3b92a829882adc641878782b9ae738ea99e99e96b88a8a787f850b09abe8fb77388b5a5a5d77a9097e5b3f54b90bffdd4e841bbec97abe17d95bda691d83f97a6be98b465a5869c87e73c9c92afb1ae4e87bf8ad9e1689492bc97eb538ebc838fe27af3edbb85f67b949f8289c57093b4bbbab53d989bac91f24f8dbaf791b46bb5be9b8dd837e2a3; YD00967685163033%3AWM_TID=SoQ1478VW%2FhARUUFVEIrV5P2L3oxErE7");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("changeCount", "2");
        map.add("recordid", "218");
        map.add("goodsId", "467");
        map.add("eid", "544");
        map.add("memberid", "9520046000922");
        map.add("memberId", "9520046000922");
        map.add("mobile", "17793132945");
        map.add("token", "AD56266276C01EC876A2D41CE1CB0ADA");
        map.add("language", "zh");
        map.add("store", "002");
        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity("https://crm.iy-cd.com/wns-ciycrmapp/appHomeController/doPointsChange", formEntity, String.class);
        System.out.println(response.getBody());
    }
}
