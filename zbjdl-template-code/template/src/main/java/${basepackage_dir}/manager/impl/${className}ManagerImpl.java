<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ${basepackage}.repository.${className}Repository;
import ${basepackage}.manager.${className}Manager;
import ${basepackage}.model.${className};

@Component
public class ${className}ManagerImpl implements ${className}Manager {
	
	@Autowired
	private ${className}Repository ${classNameLower}Repository;
	
	@Override
	public Integer save(${className} ${classNameLower}) {
		return ${classNameLower}Repository.save(${classNameLower});
	}
	
	@Override
	public Integer update(${className} ${classNameLower}) {
		return ${classNameLower}Repository.update(${classNameLower});
	}
	
	@Override
	public ${className} selectById(Long id) {
		return ${classNameLower}Repository.selectById(id);
	}
	
	@Override
	public List<${className}> findList(${className} ${classNameLower}) {
		return ${classNameLower}Repository.findList(${classNameLower});
	}

}

