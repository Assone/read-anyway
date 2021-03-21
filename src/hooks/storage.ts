type StorageLink = Pick<Storage, 'getItem' | 'setItem' | 'removeItem'>;
type StorageSetFunction = (data: unknown) => void;

const read = (val: string) => JSON.parse(val);
const write = (val: unknown) => JSON.stringify(val);

export function useStorage(
  key: string,
  defaultValue: string,
  storage?: StorageLink,
): [string, StorageSetFunction];
export function useStorage(
  key: string,
  defaultValue: boolean,
  storage?: StorageLink,
): [boolean, StorageSetFunction];
export function useStorage(
  key: string,
  defaultValue: number,
  storage?: StorageLink,
): [number, StorageSetFunction];
export function useStorage<T>(
  key: string,
  defaultValue: T,
  storage?: StorageLink,
): [T, StorageSetFunction];
export function useStorage<T = unknown>(
  key: string,
  defaultValue: T,
  storage?: StorageLink,
): [T, StorageSetFunction];
export function useStorage<T extends string | number | Record<string, unknown> | boolean | null>(
  key: string,
  defaultValue?: T,
  storage: StorageLink | undefined = window?.localStorage,
): [T | undefined, (data: unknown) => void] {
  let value = defaultValue;

  const readData = () => {
    if (!storage) return;

    try {
      const rawValue = storage.getItem(key);

      if (rawValue === null) {
        if (defaultValue) storage.setItem(key, write(defaultValue));
      } else {
        value = read(rawValue) || defaultValue;
      }
    } catch (error) {
      console.warn(error);
    }
  };
  const setData = (data: unknown) => {
    if (data === null) {
      storage.removeItem(key);
    } else {
      storage.setItem(key, write(data));
    }
  };

  readData();

  return [value, setData];
}

export function useLocalStorage(key: string, defaultValue: string): [string, StorageSetFunction];
export function useLocalStorage(key: string, defaultValue: boolean): [boolean, StorageSetFunction];
export function useLocalStorage(key: string, defaultValue: number): [number, StorageSetFunction];
export function useLocalStorage<T>(key: string, defaultValue: T): [T, StorageSetFunction];
export function useLocalStorage<T = unknown>(key: string, defaultValue: T): [T, StorageSetFunction];
export function useLocalStorage<
  T extends string | number | Record<string, unknown> | boolean | null
>(key: string, defaultValue: T): [T | undefined, (data: unknown) => void] {
  return useStorage(key, defaultValue, window?.localStorage);
}

export function useSessionStorage(key: string, defaultValue: string): [string, StorageSetFunction];
export function useSessionStorage(
  key: string,
  defaultValue: boolean,
): [boolean, StorageSetFunction];
export function useSessionStorage(key: string, defaultValue: number): [number, StorageSetFunction];
export function useSessionStorage<T>(key: string, defaultValue: T): [T, StorageSetFunction];
export function useSessionStorage<T = unknown>(
  key: string,
  defaultValue: T,
): [T, StorageSetFunction];
export function useSessionStorage<
  T extends string | number | Record<string, unknown> | boolean | null
>(key: string, defaultValue: T): [T | undefined, (data: unknown) => void] {
  return useStorage(key, defaultValue, window?.sessionStorage);
}
