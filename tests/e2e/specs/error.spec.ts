import Error from '../pageobjects/errpr.page';

describe('View Error', () => {
  before(() => {
    Error.open();
  });

  it('render title', () => {
    expect(Error.heading).toHaveText('Error 404');
  });
});
