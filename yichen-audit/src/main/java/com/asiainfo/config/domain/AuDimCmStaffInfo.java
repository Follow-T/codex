package com.asiainfo.config.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.asiainfo.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 客户表 AU_DIM_CM_STAFF_INFO
 * 
 * @author changtong
 * @date 2019-07-18
 */
public class AuDimCmStaffInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 系统ID */
	private Long id;
	/** 客户经理ID */
	private String staffid;
	/** 客户经理姓名 */
	private String staffname;
	/** 客户经理编码 */
	private String staffcode;
	/** CRM系统编号 */
	private String crmstfid;
	/** 所属机构名称 */
	private String regionname;
	/** 所属机构编码 */
	private String regionid;
	/** 系统状态 */
	private String state;
	/** 创建人 */
	private Long createby;
	/** 创建时间 */
	private Date createtime;
	/** 更新人 */
	private Long lastupdateby;
	/** 更新时间 */
	private Date lastupdatetime;
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
	public void setStaffid(String staffid) 
	{
		this.staffid = staffid;
	}

	public String getStaffid() 
	{
		return staffid;
	}
	public void setStaffname(String staffname) 
	{
		this.staffname = staffname;
	}

	public String getStaffname() 
	{
		return staffname;
	}
	public void setStaffcode(String staffcode) 
	{
		this.staffcode = staffcode;
	}

	public String getStaffcode() 
	{
		return staffcode;
	}
	public void setCrmstfid(String crmstfid) 
	{
		this.crmstfid = crmstfid;
	}

	public String getCrmstfid() 
	{
		return crmstfid;
	}
	public void setRegionname(String regionname) 
	{
		this.regionname = regionname;
	}

	public String getRegionname() 
	{
		return regionname;
	}
	public void setRegionid(String regionid) 
	{
		this.regionid = regionid;
	}

	public String getRegionid() 
	{
		return regionid;
	}
	public void setState(String state) 
	{
		this.state = state;
	}

	public String getState() 
	{
		return state;
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
            .append("staffid", getStaffid())
            .append("staffname", getStaffname())
            .append("staffcode", getStaffcode())
            .append("crmstfid", getCrmstfid())
            .append("regionname", getRegionname())
            .append("regionid", getRegionid())
            .append("state", getState())
            .append("createby", getCreateby())
            .append("createtime", getCreatetime())
            .append("lastupdateby", getLastupdateby())
            .append("lastupdatetime", getLastupdatetime())
            .append("enable", getEnable())
            .toString();
    }
}
