package entity;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8.
 */
public class UserBean {
    private String name;
    private String key;
    private String age;
    private UserAddress userAddress;//µØÖ·
    private List<UserPhone> phoneList ;//ÊÖ»ú

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public UserAddress getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
    public List<UserPhone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<UserPhone> phoneList) {
        this.phoneList = phoneList;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
