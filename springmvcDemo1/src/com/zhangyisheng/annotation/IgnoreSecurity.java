package com.zhangyisheng.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

  
/**        
 * Title:鑷畾涔夋敞瑙�    
 * Description: 鏍囪瘑鏄惁蹇界暐REST瀹夊叏鎬ф鏌�
 * @author rico       
 * @created 2017骞�鏈�鏃�涓嬪崍4:25:32    
 */      
@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME) 
@Documented
public @interface IgnoreSecurity {

}
