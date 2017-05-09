package dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 * 见http://blog.csdn.net/yyywyr/article/details/38359049#
 */
public class XmlDom4jParase {

    /**
     * 读取XML文本内容获取Document对象
     * @param text
     */
    public void readXmlByText(String text){
        try {
            //读取文本 转换成Document
            Document document = DocumentHelper.parseText(text);
            //获取根节点元素对象
            Element root = document.getRootElement();
            //遍历节点
            listNodes(root);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取XML文件获取Document对象
     *
     * @param filePath
     */
    public void readXmlByFile(String filePath) {
        try {
            //创建SAXReader对象
            SAXReader reader = new SAXReader();
            //读取文件 转换成Document
            Document document = reader.read(this.getClass().getResource(filePath).getFile());
            //获取根节点元素对象
            Element root = document.getRootElement();
            //遍历节点
            listNodes(root);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    //遍历当前节点下的所有节点
    public void listNodes(Element node) {
        System.out.println("当前节点的名称：" + node.getName());
        //首先获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();
        //遍历属性节点
        for(Attribute attribute : list){
            System.out.println("属性"+attribute.getName() +":" + attribute.getValue());
        }
        //如果当前节点内容不为空，则输出
        if(!(node.getTextTrim().equals(""))){
            System.out.println( node.getName() + "：" + node.getText());
        }
        //同时迭代当前节点下面的所有子节点
        //使用递归
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            listNodes(e);
        }
    }
}
