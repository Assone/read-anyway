<template lang="pug">
.search
  input(type='search')
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class Search extends Vue {}
</script>
