import { isString } from '@/utils/is';
import { defaultWindow } from './utils';

type WindowEventName = keyof WindowEventMap;
type DocumentEventName = keyof DocumentEventMap;
type EventOptions = boolean | AddEventListenerOptions;

export function useEventListener<E extends WindowEventName>(
  event: E,
  listener: (this: Window, evt: WindowEventMap[E]) => unknown,
  options?: EventOptions,
): () => void;
export function useEventListener<E extends WindowEventName>(
  target: Window,
  event: E,
  listener: (this: Window, evt: WindowEventMap[E]) => unknown,
  options?: EventOptions,
): () => void;
export function useEventListener<E extends DocumentEventName>(
  target: Document,
  event: E,
  listener: (this: Document, evt: DocumentEventMap[E]) => unknown,
  options?: EventOptions,
): () => void;
export function useEventListener(
  target: EventTarget,
  event: string,
  listener: EventListenerOrEventListenerObject,
  options?: EventOptions,
): () => void;
export function useEventListener(...args: unknown[]): (() => void) | undefined {
  let target: EventTarget | undefined = defaultWindow;
  let event: string;
  let listener: EventListenerOrEventListenerObject;
  let options: EventOptions;

  if (isString(args[0])) {
    [event, listener, options] = args as [string, EventListenerOrEventListenerObject, EventOptions];
  } else {
    [target, event, listener, options] = args as [
      EventTarget,
      string,
      EventListenerOrEventListenerObject,
      EventOptions,
    ];
  }

  if (!target) return undefined;
  target.addEventListener(event, listener, options);
  const stop = () => target?.removeEventListener(event, listener, options);

  return stop;
}
