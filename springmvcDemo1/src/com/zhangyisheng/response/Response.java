package com.zhangyisheng.response;

/**
 * Title: 缁熶竴鍝嶅簲缁撴瀯 
 * Description:浣跨敤REST妗嗘灦瀹炵幇鍓嶅悗绔垎绂绘灦鏋勶紝鎴戜滑闇�棣栧厛纭畾杩斿洖鐨凧SON鍝嶅簲缁撴瀯鏄粺涓�殑锛�
 * 涔熷氨鏄锛屾瘡涓猂EST璇锋眰灏嗚繑鍥炵浉鍚岀粨鏋勭殑JSON鍝嶅簲缁撴瀯銆備笉濡ㄥ畾涔変竴涓浉瀵归�鐢ㄧ殑JSON鍝嶅簲缁撴瀯锛屽叾
 * 涓寘鍚袱閮ㄥ垎锛氬厓鏁版嵁涓庤繑鍥炲�锛屽叾涓紝鍏冩暟鎹〃绀烘搷浣滄槸鍚︽垚鍔熶笌杩斿洖鍊兼秷鎭瓑锛岃繑鍥炲�瀵瑰簲鏈嶅姟绔柟娉曟墍杩斿洖鐨勬暟鎹�
 * { "meta": { "success": true, "message": "ok" }, "data": ... }
 * 
 * @author rico
 * @created 2017骞�鏈�鏃�涓嬪崍5:06:00
 */
public class Response {

	private static final String OK = "ok";
	private static final String ERROR = "error";

	private Meta meta;     // 鍏冩暟鎹�
	private Object data;   // 鍝嶅簲鍐呭

	public Response success() {
		this.meta = new Meta(true, OK);
		return this;
	}

	public Response success(Object data) {
		this.meta = new Meta(true, OK);
		this.data = data;
		return this;
	}

	public Response failure() {
		this.meta = new Meta(false, ERROR);
		return this;
	}

	public Response failure(String message) {
		this.meta = new Meta(false, message);
		return this;
	}

	public Meta getMeta() {
		return meta;
	}

	public Object getData() {
		return data;
	}

	/**
	 * Title: 璇锋眰鍏冩暟鎹�
	 * @author rico
	 * @created 2017骞�鏈�鏃�涓嬪崍5:08:12
	 */
	public class Meta {

		private boolean success;
		private String message;

		public Meta(boolean success) {
			this.success = success;
		}

		public Meta(boolean success, String message) {
			this.success = success;
			this.message = message;
		}

		public boolean isSuccess() {
			return success;
		}

		public String getMessage() {
			return message;
		}
	}
}