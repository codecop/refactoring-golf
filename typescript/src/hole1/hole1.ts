export class Pair<A, B> {

    first: A;
    second: B;

    constructor(first: A, second: B) {
        this.first = first;
        this.second = second;
    }
}


export class Incalculable extends Error {

}

export class TakeHomeCalculator {
    private percent: number;

    constructor(percent: number) {
        this.percent = percent;
    }

    netAmount(first: Pair<number, string>, ...rest: Pair<number, string>[]): Pair<number, string> {

        const pairs: Pair<number, string>[] = rest;

        let total: Pair<number, string> = first;

        pairs.forEach((next: Pair<number, string>) => {
            if (!(next.second === total.second)) {
                throw new Incalculable();
            }
        });

        pairs.forEach((next: Pair<number, string>) => {
            total = new Pair(total.first + next.first, next.second);
        });

        const amount: number = total.first * (this.percent / 100);

        const tax: Pair<number, string> = new Pair(amount, first.second);

        if (total.second == tax.second) {
            return new Pair(total.first - tax.first, first.second)
        } else {
            throw new Incalculable();
        }
    }
}