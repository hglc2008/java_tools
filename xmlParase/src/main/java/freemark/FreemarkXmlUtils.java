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
        // ����ֲ�����
        String templatePath = "/templete/"; // ����ģ��·��
        String requestXml = ""; // ������

        Configuration config = new Configuration();
        try {
            // ��ʽ1 ����·��
            // config.setDirectoryForTemplateLoading(new
            // File("D:/apache-worksapce/MyEclipseNewWork2014/JavaTool/resources/templete"));
            // Template template = config.getTemplate(templateFileName ,"UTF-8");// ����ģ��

            // ��ʽ2 ��� ����classloader
            config.setClassForTemplateLoading(FreemarkXmlUtils.class, "/");
            Template template = config.getTemplate(templatePath + templateFileName, "UTF-8");// ����ģ��

            // ��ʽ3 ��Ҫ servletContext
            // config.setServletContextForTemplateLoading("", "/ftl"); //����/WebRoot/ftlĿ¼��
            // Template template = config.getTemplate(templateFileName ,"UTF-8");// ����ģ��

            // ����ģ�����
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
        // ���ر����ַ���
        return requestXml;
    }
}
