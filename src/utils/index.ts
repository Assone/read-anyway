// eslint-disable-next-line import/prefer-default-export, @typescript-eslint/ban-types
export const run = <T = unknown>(data: unknown, ...fns: Function[]): T =>
  fns.reduce((result, current) => current(result), data) as T;
