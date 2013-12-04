import kr.goodmit.clovir.cloud.service.CpInterface;
import kr.goodmit.clovir.cloud.vo.CpResult;
import kr.goodmit.clovir.cloud.vo.ProvisioningVo;
import kr.goodmit.clovir.cloud.vo.VmProvNicVo;


public class VmProvisioning {
	
	public VmProvNicVo[] setNicCard() {
		//Network1
		VmProvNicVo nic1Vo = new VmProvNicVo();
		//nic1Vo.setNetwork("Network Label VM Networks");
		nic1Vo.setNetwork("VM Network");
		nic1Vo.setIp("192.168.1.41");
		nic1Vo.setSubnet("255.255.255.0");
		nic1Vo.setGateway("192.168.1.1");
		nic1Vo.setDns(new String[]{"168.126.63.1"});
		nic1Vo.setNicName("NIC1");	//네트워크 어댑터 1
		nic1Vo.setAdapter("VMXNET3");

		//Network2		
		VmProvNicVo nic2Vo = new VmProvNicVo();
		//nic2Vo.setNetwork("Network Label VM Networks");
		nic2Vo.setNetwork("VM Network");
		nic2Vo.setNicName("NIC2");
		nic2Vo.setAdapter("VMXNET3");
		nic2Vo.setConnected(true);
		
		return new VmProvNicVo[]{nic1Vo, nic2Vo};	//nic 두개 안됨...오류발생...
	}
	
	public ProvisioningVo runProvisioning() {
		ProvisioningVo vo = new ProvisioningVo();
		vo.setClusterName("SCAF");
		vo.setDcName("SACF2ND");
		vo.setTempName("windows2008R2-template");
		vo.setHostName("192.168.1.14");
		vo.setVmName("w2k8-r2-sklee");
		vo.setVmProvNics(setNicCard());
		vo.setDsName("datastore4-2");
		vo.setCpuCores(1);
		vo.setMemSize(20000);
		vo.setVmHostName("SKLEE");
		return vo;
	}

	public static void main(String[] args) {
		
		VmProvisioning vp = new VmProvisioning();
		CpResult result = CpInterface.provisioning(vp.runProvisioning()); 
		if(result.status) {
			System.out.println("result : " + (String)result.value);
		} else {
			System.out.println("fail...");
		}
	}

}
