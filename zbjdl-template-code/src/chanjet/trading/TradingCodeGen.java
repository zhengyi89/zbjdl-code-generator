package chanjet.trading;
import java.io.File;

import cn.org.rapid_framework.generator.GeneratorFacade;

public class TradingCodeGen {
	public static void main(String[] args) {
		GeneratorFacade g = new GeneratorFacade();
		g.initOutRoot(System.getProperty("user.dir") + File.separator + "target");
		g.initTemplateRoot(System.getProperty("user.dir") + File.separator + "template");

		try {
//			String[] tables={"asset_class_info","asset_info","assist_account_info","deprecition_detail",
//					"invoice_info","subject_info","system_info","tax_info","voucher_info","voucher_sub_info", "company_info", "currency_info"};
			String[] tables={"asset_info"};
			for(int i=0;i<tables.length;i++){	
			   g.generateByTable(tables[i]);
			}
				System.out.println(System.getProperty("tomcat.catalina")+"4324243234");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
