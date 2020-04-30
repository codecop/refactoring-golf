export default class TakeHomeCalculator {
  constructor(private readonly percent: number) {
    this.percent = percent;
  }

  netAmount(first: Pair<number, string>, ...rest: Pair<number, string>[]): Pair<number, string> {
    const pairs = rest;

    let total = first;

    pairs.forEach(next => {
      if (!(next.second === total.second)) {
        throw new Incalculable();
      }
    });

    pairs.forEach(next => {
      total = new Pair(total.first + next.first, next.second);
    });

    const amount = total.first * (this.percent / 100);

    const tax = new Pair(amount, first.second);

    if (total.second !== tax.second) {
      throw new Incalculable();
    }

    return new Pair(total.first - tax.first, first.second);
  }
}

export class Incalculable extends Error {}

export class Pair<A, B> {
  first: A;
  second: B;

  constructor(first: A, second: B) {
    this.first = first;
    this.second = second;
  }
}
