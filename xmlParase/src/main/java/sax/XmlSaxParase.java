package sax;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

/**
 * Created by Administrator on 2017/5/8.
 */
public class XmlSaxParase {

    public void xmlParase(String filePath) {
        try {
            // step 1: ���SAX����������ʵ��
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // step 2: ���SAX������ʵ��
            SAXParser parser = factory.newSAXParser();

            // step 3: ��ʼ���н���
            // ������������ĵ��Ĵ�����
            parser.parse(new File(this.getClass().getResource(filePath).getFile()), new MyHandler());

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class MyHandler extends DefaultHandler {
        // ʹ��ջ������ݽṹ������
        private Stack<String> stack = new Stack<String>();

        // ����
        private String title;
        private String author;
        private String year;
        private double price;

        @Override
        public void startDocument() throws SAXException {
            System.out.println("start document -> parse begin");
        }

        @Override
        public void endDocument() throws SAXException {

            System.out.println("end document -> parse finished");
        }

        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            // System.out.println("start element-----------");
            // System.out.println("    localName: " + localName);
            // System.out.println("    qName: " + qName);

            // ����ǩ��ѹ��ջ
            stack.push(qName);

            // ��������
            for (int i = 0; i < attributes.getLength(); ++i) {
                String attrName = attributes.getQName(i);
                String attrValue = attributes.getValue(i);

                System.out.println("���ԣ� " + attrName + "=" + attrValue);

            }

        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            // System.out.println("characters-----------");
            // System.out.println("    ch: " + Arrays.toString(ch) );
            // System.out.println("    ch: " + ch);
            // System.out.println("    start: " + start);
            // System.out.println("    length: " + length);

            // ȡ����ǩ��
            String tag = stack.peek();

            if ("title".equals(tag)) {
                title = new String(ch, start, length);

            } else if ("author".equals(tag)) {
                author = new String(ch, start, length);
            } else if ("year".equals(tag)) {
                year = new String(ch, start, length);
            } else if ("price".equals(tag)) {
                price = Double.parseDouble(new String(ch, start, length));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // System.out.println("end element-----------");
            //
            // System.out.println("    localName: " + localName);
            // System.out.println("    qName: " + qName);

            stack.pop();// ��ʾ��Ԫ�ؽ�����ϣ���Ҫ��ջ�е�����ǩ

            if ("book".equals(qName)) {
                System.out.println("Book info: -------");
                System.out.println("    title: " + title);
                System.out.println("    author: " + author);
                System.out.println("    year: " + year);
                System.out.println("    price: " + price);
                System.out.println();
            }

        }
    }

}
