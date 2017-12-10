package com.amall.common.encryption;

import java.util.HashMap;
import java.util.Map;

public class TestKeys {

	public static void main(String[] args) throws Exception {
		
//		String mingwen = "tangxang";
//		String ch = "UTF-8";
//		Algorithm.setKey("tangxang");
//		Algorithm.createKeys();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "tangxang");
		map.put("pwd", "123456");
		map.put("sex", "man");
		map.put("address", "南京市海柏丽一路二号asdasdasdasd1312321dsdfgfdgfdgfdgfdvbcvbvcbdfghgdfgdfgdfg");
		
		/* beging 直接使用RSA加密解密,base64字节对齐加密传输,sha256签名验证  ,bytes长度不能大于117 */
//		String mi = EncryptionTools.onlyRSAEncrypt(map);
//		String ming = null;
//		if(mi != null)
//		{
//			ming = EncryptionTools.onlyRSADecrypt(mi);
//		}
//		System.err.println(ming);
		/* end*/
		
		/* begin 使用完整的加密方式，加解密 ,出现错误都返回null*/
		String mi = EncryptionTools.completeEncrypt(map);
		String ming = EncryptionTools.completeDecrypt(mi);
		System.err.println(ming);
		/* end */
		
		//byte[] mi = Algorithm.encryptByRSAPublicKey(mingwen.getBytes(), Algorithm.readPublicKey());
//		byte[] mi = AlgorithmUtils.encryptByDES(mingwen.getBytes(), AlgorithmUtils.getDesKey());
	
		//byte[] ming = AlgorithmUtils.decryptByRSAPrivateKey(mi, AlgorithmUtils.readPrivateKey());
//		byte[] ming = AlgorithmUtils.decryptByDES(mi, AlgorithmUtils.getDesKey());
//		if(new String(ming, ch).equals(mingwen))
//		{
//			
//		}
		
		//byte[] buffs = Algorithm.signatureSHA2(mingwen.getBytes("UTF-8"));
		//mi = Algorithm.encryptByBase64(mi);
		//System.out.println(mi);
		
		//System.out.println(Algorithm.byteArrayToHEXString(mi));
	}
}
