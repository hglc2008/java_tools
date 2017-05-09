package velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2017/5/8.
 */
public class TemplateTool {

    /**
     * 填充模板的方法
     * @param context
     * @param tmdir
     * @param tmFile
     * @return
     */
    public static String fill(VelocityContext context, String tmdir, String tmFile) {
        String result = "";
        try {
            Properties p = new Properties();

            p.setProperty("file.resource.loader.path", tmdir);
            VelocityEngine ve = new VelocityEngine();
            ve.init(p);
            Template t = ve.getTemplate(tmFile);
            StringWriter writer = new StringWriter();

            t.merge(context, writer);
            result = writer.toString();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 填充模板的方法
     *
     * @param context
     *            封装的数据
     * @param tmdir
     *            路径
     * @param tmFile
     *            文件名
     * @param inputEncode
     *            入编码
     * @param ouputEncode
     *            出编码
     * @return
     */
    public static String fill(VelocityContext context, String tmdir, String tmFile, String inputEncode, String ouputEncode) {
        String result = "";
        try {
            Properties p = new Properties();

            p.setProperty("file.resource.loader.path", tmdir);
            p.setProperty("ISO-8859-1", "UTF-8");
            p.setProperty("input.encoding", inputEncode);
            p.setProperty("output.encoding", ouputEncode);

            VelocityEngine ve = new VelocityEngine();
            ve.init(p);
            Template t = ve.getTemplate(tmFile);
            StringWriter writer = new StringWriter();

            t.merge(context, writer);
            result = writer.toString();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 封装的内容写入字符串模板中
     *
     * @param context
     * @param templateString
     * @return
     */
    public static String fill(VelocityContext context, String templateString) {
        String result = "";
        try {
            VelocityEngine ve = new VelocityEngine();
            ve.init();
            StringWriter writer = new StringWriter();
            StringReader reader = new StringReader(templateString);
            ve.evaluate(context, writer, "temp", reader);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String test(int i) {
        return "array:" + i;
    }

    /**
     * 测试
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Object> list = new ArrayList<Object>();
        Map<String,String> map = new HashMap<String,String>();
        map.put("name", "Cow");
        map.put("price", "100.00");
        list.add(map);
        map = new HashMap<String,String>();
        map.put("name", "Eagle");
        map.put("price", "59.99");
        list.add(map);
        map = new HashMap<String,String>();
        map.put("name", "Shark");
        map.put("price", "3.99");
        list.add(map);

        VelocityContext context = new VelocityContext();
        context.put("TemplateTool", new TemplateTool());
        context.put("workAddress", list);
        context.put("num", Integer.valueOf(10));
        context.put("name", "SAM-SHO");
        context.put("homeAddress", "苏州高新区");
        context.put("age", "27");

        // 1-写入项目中定义的模板
        String tmdir = TemplateTool.class.getClassLoader().getResource("templete/").getPath();
        String result = fill(context, tmdir, "user-request.xml", "UTF-8", "UTF-8");
        System.out.println("写入工程模板 ：    \r\n" + result);

        // 2-写入字符串模板
        String result2 = fill(context, "${name}，${homeAddress}");
        System.out.println("写入字符串模板:   " + result2);
    }
}
