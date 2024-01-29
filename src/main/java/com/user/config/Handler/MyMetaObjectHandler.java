package com.user.config.Handler;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.user.config.bean.LoginSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 操做是更新时间
 */

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        String name = LoginSession.getUserName();
        List<String> clomes = Arrays.stream(metaObject.getGetterNames()).distinct().collect(Collectors.toList());
        if (clomes.contains("createTime")) {
            metaObject.setValue("createTime", System.currentTimeMillis());
        }
        if (clomes.contains("createBy")) {
            metaObject.setValue("createBy", StringUtils.isNotBlank(name) ? name : "系统");
        }
        if (clomes.contains("updateBy")) {
            metaObject.setValue("updateBy", StringUtils.isNotBlank(name) ? name : "系统");
        }
        if (clomes.contains("updateTime")) {
            metaObject.setValue("updateTime", System.currentTimeMillis());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....{}",metaObject);
        String name = LoginSession.getUserName();
        List<String> clomes = Arrays.stream(metaObject.getGetterNames()).distinct().collect(Collectors.toList());
        if (clomes.contains("updateBy")) {
            metaObject.setValue("updateBy", StringUtils.isNotBlank(name) ? name : "系统");
        }
        if (clomes.contains("updateTime")) {
            metaObject.setValue("updateTime", System.currentTimeMillis());
        }
    }

}
