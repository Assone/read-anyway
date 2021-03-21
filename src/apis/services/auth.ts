import { AUTH } from '@/config/path';
import http from '@/libs/http';
import { isString } from '@/utils/is';

/**
 * 登陆
 * @param account 要登陆的账号，可以是邮箱或者手机号码
 * @param password 密码
 */
export const login = (account: string | number, password: string) =>
  isString(account)
    ? http.post(AUTH.loginEmail, { email: account, password })
    : http.post(AUTH.loginPhone, { phone: account, password });

/**
 * 刷新登陆状态
 */
export const refresh = () => http.post<{ message: string }>(AUTH.refresh);
