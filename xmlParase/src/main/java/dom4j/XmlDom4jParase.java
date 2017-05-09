package dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 * ��http://blog.csdn.net/yyywyr/article/details/38359049#
 */
public class XmlDom4jParase {

    /**
     * ��ȡXML�ı����ݻ�ȡDocument����
     * @param text
     */
    public void readXmlByText(String text){
        try {
            //��ȡ�ı� ת����Document
            Document document = DocumentHelper.parseText(text);
            //��ȡ���ڵ�Ԫ�ض���
            Element root = document.getRootElement();
            //�����ڵ�
            listNodes(root);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡXML�ļ���ȡDocument����
     *
     * @param filePath
     */
    public void readXmlByFile(String filePath) {
        try {
            //����SAXReader����
            SAXReader reader = new SAXReader();
            //��ȡ�ļ� ת����Document
            Document document = reader.read(this.getClass().getResource(filePath).getFile());
            //��ȡ���ڵ�Ԫ�ض���
            Element root = document.getRootElement();
            //�����ڵ�
            listNodes(root);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    //������ǰ�ڵ��µ����нڵ�
    public void listNodes(Element node) {
        System.out.println("��ǰ�ڵ�����ƣ�" + node.getName());
        //���Ȼ�ȡ��ǰ�ڵ���������Խڵ�
        List<Attribute> list = node.attributes();
        //�������Խڵ�
        for(Attribute attribute : list){
            System.out.println("����"+attribute.getName() +":" + attribute.getValue());
        }
        //�����ǰ�ڵ����ݲ�Ϊ�գ������
        if(!(node.getTextTrim().equals(""))){
            System.out.println( node.getName() + "��" + node.getText());
        }
        //ͬʱ������ǰ�ڵ�����������ӽڵ�
        //ʹ�õݹ�
        Iterator<Element> iterator = node.elementIterator();
        while(iterator.hasNext()){
            Element e = iterator.next();
            listNodes(e);
        }
    }
}
