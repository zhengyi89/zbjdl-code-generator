<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign classNameLowerWithoutInfo = classNameLower?replace('Info','')>
package ${basepackage}.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import ${basepackage}.dto.${className}Dto;
import ${basepackage}.dto.request.${className}SaveReqDto;
import ${basepackage}.service.${className}Service;

/**
 * ${table.tableAlias}Controller
 * 
 * @author code-generator
 * @date ${.now} 
 * 
 */
@Controller
@RequestMapping("${classNameLowerWithoutInfo}")
public class ${className}Controller{
	private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);
	@Autowired
	private ${className}Service ${classNameLower}Service;

	/*
	 * 列表页面
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView ${classNameLower}Index() {
		ModelAndView mav = new ModelAndView("${classNameLowerWithoutInfo}/${classNameLowerWithoutInfo}Index");
		return mav;
	}

	/*
	 * 进入新增页面
	 */
	@RequestMapping(value = "/edit/index", method = RequestMethod.GET)
	public ModelAndView ${classNameLower}EditIndex(Long id) {
		ModelAndView mav = new ModelAndView("${classNameLowerWithoutInfo}/${classNameLowerWithoutInfo}Edit");
		if (id != null) {
			${className}Dto ${classNameLower}Dto = ${classNameLower}Service.selectById(id);
			mav.addObject("dto", ${classNameLower}Dto);
		}
		return mav;
	}

	/*
	 * 编辑保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView ${classNameLower}Save(${className}SaveReqDto ${classNameLower}SaveReqDto) {
		logger.info("save ${className}, param is : {}", JSON.toJSONString(${classNameLower}SaveReqDto));
		${classNameLower}Service.saveOrUpdate(${classNameLower}SaveReqDto);
		ModelAndView mav = new ModelAndView("redirect:/${classNameLowerWithoutInfo}/index");
		return mav;
	}

	/*
	 * 详情展示
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView ${classNameLower}Detail(Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("${classNameLowerWithoutInfo}/${classNameLowerWithoutInfo}Detail");
		${className}Dto ${classNameLower}Dto = ${classNameLower}Service.selectById(id);
		mav.addObject("dto", ${classNameLower}Dto);
		return mav;
	}
	
	/*
	 * 删除
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView ${classNameLower}Delete${className}(Long id) {
		${classNameLower}Service.delete(id);
		ModelAndView mav = new ModelAndView("redirect:/${classNameLower}/index");
		return mav;
	}
	
}
