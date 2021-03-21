import { setInterceptorsRequest, setInterceptorsResponse } from '@/libs/http';

setInterceptorsRequest((config) => {
  const { method, data, url, baseURL } = config;

  console.log(`http ${method} --> ${baseURL}${url}, data: ${data}`);
  return config;
});

setInterceptorsResponse((res) => {
  const {
    config: { baseURL, url },
  } = res;

  console.log(`http <-- ${baseURL}${url} result: `, res);
  return res;
});
