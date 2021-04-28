import http from '@/libs/http';

export const getGenreList = () => http.get('/genres');
export const postGenreCreate = (name: string) => http.post('/genre', { name });
