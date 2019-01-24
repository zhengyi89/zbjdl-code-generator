<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.model;

/**
 * ${table.tableAlias}
 * @author code-generator
 *
 */
public class ${className} {
	
	<#list table.columns as column>
	<#if column.columnNameFirstLower == "id">
	private java.lang.Long ${column.columnNameFirstLower};
	<#else>
	private ${column.javaType} ${column.columnNameFirstLower};
	</#if>
	</#list>

	<#list table.columns as column>
	<#if column.columnNameFirstLower == "id">
	/**
	 * @param ${column.columnNameFirstLower}
	 */
	public void set${column.columnName}(Long ${column.columnNameFirstLower}) {
		this.${column.columnNameFirstLower} = ${column.columnNameFirstLower};
	}
	
	/**
	 * @return
	 */
	public Long get${column.columnName}() {
		return this.${column.columnNameFirstLower};
	}
	<#else>
	/**
	 * ${column.remarks}
	 * @param ${column.columnNameFirstLower}
	 */
	public void set${column.columnName}(${column.javaType} ${column.columnNameFirstLower}) {
		this.${column.columnNameFirstLower} = ${column.columnNameFirstLower};
	}
	
	/**
	 * ${column.remarks}
	 * @return
	 */
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameFirstLower};
	}
	</#if>
	</#list>
}