package com.asiainfo.config.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.asiainfo.common.core.domain.BaseEntity;

/**
 * 长短款配置说明表 AU_CONFIG_LONG
 * 
 * @author genghz
 * @date 2019-07-16
 */
public class AuConfigLong extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String costType;
	/**  */
	private String costValue;
	/**  */
	private String isValid;

	public void setCostType(String costType) 
	{
		this.costType = costType;
	}

	public String getCostType() 
	{
		return costType;
	}
	public void setCostValue(String costValue) 
	{
		this.costValue = costValue;
	}

	public String getCostValue() 
	{
		return costValue;
	}
	public void setIsValid(String isValid) 
	{
		this.isValid = isValid;
	}

	public String getIsValid() 
	{
		return isValid;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("costType", getCostType())
            .append("costValue", getCostValue())
            .append("isValid", getIsValid())
            .toString();
    }
}
