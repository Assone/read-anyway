import * as book from './services/book';
import * as genre from './services/genre';
import * as author from './services/author';

export * from './services/book';
export * from './services/genre';
export * from './services/author';

export default {
  ...book,
  ...genre,
  ...author,
};
