export default class TakeHomeCalculator {
  constructor(private readonly percent: number) {
    this.percent = percent;
  }

  netAmount(first: Money, ...rest: Money[]): Money {
    const monies = rest;

    let total = first;

    monies.forEach(next => {
      total = total.plus(next);
    });

    const amount = total.value * (this.percent / 100);

    const tax = Money.money(amount, first.currency);

    return total.minus(tax);
  }
}

export class Incalculable extends Error {}

export class Money {
  value: number;
  currency: string;

  private constructor(value: number, currency: string) {
    this.value = value;
    this.currency = currency;
  }

  static money(value: number, currency: string) {
    return new Money(value, currency);
  }

  plus(other: Money): Money {
    if (!(other.currency === this.currency)) {
      throw new Incalculable();
    }
    return new Money(this.value + other.value, other.currency);
  }

  minus(other: Money): Money {
    if (this.currency !== other.currency) {
      throw new Incalculable();
    }
    return Money.money(this.value - other.value, this.currency);
  }
}
