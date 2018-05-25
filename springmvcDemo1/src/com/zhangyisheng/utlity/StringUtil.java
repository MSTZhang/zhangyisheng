package com.zhangyisheng.utlity;

  
/**        
 * Title: 瀛楃涓插伐鍏风被    
 * @author rico       
 * @created 2017骞�鏈�鏃�涓嬪崍5:15:29    
 */      
public class StringUtil {
	  
	/**     
	 * @description 缁欏畾瀛楃涓叉槸鍚︿负绌烘垨绌轰覆
	 * @author rico       
	 * @created 2017骞�鏈�鏃�涓嬪崍5:15:46     
	 * @param str
	 * @return     
	 */
	public static boolean isNotEmpty(String str) {
		if (str != null && str.length() != 0) {
			return true;
		}
		return false;
	}

	/**     
	 * @description 缁欏畾瀛楃涓叉槸鍚︿负绌烘垨绌轰覆
	 * @author rico       
	 * @created 2017骞�鏈�鏃�涓嬪崍5:15:46     
	 * @param str
	 * @return     
	 */
	public static boolean isEmpty(String str) {
		if (str != null && str.length() != 0) {
			return false;
		}
		return true;
	}
}
