package sax;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/5/8.
 */
public class XmlSaxParaseTest {

    private XmlSaxParase xmlSaxParase;

    @Before
    public void setUp() throws Exception {
        xmlSaxParase =  new XmlSaxParase();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void xmlParase() throws Exception {
        xmlSaxParase.xmlParase("/books.xml");
    }

}