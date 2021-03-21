import { shallowMount } from '@vue/test-utils';
import NavBarTitle from '@/components/NavBarTitle.vue';

describe('NavBarTitle.vue', () => {
  it('created', () => {
    const wrapper = shallowMount(NavBarTitle, {
      propsData: {
        title: 'title',
      },
      stubs: ['router-link'],
    });

    expect(wrapper.classes()).toContain('nav-bar__title');
  });
});
