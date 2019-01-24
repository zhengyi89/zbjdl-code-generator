<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ${basepackage}.manager.${className}Manager;
import ${basepackage}.pojo.${className};
import ${basepackage}.pojo.${className}Page;
import ${basepackage}.pojo.${className}Query;

public class ${className}ManagerTest extends BaseJUnit4Test {
	
	@Autowired
	@Qualifier("${classNameLower}Manager")
	private ${className}Manager ${classNameLower}Manager;

	@Test
	public void testQueryPage${className}(){
		${className}Query query = new ${className}Query();
		query.setPageNo(2);
		
		${className}Page result = ${classNameLower}Manager.queryPageList(query);
		
		System.out.println("page no:" + result.getPagenation().getPageNo() + " page size:" + result.getPagenation().getPageSize() + 
				" total:" + result.getPagenation().getItemCount() + " pageCount:" + result.getPagenation().getPageCount());
		
		System.out.println(result.getValues().size());
	}

	public void testNew${className}() {
		${className} ${className} = new ${className}();
//		${className}.setAccountingNo("1111111");
		${classNameLower}Manager.save${className}(${className});
	}


	public void testUpdate${className}(){
		${className} ${className} = new ${className}();
		${className}.setId(2l);
//		${className}.setAccountingNo("222z");
		${classNameLower}Manager.save${className}(${className});
	}
	

	public void testDelete${className}(){
		${classNameLower}Manager.delete${className}ById(99L);
	}
	

	public void testDelete${className}ByQuery(){
		${className}Query query = new ${className}Query();
//		query.setAccountingNo("1111111");
		${classNameLower}Manager.delete${className}(query);
	}


	public void testFind${className}ById(){
		${className}Query query = new ${className}Query();
//		query.setAccountingNo("1111111");
		int size = ${classNameLower}Manager.queryList(query).size();
		System.out.println(size);
	}
}
