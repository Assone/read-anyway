class ViewError {
  open(path = '/eee') {
    browser.url(path);
  }

  get heading() {
    return $('h1');
  }
}

export default new ViewError();
