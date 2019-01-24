<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;

import java.util.List;

import ${basepackage}.dto.${className}Dto;

public interface ${className}Service {
	Integer saveOrUpdate(${className}Dto ${classNameLower}SaveReqDto);

	${className}Dto selectById(Long id);
	
	List<${className}Dto> findList(${className}Dto ${classNameLower}Dto);
	
}
