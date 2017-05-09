package entity;

/**
 * Created by Administrator on 2017/5/8.
 */
public class UserAddress {
    private String homeAddress;//家庭地址
    private String workAddress;//公司地址

    public String getHomeAddress() {
        return homeAddress;
    }
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }


    public String getWorkAddress() {
        return workAddress;
    }
    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }
}
