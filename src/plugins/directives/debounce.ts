import { DirectiveOptions } from 'vue';

const debounce: DirectiveOptions = {
  inserted(el, binding) {
    let time: NodeJS.Timeout | null = null;

    el.addEventListener('click', () => {
      if (time) clearTimeout(time);

      time = setTimeout(() => {
        binding.value();
      }, 1000);
    });
  },
};

export default debounce;
