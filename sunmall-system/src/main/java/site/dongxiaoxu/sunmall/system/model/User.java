package site.dongxiaoxu.sunmall.system.model;

import site.dongxiaoxu.sunmall.framework.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by dongxu on 2018/8/22.
 */
@Entity
@Table(name = "sys_user")
public class User extends BaseModel {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
