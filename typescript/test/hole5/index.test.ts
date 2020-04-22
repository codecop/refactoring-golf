import * as should from 'should';
import Money from '../../src/hole5/money';
import TakeHomeCalculator, { Incalculable } from '../../src/hole5';

describe('Hole 5: Take Home Calculator should', () => {
  it('calculate tax', async () => {
    const first = new TakeHomeCalculator(10).netAmount(new Money(40, "GBP"), new Money(50, "GBP"), new Money(60, "GBP")).value;
    first.should.equal(135);
  });

  it('fail to sum different currencies', () => {
    should.throws(() => new TakeHomeCalculator(10).netAmount(new Money(4, "GBP"), new Money(5, "USD")), Incalculable);
  });
});
