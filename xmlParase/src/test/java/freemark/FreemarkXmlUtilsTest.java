package freemark;

import entity.UserAddress;
import entity.UserBean;
import entity.UserPhone;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/5/8.
 */
public class FreemarkXmlUtilsTest {
    @Test
    public void getXmlStrByFile() throws Exception {
        UserBean tUserBean = new UserBean();
        tUserBean.setName("SAM-SHO");
        tUserBean.setAge("27");
        tUserBean.setKey("����111");

        UserAddress tUserAddress = new UserAddress();
        tUserAddress.setWorkAddress("����԰��");
        tUserAddress.setHomeAddress("���ݸ�����");
        tUserBean.setUserAddress(tUserAddress);

        List<UserPhone> phoneList = new ArrayList<UserPhone>();
        UserPhone tUserPhone = new UserPhone();
        tUserPhone.setType("�ƶ�");
        tUserPhone.setNum("13612345678");
        phoneList.add(tUserPhone);

        tUserPhone = new UserPhone();
        tUserPhone.setType("��ͨ");
        tUserPhone.setNum("13798765432");
        phoneList.add(tUserPhone);
        tUserBean.setPhoneList(phoneList);
        // 1- FreeMarker
        String tRequestXml =FreemarkXmlUtils.getXmlStrByFile("user-request.xml",tUserBean);
        System.out.println(tRequestXml);
    }

}