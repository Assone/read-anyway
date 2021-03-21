import { isUndefined } from '@/utils/is';

const isClient = !isUndefined(window);

export const defaultWindow = isClient ? window : undefined;
export const defaultDocument = isClient ? window.document : undefined;
export const defaultNavigator = isClient ? window.navigator : undefined;
export const defaultLocation = isClient ? window.location : undefined;
