package com.amall.core.web.pay.alipay;

public class AlipayConfig {
	public static String partner = "2088011189174563";

	public static String key = "eakiobldoyhk3sw214bulh24el3mjkc7";

	public static String seller_email = "1482514917@qq.com";

	private String notify_url = "";

	private String return_url = "";

	public static String log_path = "/www/data/logs/";

	public static String input_charset = "utf-8";

	public static String sign_type = "MD5";

	private String transport = "http";
	
	// 商家私钥
    public static String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK6F+9lxYnD32bzZxtbnWFPEmP6eIGpjS+IDCWde2QJaMzs3KicANwaALaxPIxk8Qz8nKx+ypPJdlb9pfStKyh7TDG3QZ1ynoh7+VaDmF+cAECG67Bu/zLR5YvrVqWxMmqQQFUFFj08UJm2rl/bk6LqY/X9jcTeGjpVQO30YoU3pAgMBAAECgYAyOJYXpXwpe/kpUhXZA6u0N0+7fW9gjgBpImyTVYTnG2PAt4gmvvYWpc3+1qsH+QJ06uWK8pJquCl+cnG1gokUyZ7pvSyiHMtLqi81Cr0Xy0Gmp7lvnAb+1ODlAW9lf5X0jAnk3Zst0mzwNEqERJKcXmgmUEWw+AZ2ernQdB5AnQJBAOWmbCJTRbsIsT5Xt/TyzVvDuTRdHbbf90l7IPrGdzZwgFxDF0xptoSHZQxyuS++8emsntaYiV9VX3tXf+3Njz8CQQDCjE8Gno7uC9dds4Flo4ZsJgxWLZdg+UwZsCSlRpS41ZUk2WMIhqykmNJVndsTIINtinM3UFzYphxq8DCdggDXAkA7uzuo+evLKAmh44LvbS/IzHGhkw6lgD97l1EOqQxc1oosdS7cKyrT8btwr25HYuzdEI8H1gj1COma1TlrCupVAkEAk1n+SP8zNq2VU40wRrFSkPtIgMVLUNHBh/tX5i7NWim7KwvT7JNEk+6D8QD8+0G3CfLBTXX6vMUj5QNDbykWRQJBALpbNNs3GdEeEfSy9e/8R446jtu8J2Gll/s+nJvECUXuXCuZZtYvU+Psa6iFOM66zsHv4V8zYm0Vm+tkwMb9qUE=";
    
    // 商家公钥
    public static String rsa_public = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCuhfvZcWJw99m82cbW51hTxJj+niBqY0viAwlnXtkCWjM7NyonADcGgC2sTyMZPEM/JysfsqTyXZW/aX0rSsoe0wxt0Gdcp6Ie/lWg5hfnABAhuuwbv8y0eWL61alsTJqkEBVBRY9PFCZtq5f25Oi6mP1/Y3E3ho6VUDt9GKFN6QIDAQAB";
    
    // 支付宝的公钥，无需修改该值
    public static String ali_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	public static String getPrivate_key() {
		return private_key;
	}

	public static void setPrivate_key(String private_key) {
		private_key = private_key;
	}

	public static String getAli_public_key() {
		return ali_public_key;
	}

	public static void setAli_public_key(String ali_public_key) {
		ali_public_key = ali_public_key;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getSeller_email() {
		return this.seller_email;
	}

	public void setSeller_email(String seller_email) {
		this.seller_email = seller_email;
	}

	public String getNotify_url() {
		return this.notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getReturn_url() {
		return this.return_url;
	}

	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}

	public String getLog_path() {
		return this.log_path;
	}

	public void setLog_path(String log_path) {
		this.log_path = log_path;
	}

	public String getInput_charset() {
		return this.input_charset;
	}

	public void setInput_charset(String input_charset) {
		this.input_charset = input_charset;
	}

	public String getSign_type() {
		return this.sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public String getTransport() {
		return this.transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}
}
