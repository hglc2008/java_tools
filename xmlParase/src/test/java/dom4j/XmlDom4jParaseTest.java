package dom4j;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/5/8.
 */
public class XmlDom4jParaseTest {
    private  XmlDom4jParase xmlDom4jParase;
    @Before
    public void setUp() throws Exception {
        xmlDom4jParase = new XmlDom4jParase();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readXmlByFile() throws Exception {
        xmlDom4jParase.readXmlByFile("/students.xml");
    }

    @Test
    public void readXmlByText() throws  Exception{
        String text = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>  \n" +
                "<students><student1 id=\"001\"><΢�Ź��ں�>@��ȱ�Ĺ¶�</΢�Ź��ں�><ѧ��>20140101</ѧ��><��ַ>����������</��ַ><������>Ҫôǿ��Ҫô����</������><phone>137xxxxxxxx</phone></student1><student2 id=\"002\"><����΢��>@��ȱ�Ĺ¶�</����΢��><ѧ��>20140102</ѧ��><��ַ>����������</��ַ><������>�ڿ�����ѧ���ǿ</������></student2></students>";
        xmlDom4jParase.readXmlByText(text);
    }

}