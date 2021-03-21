import { NavigationGuard } from 'vue-router';

const guards: NavigationGuard = (to, from, next) => {
  const { meta } = to;

  if (meta.title) {
    document.title = meta.title;
  }

  next();
};

export default guards;
