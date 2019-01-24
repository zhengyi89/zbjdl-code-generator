<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.repository;

import com.zbjdl.common.respository.mybatis.GenericRepository;
import org.springframework.stereotype.Repository;

/**
 * ${table.tableAlias}
 * @author code-generator
 *
 */
@Repository
public interface ${className}Repository extends GenericRepository {
	
}