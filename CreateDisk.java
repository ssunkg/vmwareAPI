import kr.goodmit.clovir.cloud.service.CpInterface;
import kr.goodmit.clovir.cloud.vo.CpResult;
import kr.goodmit.clovir.cloud.vo.VmDiskVo;


public class CreateDisk {
	
	public VmDiskVo getVmDiskVo() {
		VmDiskVo vo = new VmDiskVo();
		vo.setDcName("SACF2ND");
		vo.setDsName("datastore4-2");
		vo.setVmName("w2k8-r2-sklee");
		vo.setSizeMB(1000);
		vo.setDiskName("disk1");	//하드 디스크 2 라고 나옴.....??
		return vo;
	}
	
	public VmDiskVo getVmDiskVo2() {
		VmDiskVo vo = new VmDiskVo();
		vo.setDcName("SACF2ND");
		vo.setDsName("datastore4-2");
		vo.setVmName("w2k8-r2-sklee");
		vo.setSizeMB(2000);
		vo.setDiskName("disk2");
		
		return vo;
	}
	
	

	public static void main(String[] args) {

		CreateDisk vp = new CreateDisk();
		CpResult result = CpInterface.vmCreateDisk(vp.getVmDiskVo());
		if(result.status) {
			System.out.println("result : " + (String)result.value);
		} else {
			System.out.println("fail...");
		}
		
		result = CpInterface.vmCreateDisk(vp.getVmDiskVo2());
		if(result.status) {
			System.out.println("result : " + (String)result.value);
		} else {
			System.out.println("fail...");
		}
	}
}
