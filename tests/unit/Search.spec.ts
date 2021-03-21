import { shallowMount } from '@vue/test-utils';
import Search from '@/components/Search.vue';

describe('Search.vue', () => {
  it('created', () => {
    const wrapper = shallowMount(Search);

    expect(wrapper.classes()).toContain('search');
  });
});
