package com.zhangyisheng.utlity;

import java.util.Collection;

  
/**        
 * Title: Collection 宸ュ叿绫�   
 * Description: 
 * @author rico       
 * @created 2017骞�鏈�鏃�涓嬪崍5:14:01    
 */      
public class CollectionUtil {
	public static boolean isNotEmpty(Collection<?> c){
		if (c != null && c.size() != 0 ) {
			return true;
		}
		return false;
	}
}
