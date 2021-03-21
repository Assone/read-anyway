import { shallowMount } from '@vue/test-utils';
import AppHeader from '@/components/AppHeader.vue';

describe('AppHeader.vue', () => {
  it('created', () => {
    const wrapper = shallowMount(AppHeader);

    expect(wrapper.classes()).toContain('app-header');
  });
});
