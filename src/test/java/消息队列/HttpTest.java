package 消息队列;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.net.URLEncoder;

/**
 * @program testCollections
 * @description: 请求测试
 * @author: xielinzhi
 * @create: 2019/09/22 23:11
 */

public class HttpTest {

    @Test
    public void doPost() throws Exception{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 参数
        StringBuffer params = new StringBuffer();
        params.append("&Usercode=" + URLEncoder.encode("testxlz", "GBK"));
        params.append("&Fullname=" + URLEncoder.encode("苏珊珊", "GBK"));
        params.append("&Password=" + URLEncoder.encode("123456", "GBK"));
        params.append("&UserState=" + URLEncoder.encode("1", "GBK"));
        HttpPost httpPost = new HttpPost("http://localhost:10025/hello?txncode=PTL002"+params);
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded;charset=GBK");
        System.out.println(httpPost.getURI());
        // 响应模型
        CloseableHttpResponse response = null;

        response = httpClient.execute(httpPost);
        // 从响应模型中获取响应实体
        HttpEntity responseEntity = response.getEntity();

        System.out.println("响应状态为:" + response.getStatusLine());
        if (responseEntity != null) {
            System.out.println("响应内容长度为:" + responseEntity.getContentLength());
            System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
        }

        // 释放资源
        if (httpClient != null) {
            httpClient.close();
        }
        if (response != null) {
            response.close();
        }
    }

    @Test
    public void testGBK() throws Exception{
        System.out.println( URLEncoder.encode("苏珊珊", "GBK"));
    }
}
