package site.dongxiaoxu.sunmall.framework;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dongxu on 2018/8/22.
 */
@MappedSuperclass
public class BaseModel implements Serializable{

    /**
     * <p>Field serialVersionUID: 版本id</p>
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据模型的唯一标识
     */
    @Id
    @Column(name = "PK_ID", columnDefinition = "char(32)")
    @GeneratedValue(generator = "huuid")
    @GenericGenerator(name = "huuid", strategy = "uuid")
    private String id;

    /**
     * 备注
     */
    @Column(name = "REMARK", length = 2000)
    private String remark = null;
    /**
     * 删除标记
     */
    @Column(name = "DEL_FLAG")
    private String delFlag = null;
    /**
     * 创建人
     */
    @Column(name = "CREATE_USER", updatable = false)
    private String createUser = null;

    /**
     * 记录创建时间
     */
    @Column(name = "CREATE_DATE", updatable = false)
    private Date createDate = null;

    /**
     * 更新人
     */
    @Column(name = "UPDATE_USER")
    private String updateUser = null;

    /**
     * 记录更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
            this.updateDate = updateDate;
        }


    }
