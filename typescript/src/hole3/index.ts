export default class TakeHomeCalculator {
  constructor(private readonly percent: number) {
    this.percent = percent;
  }

  netAmount(first: Money, ...rest: Money[]): Money {
    const monies = rest;

    let total = first;

    monies.forEach(next => {
      if (!(next.currency === total.currency)) {
        throw new Incalculable();
      }
    });

    monies.forEach(next => {
      total = new Money(total.value + next.value, next.currency);
    });

    const amount = total.value * (this.percent / 100);

    const tax = new Money(amount, first.currency);

    if (total.currency !== tax.currency) {
      throw new Incalculable();
    }

    return new Money(total.value - tax.value, first.currency);
  }
}

export class Incalculable extends Error {}

export class Money {
  value: number;
  currency: string;

  constructor(value: number, currency: string) {
    this.value = value;
    this.currency = currency;
  }
}
