package com.asiainfo.test.domain;

import com.asiainfo.common.annotation.Excel;
import com.asiainfo.common.core.domain.BaseEntity;

import java.io.Serializable;

/**
 * ty_test_t
 * @author 
 */
public class TyTestUser extends BaseEntity {

    @Excel(name = "用户ID")
    private Integer id;

    @Excel(name = "用户名称")
    private String name;

    @Excel(name = "性别",readConverterExp="0=男,1=女,2=未知",prompt="0=男,1=女,2=未知")
    private Integer sex;

    @Excel(name = "年龄")
    private Integer aget;

    @Excel(name = "是否有效",readConverterExp="1=有效,0=无效",prompt = "1=有效,0=无效")
    private Integer ifValid;

    @Excel(name = "备注")
    private String desc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAget() {
        return aget;
    }

    public void setAget(Integer aget) {
        this.aget = aget;
    }

    public Integer getIfValid() {
        return ifValid;
    }

    public void setIfValid(Integer ifValid) {
        this.ifValid = ifValid;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TyTestUser other = (TyTestUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAget() == null ? other.getAget() == null : this.getAget().equals(other.getAget()))
            && (this.getIfValid() == null ? other.getIfValid() == null : this.getIfValid().equals(other.getIfValid()))
            && (this.getDesc() == null ? other.getDesc() == null : this.getDesc().equals(other.getDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAget() == null) ? 0 : getAget().hashCode());
        result = prime * result + ((getIfValid() == null) ? 0 : getIfValid().hashCode());
        result = prime * result + ((getDesc() == null) ? 0 : getDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sex=").append(sex);
        sb.append(", aget=").append(aget);
        sb.append(", ifValid=").append(ifValid);
        sb.append(", desc=").append(desc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}