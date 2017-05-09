package freemark;

import entity.UserBean;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/8.
 */
public class FreemarkXmlUtils {

    public static String getXmlStrByFile(String templateFileName, UserBean tUserBean){
        // 定义局部变量
        String templatePath = "/templete/"; // 报文模板路径
        String requestXml = ""; // 请求报文

        Configuration config = new Configuration();
        try {
            // 方式1 绝对路径
            // config.setDirectoryForTemplateLoading(new
            // File("D:/apache-worksapce/MyEclipseNewWork2014/JavaTool/resources/templete"));
            // Template template = config.getTemplate(templateFileName ,"UTF-8");// 报文模板

            // 方式2 最常用 利用classloader
            config.setClassForTemplateLoading(FreemarkXmlUtils.class, "/");
            Template template = config.getTemplate(templatePath + templateFileName, "UTF-8");// 报文模板

            // 方式3 需要 servletContext
            // config.setServletContextForTemplateLoading("", "/ftl"); //就是/WebRoot/ftl目录。
            // Template template = config.getTemplate(templateFileName ,"UTF-8");// 报文模板

            // 设置模板参数
            Map<String, Object> content = new HashMap<String, Object>();

            content.put("name", tUserBean.getName());
            content.put("age", tUserBean.getAge());
            content.put("num1", tUserBean.getPhoneList().get(0).getNum());
            content.put("num2", tUserBean.getPhoneList().get(1).getNum());
            content.put("type1", tUserBean.getPhoneList().get(0).getType());
            content.put("type2", tUserBean.getPhoneList().get(1).getType());
            content.put("homeAddress", tUserBean.getUserAddress().getHomeAddress());
            content.put("workAddress", tUserBean.getUserAddress().getWorkAddress());

            requestXml = FreeMarkerTemplateUtils.processTemplateIntoString(template, content);

            if (requestXml == null || "".equals(requestXml)) {
                return null;
            }

        }catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        // 返回报文字符串
        return requestXml;
    }
}
