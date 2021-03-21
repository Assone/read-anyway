<template lang="pug">
.view-error
  h1 Error 404
  blockquote {{ getMsg() }}
  router-link(to='/', aria-label='go to home') Take me home.
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { RawLocation, Route } from 'vue-router';

const msgs = [
  "There's nothing here.",
  'How did we get here?',
  "That's a Four-Oh-Four.",
  "Looks like we've got some broken links.",
];
const getRandomIndex = (max: number) => Math.floor(Math.random() * max);

@Component
export default class Error extends Vue {
  // eslint-disable-next-line class-methods-use-this
  getMsg() {
    return msgs[getRandomIndex(msgs.length)];
  }

  beforeRouteUpdate(
    _to: Route,
    _from: Route,
    next: (to?: RawLocation | false | ((vm: Vue) => void)) => void,
  ) {
    this.$forceUpdate();
    next();
  }
}
</script>
