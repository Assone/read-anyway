package com.example.wxchen.core.base;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.wxchen.api.entity.User;
import com.example.wxchen.core.utils.SecurityService;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author wultn
 * @Date 15:15 2020/12/9
 * @Param
 * @return
 **/
@Component
public class BaseMetaObjectHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    User login = SecurityService.getCurrentUser();
    if (null != login) {
      this.setFieldValByName("createId", login.getUserId(), metaObject);
      this.setFieldValByName("updateId", login.getUserId(), metaObject);
    }
    this.setFieldValByName("createTime", new Date(), metaObject);
    this.setFieldValByName("updateTime", new Date(), metaObject);
    this.setFieldValByName("delFlag", 1, metaObject);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    User login = SecurityService.getCurrentUser();
    if (null != login) {
      this.setFieldValByName("updateId", login.getUserId(), metaObject);
    }
    this.setFieldValByName("updateTime", new Date(), metaObject);
  }
}
