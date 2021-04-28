import http from '@/libs/http';

export const getAuthorList = () => http.get('/authors');
export const postAuthorCreate = (name: string) => http.post('/author', { name });
