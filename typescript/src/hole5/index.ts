import Money from "./money";

export class Incalculable extends Error {

}

export default class TakeHomeCalculator {
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

        return minus(total, tax, first);
    }
}
function minus(total: Money, tax: Money, first: Money): Money {
    return new Money(total.value - tax.value, first.currency);
}

