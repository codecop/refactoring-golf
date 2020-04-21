export class Money {
    value: number;
    currency: string;

    constructor(value: number, currency: string) {
        this.value = value;
        this.currency = currency;
    }

    plus(other: Money): Money {
        if (!(other.currency === this.currency)) {
            throw new Incalculable();
        }
        return new Money(this.value + other.value, other.currency);
    }
}

export class Incalculable extends Error {

}

export class TakeHomeCalculator {
    private percent: number;

    constructor(percent: number) {
        this.percent = percent;
    }

    netAmount(first: Money, ...rest: Money[]): Money {

        const monies: Money[] = rest;

        let total: Money = first;

        monies.forEach((next: Money) => {
            total = total.plus(next);
        });

        const amount: number = total.value * (this.percent / 100);

        const tax: Money = new Money(amount, first.currency);

        if (total.currency !== tax.currency) {
            throw new Incalculable();
        }

        return new Money(total.value - tax.value, first.currency);
    }
}
