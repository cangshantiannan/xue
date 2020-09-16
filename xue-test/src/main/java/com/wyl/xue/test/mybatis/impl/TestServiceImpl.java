package com.wyl.xue.test.mybatis.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
        test3();
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

    private void test3() {
        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());


        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json, text/javascript, */*; q=0.01");
//        headers.set("Accept-Encoding", "gzip, deflate, br");
        headers.set("Accept-Language", "zh-CN,zh;q=0.9");
        headers.set("Connection", "keep-alive");
        headers.set("Cookie", "JSESSIONID=758D18061DC8B9A6F2DD6E40F63EE915; zwyClient=6b7c908a-3f0a-46bd-bf15-4d49aaf0e1f8; fct=1585288510baf218dff7b1ad5de2e6bc; gj-phone=18908018529; gj-new=1571277068281051054131eb78f27dd1; ZNKFhref=https://www.bangwo8.com/osp2016/chat/pc/index.php?vendorID=242476&field_value=6064-44024&field_key=authAccount&tagSkillList=&permissions=0&customInfo=%26compName%3D%25E6%2588%2590%25E9%2583%25BD%25E5%25AD%2599%25E5%25A4%25A7%25E8%2583%259C%25E8%25B4%25A2%25E7%25A8%258E%25E5%2592%25A8%25E8%25AF%25A2%25E6%259C%2589%25E9%2599%2590%25E5%2585%25AC%25E5%258F%25B8%26employeeNo%3D18908018529%26employeeName%3D%25E6%259C%2588%25E6%259C%2588%26contractBegin%3D2018-12-27%26contractEnd%3D2024-06-27%26accountNum%3D%25E8%25B4%25AD%25E4%25B9%25B0%25E6%2595%25B0%25EF%25BC%259A50-%25E5%25B7%25B2%25E4%25BD%25BF%25E7%2594%25A8%25EF%25BC%259A45%26autotaxValue%3D0.00%25E5%2585%2583; customInfoZNKF=https://www.bangwo8.com/osp2016/chat/pc/index.php?vendorID=242476&field_value=6064-44024&field_key=authAccount&tagSkillList=&permissions=0&customInfo=%26compName%3D%25E6%2588%2590%25E9%2583%25BD%25E5%25AD%2599%25E5%25A4%25A7%25E8%2583%259C%25E8%25B4%25A2%25E7%25A8%258E%25E5%2592%25A8%25E8%25AF%25A2%25E6%259C%2589%25E9%2599%2590%25E5%2585%25AC%25E5%258F%25B8%26employeeNo%3D18908018529%26employeeName%3D%25E6%259C%2588%25E6%259C%2588%26contractBegin%3D2018-12-27%26contractEnd%3D2024-06-27%26accountNum%3D%25E8%25B4%25AD%25E4%25B9%25B0%25E6%2595%25B0%25EF%25BC%259A50-%25E5%25B7%25B2%25E4%25BD%25BF%25E7%2594%25A8%25EF%25BC%259A45%26autotaxValue%3D0.00%25E5%2585%2583; fieldValueZNKF=6064-44024; userId=763945; H_KJ_ID=8700000925215; H_KJ_COMID=2203078; thisDbid=8700000925215; Hm_lvt_aa4f230f6878e8cb77ea9eb20c0ff9f3=1587630105; Hm_lpvt_aa4f230f6878e8cb77ea9eb20c0ff9f3=1587630293");
        headers.set("Host", "vip2.kdzwy.com:34");
        headers.set("Referer", "https://vip2.kdzwy.com:34/voucher/voucher-list.jsp");
        headers.set("Sec-Fetch-Mode", "cors");
        headers.set("Sec-Fetch-Site", "same-origin");
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        headers.set("X-Requested-With", "XMLHttpRequest");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(map, headers);
        map.add("m", "findList");
        map.add("fromPeriod", "202004");
        map.add("toPeriod", "202004");
        map.add("_search", "false");
        map.add("nd", "1587630611441");
        map.add("rows", "100");
        map.add("page", "1");
        map.add("sidx", "date");
        map.add("sord", "asc");

        ResponseEntity<String> response = restTemplate.postForEntity("https://vip2.kdzwy.com:34/gl/voucher", formEntity, String.class);
        JSONObject json = JSONObject.parseObject(response.getBody());
        JSONArray rows = json.getJSONArray("rows");
        int num = 0;
        for (int i = 0; i < rows.size(); i++) {
            num++;
            String id = rows.getJSONObject(i).getString("id");
            System.out.println(id);

            test4(id);
        }
        System.out.println(num);
    }

    private void test4(String id) {
        RestTemplate restTemplate = new RestTemplate(new HttpsClientRequestFactory());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json, text/javascript, */*; q=0.01");
        headers.set("Accept-Language", "zh-CN,zh;q=0.9");
        headers.set("Connection", "keep-alive");
        headers.set("Cookie", "JSESSIONID=758D18061DC8B9A6F2DD6E40F63EE915; zwyClient=6b7c908a-3f0a-46bd-bf15-4d49aaf0e1f8; fct=1585288510baf218dff7b1ad5de2e6bc; gj-phone=18908018529; gj-new=1571277068281051054131eb78f27dd1; ZNKFhref=https://www.bangwo8.com/osp2016/chat/pc/index.php?vendorID=242476&field_value=6064-44024&field_key=authAccount&tagSkillList=&permissions=0&customInfo=%26compName%3D%25E6%2588%2590%25E9%2583%25BD%25E5%25AD%2599%25E5%25A4%25A7%25E8%2583%259C%25E8%25B4%25A2%25E7%25A8%258E%25E5%2592%25A8%25E8%25AF%25A2%25E6%259C%2589%25E9%2599%2590%25E5%2585%25AC%25E5%258F%25B8%26employeeNo%3D18908018529%26employeeName%3D%25E6%259C%2588%25E6%259C%2588%26contractBegin%3D2018-12-27%26contractEnd%3D2024-06-27%26accountNum%3D%25E8%25B4%25AD%25E4%25B9%25B0%25E6%2595%25B0%25EF%25BC%259A50-%25E5%25B7%25B2%25E4%25BD%25BF%25E7%2594%25A8%25EF%25BC%259A45%26autotaxValue%3D0.00%25E5%2585%2583; customInfoZNKF=https://www.bangwo8.com/osp2016/chat/pc/index.php?vendorID=242476&field_value=6064-44024&field_key=authAccount&tagSkillList=&permissions=0&customInfo=%26compName%3D%25E6%2588%2590%25E9%2583%25BD%25E5%25AD%2599%25E5%25A4%25A7%25E8%2583%259C%25E8%25B4%25A2%25E7%25A8%258E%25E5%2592%25A8%25E8%25AF%25A2%25E6%259C%2589%25E9%2599%2590%25E5%2585%25AC%25E5%258F%25B8%26employeeNo%3D18908018529%26employeeName%3D%25E6%259C%2588%25E6%259C%2588%26contractBegin%3D2018-12-27%26contractEnd%3D2024-06-27%26accountNum%3D%25E8%25B4%25AD%25E4%25B9%25B0%25E6%2595%25B0%25EF%25BC%259A50-%25E5%25B7%25B2%25E4%25BD%25BF%25E7%2594%25A8%25EF%25BC%259A45%26autotaxValue%3D0.00%25E5%2585%2583; fieldValueZNKF=6064-44024; userId=763945; H_KJ_ID=8700000925215; H_KJ_COMID=2203078; thisDbid=8700000925215; Hm_lvt_aa4f230f6878e8cb77ea9eb20c0ff9f3=1587630105; Hm_lpvt_aa4f230f6878e8cb77ea9eb20c0ff9f3=1587630293");
        headers.set("Host", "vip2.kdzwy.com:34");
        headers.set("Referer", "https://vip2.kdzwy.com:34/voucher/voucher-list.jsp");
        headers.set("Sec-Fetch-Mode", "cors");
        headers.set("Sec-Fetch-Site", "same-origin");
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        headers.set("X-Requested-With", "XMLHttpRequest");
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, String>> formEntity = new HttpEntity<>(map, headers);
        map.add("m", "getVchById");
        map.add("vchId", id);
        ResponseEntity<String> response = restTemplate.postForEntity("https://vip2.kdzwy.com:34/gl/voucher", formEntity, String.class);
        JSONObject json = JSONObject.parseObject(response.getBody());
        JSONObject data = json.getJSONObject("data");

        JSONObject res = new JSONObject();
        res.put("附单据", data.get("attachments"));
        res.put("制单人", data.get("attachments"));
        res.put("是否结账", data.get("attachments"));
        res.put("录入时间", data.get("attachments"));
        res.put("信贷总额", data.get("attachments"));
        res.put("日期", data.get("attachments"));
        res.put("总借钱", data.get("attachments"));
        res.put("摘要", data.get("attachments"));
        res.put("最后修改时间", data.get("attachments"));
        res.put("凭证号", data.get("attachments"));
        res.put("年月", data.get("attachments"));
        res.put("会计科目", data.get("attachments"));
        res.put("会计号", data.get("attachments"));
        res.put("总计", data.get("attachments"));
        res.put("借款", data.get("attachments"));
        res.put("借款摘要", data.get("attachments"));
        res.put("贷方", data.get("attachments"));
        res.put("贷方摘要", data.get("attachments"));

        JSONArray datas = json.getJSONArray("entries");


        System.out.println(json);
    }


}
