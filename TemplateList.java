import kr.goodmit.clovir.cloud.service.CpInterface;
import kr.goodmit.clovir.cloud.vo.CpResult;
import kr.goodmit.clovir.cloud.vo.DatacenterNameVo;
import kr.goodmit.clovir.cloud.vo.TemplateNameVo;


public class TemplateList {

	public String[] dataCenterList = null;

	public void getTemplateList() {
		CpResult result = null;
		TemplateNameVo[] vos = null;
		TemplateNameVo vo = null;
		try {
			if(dataCenterList  == null || dataCenterList.length == 0) return;
			for(int i = 0; i < dataCenterList.length; i++) {
				result = CpInterface.templateList(dataCenterList[i]);
				System.out.println("result = " + result.status);
				if(result.status) {
					vos = (TemplateNameVo[])result.value;
					System.out.println("vos = " + vos.length);
					for(int j = 0; j < vos.length; j++) {
						vo = vos[i];
						System.out.println("Template Name : " + vo.getName());
					}
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getDataCenter() {
		CpResult result = null;
		DatacenterNameVo[] vos = null;
		DatacenterNameVo vo = null;
		try {
			result = CpInterface.datacenterList();
			if(result.status) {
				vos = (DatacenterNameVo[])result.value;
				dataCenterList = new String[vos.length];
				for(int i = 0; i < vos.length; i++) {
					vo = vos[i];
					dataCenterList[i] = vo.getName();
					System.out.println("데이터센터 : " + vo.getName());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getTemplateList2() {
		CpResult result = null;
		TemplateNameVo[] vos = null;
		TemplateNameVo vo = null;
		try {
			result = CpInterface.templateList("SACF2ND");
			System.out.println("result = " + result.status);
			if(result.status) {
				vos = (TemplateNameVo[])result.value;
				System.out.println("vos = " + vos.length);
				for(int j = 0; j < vos.length; j++) {
					vo = vos[j];
					System.out.println("Template Name : " + vo.getName());
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TemplateList tl = new TemplateList();
//		tl.getDataCenter();
//		tl.getTemplateList();
		tl.getTemplateList2();
	}

}
