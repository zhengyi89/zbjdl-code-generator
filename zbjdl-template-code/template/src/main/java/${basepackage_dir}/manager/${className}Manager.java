<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.manager;

import java.util.List;

import ${basepackage}.model.${className};

public interface ${className}Manager {

	Integer save(${className} ${classNameLower});
	
	Integer update(${className} ${classNameLower});
	
	${className} selectById(Long id);
	
	List<${className}> findList(${className} ${classNameLower});
	
}
