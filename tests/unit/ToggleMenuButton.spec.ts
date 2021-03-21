import { shallowMount } from '@vue/test-utils';
import ToggleMenuButton from '@/components/ToggleMenuButton.vue';

describe('ToggleMenuButton.vue', () => {
  it('created', () => {
    const wrapper = shallowMount(ToggleMenuButton);

    expect(wrapper.classes()).toContain('menu-button');
  });

  it('click menu', () => {
    const wrapper = shallowMount(ToggleMenuButton);

    wrapper.trigger('click');
    expect(wrapper.emitted('toggle')).toBeTruthy();
  });
});
