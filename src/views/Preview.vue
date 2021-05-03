<template lang="pug">
.view-preview
  canvas(ref='canvas')
</template>

<script lang="ts">
import { Component, Ref, Vue } from 'vue-property-decorator';
import { getDocument, GlobalWorkerOptions } from 'pdfjs-dist';
// eslint-disable-next-line import/no-unresolved, import/extensions
import { PDFDocumentProxy } from 'pdfjs-dist/types/display/api';

GlobalWorkerOptions.workerSrc = require('pdfjs-dist/build/pdf.worker.entry');

@Component
export default class Preview extends Vue {
  @Ref('canvas') canvas!: HTMLCanvasElement;

  getPage(pdf: PDFDocumentProxy, page: number) {
    pdf.getPage(page).then((p) => {
      const viewport = p.getViewport({ scale: 1 });
      const ctx = this.canvas.getContext('2d');
      this.canvas.height = viewport.height;
      this.canvas.width = viewport.width;

      // eslint-disable-next-line @typescript-eslint/ban-types
      p.render({ canvasContext: ctx as Object, viewport }).promise.then(() => {
        console.log('Page rendered');
      });
    });
  }

  mounted() {
    const url = 'https://mozilla.github.io/pdf.js/web/compressed.tracemonkey-pldi-09.pdf';

    const loadingTask = getDocument(url);
    loadingTask.promise.then((pdf) => {
      console.log('PDF loaded');

      this.getPage(pdf, 1);
    });
  }
}
</script>
