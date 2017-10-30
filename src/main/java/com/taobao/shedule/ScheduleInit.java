/**  

* Licensed to SAICMotor,Inc. under the terms of the SAICMotor 
* Software License version 1.0.

* See the NOTICE file distributed with this work for additional 
* information regarding copyright ownership.  
* ----------------------------------------------------------------------------
* Date           Author      Version        Comments
* 2017年6月13日        nwcjl       1.0            Initial Version

*/  

package com.taobao.shedule;  

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import  ch.qos.logback.core.util.StatusListenerConfigHelper;


/**
 *
 */
public class ScheduleInit implements InitializingBean, ApplicationContextAware {
    private static Log logger = LogFactory.getLog(ScheduleInit.class);
    private static ApplicationContext applicationContext;
    private Properties properties = null;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ScheduleInit.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("****初始化ScheduleInit****  properties:" + properties);
        TBScheduleManagerFactory tbscheduleManagerFactory = new TBScheduleManagerFactory();
        tbscheduleManagerFactory.setApplicationContext(applicationContext);
        tbscheduleManagerFactory.init(properties);  // ZK configuration in zk properties file.
        tbscheduleManagerFactory.setZkConfig(convert(properties));
        logger.info("****成功启动schedule调度引擎 ...****");
    }

    private Map<String, String> convert(Properties p) {
        Set<String> keys = p.stringPropertyNames();
        Map<String, String> map = new HashMap<String, String>();
        for (String key : keys) {
            map.put(key, p.getProperty(key));
        }
        return map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
  
