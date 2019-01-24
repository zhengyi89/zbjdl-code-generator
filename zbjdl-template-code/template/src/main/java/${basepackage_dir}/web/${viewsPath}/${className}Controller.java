<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.web.params;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zbjdl.ops.manager.${className}Manager;
import com.zbjdl.ops.pojo.${className};
import com.zbjdl.ops.pojo.${className}Page;
import com.zbjdl.ops.pojo.${className}Query;

@Controller
@RequestMapping("/${controlPath}")
public class ${className}Controller {
	@Autowired
	private ${className}Manager ${classNameLower}Manager;
	
	private static final Logger logger = LoggerFactory.getLogger(${className}Controller.class);
	/**
	 * 列表页面
	 */
	@RequestMapping(value = "/${classNameLower}Index", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView ${classNameLower}Index(@ModelAttribute ${className}Query query,
			@RequestParam(required = false, value = "pageNo", defaultValue = "1") int pageNo,
			@RequestParam(required = false, value = "pageSize", defaultValue = "10") int pageSize) {
		ModelAndView mav = new ModelAndView("params/${className}Index");
		query.setPageNo(pageNo);
		query.setPageSize(pageSize);
		
		${className}Page result = ${classNameLower}Manager.queryPageList(query);
		
		mav.addObject("query", query);
		mav.addObject("pagenation",result.getPagenation());
		mav.addObject("pageInfos",result.getValues());
		
		return mav;
	}
	
	/**
	 * 跳转到详情页
	 */
	@RequestMapping(value = "/to${className}Detail", method = RequestMethod.GET)
	public ModelAndView to${className}Detail(@RequestParam(required = true, value = "id") Long id) {
		ModelAndView mav = new ModelAndView("params/${className}Detail");
		${className} pageInfo = ${classNameLower}Manager.find${className}ById(id);
		mav.addObject("pageInfo", pageInfo);
		
		return mav;
	}
	
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping(value = "/to${className}Add", method = RequestMethod.GET)
	public String to${className}Add() {
		return "params/${className}Add";
	}
	
	/**
	 * 跳转到编辑页面
	 */
	@RequestMapping(value = "/to${className}Edit", method = RequestMethod.GET)
	public ModelAndView to${className}Edit(@RequestParam(required = true, value = "id") Long id) {
		ModelAndView mav = new ModelAndView("params/${className}Edit");
		${className} pageInfo = ${classNameLower}Manager.find${className}ById(id);
		mav.addObject("pageInfo", pageInfo);
		
		
		return mav;
	}
	
	/**
	 * 保存数据
	 */
	@RequestMapping(value = "/save${className}", method = { RequestMethod.POST })
	public ModelAndView save${className}(@ModelAttribute ${className} ${classNameLower}, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("redirect:/params/${classNameLower}Index");
		
		try {
			${classNameLower}Manager.save${className}(${classNameLower});
			redirectAttributes.addFlashAttribute("message", "保存成功!");
		} catch (Exception e) {
			//记录错误日志
			logger.error("", e);
			
			if(${classNameLower}.getId() == null){
				mav.setViewName("params/${className}Add");
			}else{
				mav.addObject("pageInfo", ${classNameLower});
				mav.setViewName("params/${className}Edit");
			}
			
			redirectAttributes.addFlashAttribute("message", "保存失败:" + e.getMessage());
		}
		
		return mav;
	}
	
	/**
	 * 删除数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete${className}", method = RequestMethod.GET)
	public ModelAndView delete${className}(@RequestParam(required = true, value = "id") Long id, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("redirect:/params/${classNameLower}Index");
		
		try {
			${classNameLower}Manager.delete${className}ById(id);
		} catch (Exception e) {
			//记录错误日志
			logger.error("", e);
			redirectAttributes.addFlashAttribute("message", "发生错误:" + e.getMessage());
		}
		
		return mav;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
		binder.registerCustomEditor(String.class, new StringEditor());
		binder.registerCustomEditor(Integer.class, new IntegerEditor());
		binder.registerCustomEditor(Long.class, new LongEditor());
		binder.registerCustomEditor(Float.class, new FloatEditor());
		binder.registerCustomEditor(Double.class, new DoubleEditor());
		binder.registerCustomEditor(BigDecimal.class, new BigDecimalEditor());
	}
	
	class DateEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					setValue(dateFormat.parse(text));
				} catch (ParseException e) {
					setValue(null);
				}
			} else {
				setValue(null);
			}
		}
	}
	
	class StringEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(text);
			} else {
				setValue(null);
			}
		}
	}
	
	class IntegerEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Integer.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class LongEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Long.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class FloatEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Float.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class DoubleEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Double.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class BigDecimalEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(BigDecimal.valueOf(Double.valueOf(text)));
			} else {
				setValue(null);
			}
		}
	}
}
