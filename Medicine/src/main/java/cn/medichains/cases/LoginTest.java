package cn.medichains.cases;

import cn.medichains.config.TestConfig;
import cn.medichains.model.InterfaceName;
import cn.medichains.model.LoginCase;
import cn.medichains.utils.ConfigFile;
import cn.medichains.utils.DataBaseUtil;
import cn.medichains.utils.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.sh.HMACSHA256.encrytSHA256;

public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "初始化数据，接口URL赋值")
    public void beforeTest(){
        TestConfig.getTokenUrl = ConfigFile.getUrl(InterfaceName.GETTOKEN);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.addMedicineUrl = ConfigFile.getUrl(InterfaceName.ADDMEDICINE);
    }

    @Test(groups = "loginTrue",description = "测试登陆成功")
    public void loginTrue(){
        SqlSession session = null;
        try {
            session = DataBaseUtil.getSqlSession();
            //获取用例
            LoginCase loginCase = session.selectOne("loginCase",1);
            if (loginCase != null){
                System.out.println(loginCase.toString());
            }
            //根据用例执行接口
            String result = getResult(loginCase);
            JSONObject resultJson = JSONObject.parseObject(result);
            //验证结果是否同预期
            Assert.assertEquals(resultJson.getString("status"), loginCase.getExpected());
            //Assert.assertEquals(resultJson.getString("msg"),"登录成功");
        }catch (IOException e){
            session.rollback();
        }finally {
            session.close();
        }
    }

    private String getResult(LoginCase loginCase) throws IOException {
        //header组装
        HashMap<String,String>headers = new HashMap<>();
        headers.put("Content-Type","application/json;charset=UTF-8");
        //获取uuid
        String tokenResult = HttpClientUtil.get(TestConfig.getTokenUrl,headers);
        System.out.println("token的返回值：" + tokenResult);
        JSONObject tokenResultJson = JSONObject.parseObject(tokenResult);//转换成json对象
        String uuid = tokenResultJson.getJSONObject("data").getString("uuid");//根据key获取json中的uuid值
        //Map<String,JSONObject> tokenResultMap = (Map)JSONObject.parse(tokenResult);
        //String uuid = tokenResultMap.get("data").get("uuid").toString();
        //密码加密
        String password = encrytSHA256(loginCase.getPassword(),uuid);
        //登录接口参数组装
        JSONObject param = new JSONObject();
        param.put("userName",loginCase.getUserName());
        param.put("password",password);
        //执行登录接口
        System.out.println("登录url====" + TestConfig.loginUrl);
        String result = HttpClientUtil.post(TestConfig.loginUrl,param.toString(),headers);
        return result;
    }
}
