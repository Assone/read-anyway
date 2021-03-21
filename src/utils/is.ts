const mobileReg = /(iPhone|iPad|Android|ios)/i;

export const isUndefined = (val: unknown): val is undefined => typeof val === 'undefined';
export const isString = (val: unknown): val is string => typeof val === 'string';
export const isNumber = (val: unknown): val is number => typeof val === 'number';
export const isObject = (val: unknown): val is Record<string, unknown> =>
  val !== null && typeof val === 'object';
export const { isArray } = Array;

export const isDev = process.env.NODE_ENV === 'development';
export const isProd = process.env.NODE_ENV === 'production';

export const isMobile = !!navigator.userAgent.match(mobileReg);
