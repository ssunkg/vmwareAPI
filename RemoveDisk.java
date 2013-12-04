import kr.goodmit.clovir.cloud.service.CpInterface;
import kr.goodmit.clovir.cloud.vo.CpResult;


public class RemoveDisk {

	public static void main(String[] args) {

		CpResult result = CpInterface.vmRemoveDisk("SACF2ND", "w2k8-r2-sklee", "하드 디스크 3");
		if(result.status) {
			System.out.println("result : " + (String)result.value);
		} else {
			System.out.println("fail...");
		}
	}
}
