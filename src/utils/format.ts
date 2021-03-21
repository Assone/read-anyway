import { run } from '.';

type TimeDate = {
  days: number;
  hours: number;
  minutes: number;
  seconds: number;
  milliseconds: number;
};

const SECOND = 1000;
const MINUTE = 60 * SECOND;
const HOUR = 60 * MINUTE;
const DAY = 24 * HOUR;

const paddingZero = (time: number) => (time < 10 ? `0${time}` : String(time));

const parseTime = (time: number) => {
  const days = Math.floor(time / DAY);
  const hours = Math.floor((time % DAY) / HOUR);
  const minutes = Math.floor((time % HOUR) / MINUTE);
  const seconds = Math.floor((time % MINUTE) / SECOND);
  const milliseconds = Math.floor(time % SECOND);

  return {
    days,
    hours,
    minutes,
    seconds,
    milliseconds,
  };
};

const parseFormat = (expression: string) => (time: TimeDate) => {
  const { days } = time;
  let { hours, minutes, seconds, milliseconds } = time;
  const transformTimeToExp = (
    searchKey: string,
    replaceData: number,
    mismatchProcess?: () => void,
  ) => (data: string) => {
    let formatString = data;

    if (formatString.indexOf(searchKey) !== -1) {
      formatString = formatString.replace(searchKey, paddingZero(replaceData));
    } else if (mismatchProcess) {
      mismatchProcess();
    }

    return formatString;
  };

  return run<string>(
    expression,
    transformTimeToExp('DD', days, () => {
      hours += days * 24;
    }),
    transformTimeToExp('HH', hours, () => {
      minutes += hours * 60;
    }),
    transformTimeToExp('mm', minutes, () => {
      seconds += minutes * 60;
    }),
    transformTimeToExp('ss', seconds, () => {
      milliseconds += seconds * 1000;
    }),
    transformTimeToExp('SSS', milliseconds),
  );
};

// eslint-disable-next-line import/prefer-default-export
export const formatTime = (time: number, formatExpression?: string): string =>
  run<string>(time, Math.floor, parseTime, parseFormat(formatExpression || 'mm:ss'));
