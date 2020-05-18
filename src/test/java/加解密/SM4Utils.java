package 加解密;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组密码有五种工作体制：
 * 1.电码本模式（Electronic Codebook Book (ECB)）
 * 2.密码分组链接模式（Cipher Block Chaining (CBC)）
 * 3.计算器模式（Counter (CTR)）
 * 4.密码反馈模式（Cipher FeedBack (CFB)）
 * 5.输出反馈模式（Output FeedBack (OFB)）
 * @author 张卫广
 */
@SuppressWarnings("restriction")
public class SM4Utils
{
	//后期这边盐和秘钥均需要换且放入缓存（盐要改）
	private static final String encryptKey="72ApzP8ppkuAylCV";

	private static final String salt = "MmFVyz3Ijar4";
	
	public static String encryptDataForECB(String plainText,String secretKey )
	{
		try 
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_ENCRYPT;

			byte[] keyBytes =secretKey.getBytes();
			SM4 sm4 = new SM4();
			sm4.sm4_setkey_enc(ctx, keyBytes);
			byte[] encrypted = sm4.sm4_crypt_ecb(ctx, plainText.getBytes("GBK"));
			String cipherText = new BASE64Encoder().encode(encrypted);
			if (cipherText != null && cipherText.trim().length() > 0)
			{
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(cipherText);
				cipherText = m.replaceAll("");
			}
			return cipherText;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String decryptDataForECB(String cipherText,String secretKey )
	{
		try
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_DECRYPT;

			byte[] keyBytes = secretKey.getBytes();

			SM4 sm4 = new SM4();
			sm4.sm4_setkey_dec(ctx, keyBytes);
			byte[] decrypted = sm4.sm4_crypt_ecb(ctx, new BASE64Decoder().decodeBuffer(cipherText));
			return new String(decrypted, "GBK");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String encryptDataForCBC(String plainText,String secretKey,String iv )
	{
		try {
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_ENCRYPT;

			byte[] keyBytes= secretKey.getBytes();
			byte[] ivBytes = iv.getBytes();

			SM4 sm4 = new SM4();
			sm4.sm4_setkey_enc(ctx, keyBytes);
			byte[] encrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, plainText.getBytes("GBK"));
			String cipherText = new BASE64Encoder().encode(encrypted);
			if (cipherText != null && cipherText.trim().length() > 0)
			{
				Pattern p = Pattern.compile("\\s*|\t|\r|\n");
				Matcher m = p.matcher(cipherText);
				cipherText = m.replaceAll("");
			}
			return cipherText;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String decryptDataForCBC(String cipherText,String secretKey,String iv )
	{
		try
		{
			SM4_Context ctx = new SM4_Context();
			ctx.isPadding = true;
			ctx.mode = SM4.SM4_DECRYPT;

			byte[] keyBytes = secretKey.getBytes() ;
			byte[] ivBytes = iv.getBytes();

			SM4 sm4 = new SM4();
			sm4.sm4_setkey_dec(ctx, keyBytes);
			byte[] decrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, new BASE64Decoder().decodeBuffer(cipherText));
			return new String(decrypted, "GBK");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static String encryptData(String data){
		if (StringUtils.isEmpty(data)){
			return null;
		}
		String randomString = salt;
		String dataForECB = SM4Utils.encryptDataForECB(data + randomString, encryptKey);
		return dataForECB;
	}

	public static String decryptData(String data){
		if (StringUtils.isEmpty(data)){
			return null;
		}
		String decryptStr = SM4Utils.decryptDataForECB(data,encryptKey);
		decryptStr=decryptStr.substring(0,decryptStr.length()-salt.length());
		return decryptStr;
	}
	
	
	
	public static void main(String[] args) throws IOException 
	{
		String plainText1 = "GV3TBrqBRt7aeZLQIMfjVJwRQ7y5ZwLApAOlryC+2D4=";

		String plainText = "“3·23”运动";
		System.out.println("ECB模式");
		String cipherText = SM4Utils.encryptData(plainText);
		System.out.println("密文: " + cipherText+"  \n长度为"+cipherText.length());

		System.out.println("明文:"+decryptData(plainText1) +",长度为"+decryptData(plainText1).length());


	}
}
