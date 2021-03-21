const copyProperties = <T = unknown>(
  target: T,
  source: Record<string, unknown>,
  isPrototype?: boolean,
) => {
  Reflect.ownKeys(source).forEach((key) => {
    if (key !== 'constructor' && key !== 'prototype' && isPrototype ? key !== 'name' : true) {
      const desc = Object.getOwnPropertyDescriptor(source, key);
      if (desc) Object.defineProperty(target, key, desc);
    }
  });
};

// eslint-disable-next-line @typescript-eslint/no-explicit-any, @typescript-eslint/explicit-module-boundary-types
export default function Mixins(...mixins: any[]) {
  class Mixin {
    constructor(data: unknown) {
      mixins.forEach((MixinItem) => copyProperties(this, new MixinItem(data))); // 拷贝实例属性
    }
  }

  mixins.forEach((mixin) => {
    copyProperties(Mixin, mixin, true); // 拷贝静态属性
    copyProperties(Mixin.prototype, mixin.prototype, true); // 拷贝原型属性
  });

  return Mixin;
}
