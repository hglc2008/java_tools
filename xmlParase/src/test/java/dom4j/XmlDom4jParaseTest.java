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
                "<students><student1 id=\"001\"><微信公众号>@残缺的孤独</微信公众号><学号>20140101</学号><地址>北京海淀区</地址><座右铭>要么强大，要么听话</座右铭><phone>137xxxxxxxx</phone></student1><student2 id=\"002\"><新浪微博>@残缺的孤独</新浪微博><学号>20140102</学号><地址>北京朝阳区</地址><座右铭>在哭泣中学会坚强</座右铭></student2></students>";
        xmlDom4jParase.readXmlByText(text);
    }

}