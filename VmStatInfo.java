import kr.goodmit.clovir.cloud.service.CpInterface;
import kr.goodmit.clovir.cloud.vo.CpResult;
import kr.goodmit.clovir.cloud.vo.VmVo;


public class VmStatInfo {
	
	public static void main(String[] args) {

		CpResult result = CpInterface.vmStat("SACF2ND", "w2k8-r2-sklee");
		if(result.status) {
			VmVo vo = (VmVo) result.value;
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("클러스터 아이디 : " + vo.getClusterId());
			System.out.println("클러스터명 : " + vo.getClusterName());
			System.out.println("CPU 갯수 : " + vo.getCpu());
			System.out.println("CPU 속도 : " + vo.getCpuCapacity());
			System.out.println("CPU 사용량 : " + vo.getCpuUsage());
			System.out.println("디스크사용량 : " + vo.getFileSize());
			System.out.println("VM에 설치된 OS : " + vo.getGuestOS());
			System.out.println("VM이 속한 호스트 아이디 : " + vo.getHostId());
			System.out.println("VM이 속한 호스트 : " + vo.getHostName());
			System.out.println("VM 아이피 : " + vo.getIpAddress());
			System.out.println("메모리 전체용량 : " + vo.getMemory());
			System.out.println("메모리 사용량 : " + vo.getMemUsage());
			System.out.println("VM에 할당된 디스크용량 : " + vo.getProvisionedStorage());
			System.out.println("VM 전원상태 : " + vo.getState());
			System.out.println("VM의 스토리지사용량 : " + vo.getStorageUsage());
			System.out.println("vmware tools 상태 : " + vo.getToolsState());
			System.out.println("vmware tools 버전 : " + vo.getToolsVersion());
			System.out.println("VM uuid : " + vo.getUuid());
			System.out.println("VM 아이디 : " + vo.getVmId());
			System.out.println("VM 이름 : " + vo.getVmName());
			System.out.println("VM 경로 : " + vo.getVmPath());
			System.out.println("VM 버전 : " + vo.getVmVersion());
		} else {
			System.out.println("fail...");
		}
	}

}
