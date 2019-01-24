<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbjdl.common.utils.BeanUtils;

import ${basepackage}.manager.${className}Manager;
import ${basepackage}.service.${className}Service;
import ${basepackage}.model.${className};
import ${basepackage}.dto.${className}Dto;

@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service {
	
	@Autowired
	private ${className}Manager ${classNameLower}Manager;
	
	@Override
	public Integer saveOrUpdate(${className}Dto ${classNameLower}Dto) {
		if (${classNameLower}SaveReqDto.getId()!=null) {
			${className} ${classNameLower} = ${classNameLower}Manager.selectById(${classNameLower}SaveReqDto.getId());
			BeanUtils.copyProperties(${classNameLower}SaveReqDto, ${classNameLower});
			return ${classNameLower}Manager.update(${classNameLower});
		}else {
			${className} ${classNameLower} = new ${className}();
			BeanUtils.copyProperties(${classNameLower}SaveReqDto, ${classNameLower});
			return ${classNameLower}Manager.save(${classNameLower});
		}
	}
	
	@Override
	public ${className}Dto selectById(Long id) {
		${className} ${classNameLower} = ${classNameLower}Manager.selectById(id);
		${className}Dto ${classNameLower}Dto = new ${className}Dto();
		BeanUtils.copyProperties(${classNameLower}, ${classNameLower}Dto);
		return ${classNameLower}Dto;
	}
	
	@Override
	public List<${className}Dto> findList(${className}Dto ${classNameLower}Dto) {
		${className} ${classNameLower} = new ${className}();
		BeanUtils.copyProperties(${classNameLower}Dto, ${classNameLower});
		List<${className}> ${classNameLower}List = ${classNameLower}Manager.findList(${classNameLower});
		
		List<${className}Dto> ${classNameLower}DtoList = new ArrayList<${className}Dto>();
		for(${className} dto : ${classNameLower}List){
			${className}Dto respDto = new ${className}Dto();
			BeanUtils.copyProperties(dto, respDto);
			${classNameLower}DtoList.add(respDto);
		}
		return ${classNameLower}DtoList;
	}
	
}

