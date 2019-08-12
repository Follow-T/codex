package com.asiainfo.config.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.asiainfo.common.annotation.Excel;
import com.asiainfo.common.core.domain.BaseEntity;

/**
 * 缴款类型表 AU_BC_PAY_TYPE
 * 
 * @author changtong
 * @date 2019-07-16
 */
public class AuBcPayType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	@Excel(name = "自增ID")
	/** 自增ID */
	private Long id;
	@Excel(name = "缴费方式编码")
	/** 缴费方式编码 */
	private String code;
	@Excel(name = "缴费方式名称 ")
	/** 缴费方式名称 */
	private String name;
	@Excel(name = "稽核周期")
	/** 稽核周期 */
	private Integer period;
	@Excel(name = "备注")
	/** 备注 */
	private String remark;
	@Excel(name = "接口标识")
	/** 接口标识 */
	private String faceflag;
	@Excel(name = "创建人")
	/** 创建人 */
	private Long createby;
	@Excel(name = "创建时间 ")
	/** 创建时间 */
	private Date createtime;
	@Excel(name = "更新人")
	/** 更新人 */
	private Long lastupdateby;
	@Excel(name = "更新时间")
	/** 更新时间 */
	private Date lastupdatetime;
	@Excel(name = "可用状态标识 ")
	/** 可用状态标识 */
	private Integer enable;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}

	public String getCode() 
	{
		return code;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setPeriod(Integer period) 
	{
		this.period = period;
	}

	public Integer getPeriod() 
	{
		return period;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setFaceflag(String faceflag) 
	{
		this.faceflag = faceflag;
	}

	public String getFaceflag() 
	{
		return faceflag;
	}
	public void setCreateby(Long createby) 
	{
		this.createby = createby;
	}

	public Long getCreateby() 
	{
		return createby;
	}
	public void setCreatetime(Date createtime) 
	{
		this.createtime = createtime;
	}

	public Date getCreatetime() 
	{
		return createtime;
	}
	public void setLastupdateby(Long lastupdateby) 
	{
		this.lastupdateby = lastupdateby;
	}

	public Long getLastupdateby() 
	{
		return lastupdateby;
	}
	public void setLastupdatetime(Date lastupdatetime) 
	{
		this.lastupdatetime = lastupdatetime;
	}

	public Date getLastupdatetime() 
	{
		return lastupdatetime;
	}
	public void setEnable(Integer enable) 
	{
		this.enable = enable;
	}

	public Integer getEnable() 
	{
		return enable;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("name", getName())
            .append("period", getPeriod())
            .append("remark", getRemark())
            .append("faceflag", getFaceflag())
            .append("createby", getCreateby())
            .append("createtime", getCreatetime())
            .append("lastupdateby", getLastupdateby())
            .append("lastupdatetime", getLastupdatetime())
            .append("enable", getEnable())
            .toString();
    }
}
