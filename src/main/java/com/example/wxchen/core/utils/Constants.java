package com.example.wxchen.core.utils;

/**
 * @Author: ght
 * @Date: 2020/12/7
 */
public class Constants {

    public static final String SESSION_KEY = "whatever";


    // 用户未登录
    public static final Integer USER_NOT_LOGIN = 2001;
    // 账号或密码错误
    public static final Integer USER_CREDENTIALS_ERROR = 2002;
    // 账号已存在
    public static final Integer USER_ACCOUNT_ALREADY_EXIST = 2003;

    /**
     * 日志类型
     */
    public static final Integer OPERATION_LOG = 0;
    public static final Integer ERROR_LOG = 1;

    /**个人客户所属企业标志位--九锁客户*/
    public static final Long PERSONAL_BUSINESS_ID = (long) 2;

    /*企业表中的系统预留*/
    public static final String SYSTEM_RESERVED = "系统预留";

    /*合同类型*/
    public static final Long OFFLINE_CONTRACT = (long) 1;
    public static final Long ONLINE_CONTRACT = (long) 0;

    public static final Long SUPERMANAGER = (long) 0;

    /*合同状态*/
    public static final Long PAID_CONTRACT = (long) 1;
    public static final Long UNPAID_CONTRACT = (long) 0;

    /*合同编号前缀*/
    public static final String CONTRACT_PREFIX = "NL";

    /*编码类型*/
    public static final String CONTRACT_NUMBER = "CONTRACT_NUMBER";

    /*账单表账单类型  -- 账单类型0（线上账单）1（线下账单）*/
    public static final Long ONLINE_BILL = (long) 0;
    public static final Long OFFLINE_BILL = (long) 1;

    /*是否授权使用 0--试用 1--授权 2--取消授权*/
    public static final Long AUTHORIZATION = (long) 1;
    public static final Long DEAUTHORIZATION = (long) 2;

    /**产品价格客户类型0(企业客户) 1(个人客户）*/
    public static final Long PRICE_BUSINESS =0L;
    public static final Long PRICE_PERSONAL =1L;

    /*线上合同类型*/
    public static final Long BUSINESS_CONTRACT = (long) 0;
    public static final Long PERSONAL_CONTRACT = (long) 1;

}
