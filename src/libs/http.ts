import apiConfig from '@/config/api';
import Axios, { AxiosInstance, AxiosRequestConfig, AxiosResponse } from 'axios';

type interceptorsRequest<V> = ((value: V) => V | Promise<V>) | undefined;
// eslint-disable-next-line @typescript-eslint/no-explicit-any
type interceptorsResponse = ((error: any) => unknown) | undefined;

class HTTPCore {
  instance: AxiosInstance;

  constructor(config: AxiosRequestConfig) {
    this.instance = Axios.create(config);
  }

  static setInterceptorsRequest(
    core: HTTPCore,
    resolve: interceptorsRequest<AxiosRequestConfig>,
    reject: interceptorsResponse,
  ) {
    core.instance.interceptors.request.use(resolve, reject);
  }

  static setInterceptorsResponse(
    core: HTTPCore,
    resolve: interceptorsRequest<AxiosResponse>,
    reject: interceptorsResponse,
  ) {
    core.instance.interceptors.response.use(resolve, reject);
  }

  get<T = unknown>(url: string, config?: AxiosRequestConfig): Promise<T> {
    return this.instance.get(url, config);
  }

  delete<T = unknown>(url: string, config?: AxiosRequestConfig): Promise<T> {
    return this.instance.delete(url, config);
  }

  head<T = unknown>(url: string, config?: AxiosRequestConfig): Promise<T> {
    return this.instance.head(url, config);
  }

  options<T = unknown>(url: string, config?: AxiosRequestConfig): Promise<T> {
    return this.instance.options(url, config);
  }

  post<T = unknown>(
    url: string,
    data?: Record<string, unknown>,
    config?: AxiosRequestConfig,
  ): Promise<T> {
    return this.instance.post(url, data, config);
  }

  put<T = unknown>(
    url: string,
    data?: Record<string, unknown>,
    config?: AxiosRequestConfig,
  ): Promise<T> {
    return this.instance.put(url, data, config);
  }

  patch<T = unknown>(
    url: string,
    data?: Record<string, unknown>,
    config?: AxiosRequestConfig,
  ): Promise<T> {
    return this.instance.patch(url, data, config);
  }
}

const http = new HTTPCore(apiConfig);

export const setInterceptorsRequest = (
  resolve?: interceptorsRequest<AxiosRequestConfig>,
  reject?: interceptorsResponse,
): void => HTTPCore.setInterceptorsRequest(http, resolve, reject);
export const setInterceptorsResponse = (
  resolve?: interceptorsRequest<AxiosResponse>,
  reject?: interceptorsResponse,
): void => HTTPCore.setInterceptorsResponse(http, resolve, reject);
export default http;
