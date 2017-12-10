package com.amall.common.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;

/**
 * @author tangxiang
 *
 */
public class Algorithm
{

	/**
	 * RSA public key file path
	 */
	private static String publickeyFilePath;

	/**
	 * RSA private key file path
	 */
	private static String privateKeyFilePath;
	
	
	private static RSAPublicKey publicKey;
	
	private static RSAPrivateKey privateKey;

	/**
	 * RSA arithmetic
	 */
	public static final String ALGORITHM_RSA = "RSA";

	/**
	 * AES arithmetic
	 */
	public static final String ALGORITHM_AES = "AES";

	/**
	 * ECB
	 */
	private static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";
	
	/**
	 * RSA with MD5 sign
	 */
	public static final String ALGORITHM_RSA_MD5 = "MD5withRSA";  

	/**
	 * SHA2 arithmetic
	 */
	public static final String ALGORITHM_SHA2 = "SHA-256";

	/**
	 * SHA2 arithmetic
	 */
	public static final String ALGORITHM_SHA1 = "SHA";

	/**
	 * MD5 arithmetic
	 */
	public static final String ALGORITHM_MD5 = "MD5";

	/**
	 * SHA2 arithmetic
	 */
	private static final String ALGORITHM_SHA1_PRNG = "SHA1PRNG";

	static final int KEY_SIZE_2048 = 2048;

	static final int KEY_SIZE_1024 = 1024;

	static final int KEY_SIZE_512 = 512;

	public static Key aesKey;

	public static Key getAesKey()
	{
		return aesKey;
	}

	public static void setAesKey(Key aesKey)
	{
		Algorithm.aesKey = aesKey;
	}

	static
	{
		Properties prop = new Properties();

		try
		{
			prop.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("properties/cert_secret.properties"));
			publickeyFilePath = prop.getProperty("RSAPublicCert");
			privateKeyFilePath = prop.getProperty("RSAPrivateCert");

			ObjectInputStream ois;
			try
			{
				ois = new ObjectInputStream(new FileInputStream(publickeyFilePath));
				publicKey = ((RSAPublicKey) ois.readObject());
				ois.close();
				
				ois = new ObjectInputStream(new FileInputStream(privateKeyFilePath));
				privateKey = (RSAPrivateKey) ois.readObject();
				ois.close();
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			

		} catch (IOException e)
		{
			e.getStackTrace();
		}
	}

	public static void setKey(String key)
	{
		try
		{
			KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM_AES);
			SecureRandom secureRandom = SecureRandom.getInstance(ALGORITHM_SHA1_PRNG);
			secureRandom.setSeed(key.getBytes());
			keyGenerator.init(secureRandom);
			setAesKey(keyGenerator.generateKey());
			keyGenerator = null;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * RSA key pair generate
	 * 
	 * @return
	 * @throws Exception
	 * @throws NoSuchAlgorithmException
	 */
	public static void createKeys()
	{
		KeyPairGenerator keyPairGen;
		try
		{
			keyPairGen = KeyPairGenerator.getInstance(ALGORITHM_RSA);

			// key size
			keyPairGen.initialize(KEY_SIZE_1024);

			// key pair generate
			KeyPair keyPair = keyPairGen.generateKeyPair();

			// private key generate
			RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

			// public key generate
			RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

			File privatekeyfile = new File(privateKeyFilePath);
			File publickeyfile = new File(publickeyFilePath);

			if (!privatekeyfile.exists())
			{
				privatekeyfile.createNewFile();
			}
			if (!publickeyfile.exists())
			{
				publickeyfile.createNewFile();
			}

			// save files
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(privatekeyfile));
			oos.writeObject(privateKey);
			oos.flush();
			oos.close();

			oos = new ObjectOutputStream(new FileOutputStream(publickeyfile));
			oos.writeObject(publicKey);
			oos.flush();
			oos.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * public key encrypt
	 * 
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByRSAPublicKey(byte[] data)
	{
		Cipher cipher;
		byte[] resultBytes = null;
		try
		{
			cipher = Cipher.getInstance(ALGORITHM_RSA);
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			resultBytes = cipher.doFinal(data);
		} catch (Exception e)
		{
			e.printStackTrace();
			resultBytes = null;
		}

		return resultBytes;
	}

	/**
	 * private decrypt
	 * 
	 * @param data
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByRSAPrivateKey(byte[] data)
	{
		Cipher cipher;
		byte[] resultBytes = null;
		try
		{
			cipher = Cipher.getInstance(ALGORITHM_RSA);
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			resultBytes = cipher.doFinal(data);
		} catch (Exception e)
		{
			e.printStackTrace();
			resultBytes = null;
		}

		return resultBytes;
	}

	/**
	 * AES encrypt
	 * 
	 * @param data
	 * @param publicKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByAES(byte[] data, Key key)
	{
		Cipher cipher;
		byte[] resultBytes = null;
		try
		{
			cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
			resultBytes = cipher.doFinal(data);
		} catch (Exception e)
		{
			e.printStackTrace();
			resultBytes = null;
		}

		return resultBytes;
	}

	/**
	 * AES decrypt
	 * 
	 * @param data
	 * @param privateKey
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptByAES(byte[] data, Key key)
	{
		Cipher cipher;
		byte[] resultBytes = null;
		try
		{
			cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			resultBytes = cipher.doFinal(data);
			return resultBytes;
		} catch (Exception e)
		{
			e.printStackTrace();
			resultBytes = null;
		}

		return resultBytes;
	}


	/**
	 * SHA2 signing messages
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] signatureSHA2(byte[] data)
	{
		byte[] buff = null;
		try
		{
			MessageDigest sha2 = MessageDigest.getInstance(ALGORITHM_SHA2);
			buff = sha2.digest(data);
		} catch (Exception e)
		{
			e.printStackTrace();
			buff = null;
		}
		return buff;
	}

	/**
	 * SHA1 signing messages
	 * 
	 * @param data
	 * @return
	 */
	public static byte[] signatureSHA1(byte[] data)
	{
		byte[] buff = null;
		try
		{
			MessageDigest sha1 = MessageDigest.getInstance(ALGORITHM_SHA1);
			buff = sha1.digest(data);
		} catch (Exception e)
		{
			e.printStackTrace();
			buff = null;
		}
		return buff;
	}

	public static byte[] signatureMD5(byte[] data)
	{
		byte[] buff = null;
		try
		{
			MessageDigest md5 = MessageDigest.getInstance(ALGORITHM_MD5);
			buff = md5.digest(data);
		} catch (Exception e)
		{
			e.printStackTrace();
			buff = null;
		}
		return buff;
	}

	public static boolean rsaPublicVerify(byte[] data, byte[] sign)
	{
		Signature signature;
		try
		{
			signature = Signature.getInstance(ALGORITHM_RSA_MD5);
			signature.initVerify(publicKey);
			signature.update(data);
			return signature.verify(sign);
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}catch (SignatureException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	public static byte[] signatureRSAPrivate(byte[] data)
	{
		Signature signature;
		try
		{
			signature = Signature.getInstance(ALGORITHM_RSA_MD5);
			signature.initSign(privateKey);
			signature.update(data);
			return signature.sign();
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}catch (InvalidKeyException e)
		{
			e.printStackTrace();
		}catch (SignatureException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * @Title: encryptByBase64
	 * @Description: Base64 encrypt
	 * @param buff
	 * @return
	 * @return byte[]
	 * @author tangxiang
	 * @date 2015年8月25日 下午7:35:22
	 */
	public static byte[] encryptByBase64(byte[] buff)
	{
		return Base64.encodeBase64(buff);
	}

	/**
	 * @Title: decryptByBase64
	 * @Description: Base64 decrypt
	 * @param buff
	 * @return
	 * @return byte[]
	 * @author tangxiang
	 * @date 2015年8月25日 下午7:35:02
	 */
	public static byte[] decryptByBase64(byte[] buff)
	{
		return Base64.decodeBase64(buff);
	}

	/**
	 * @Title: byteArrayToString
	 * @Description: byte[] to HEX string
	 * @param buffs
	 * @return
	 * @return String
	 * @author tangxiang
	 * @date 2015年8月25日 下午2:26:56
	 */
	public static String byteArrayToHEXString(byte[] buffs)
	{
		StringBuffer buffer = new StringBuffer();
		for (byte buff : buffs)
		{
			int v = buff & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2)
			{
				buffer.append(0);
			}
			buffer.append(hv);
		}

		return buffer.toString();
	}

	/**
	 * @Title: hexStringToBytes
	 * @Description: HEX String to byte[]
	 * @param hexString
	 * @return
	 * @return byte[]
	 * @author tangxiang
	 * @date 2015年8月25日 下午8:11:08
	 */
	public static byte[] hexStringToBytes(String hexString)
	{
		if (hexString == null || hexString.equals(""))
		{
			return null;
		}
		hexString = hexString.toUpperCase();
		int length = hexString.length() >> 1;
		char[] hexChars = hexString.toCharArray();
		byte[] d = new byte[length];
		for (int i = 0; i < length; i++)
		{
			int pos = i << 1;
			d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
		}
		return d;
	}
	
	

	public static RSAPublicKey getPublicKey()
	{
		return publicKey;
	}

	public static RSAPrivateKey getPrivateKey()
	{
		return privateKey;
	}

	/**
	 * @Title: charToByte
	 * @Description:
	 * @param c
	 * @return
	 * @return byte
	 * @author tangxiang
	 * @date 2015年8月25日 下午8:10:57
	 */
	private static byte charToByte(char c)
	{
		return (byte) "0123456789ABCDEF".indexOf(c);
	}

}
