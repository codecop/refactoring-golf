import * as should from 'should';
import { TakeHomeCalculator, Pair, Incalculable } from '../../src/hole1/hole1';

describe('Hole 1: Take Home Calculator should', () => {
  it('calculate tax', async () => {
    const first = new TakeHomeCalculator(10).netAmount(new Pair<number, string>(40, "GBP"), new Pair<number, string>(50, "GBP"), new Pair<number, string>(60, "GBP")).first;
    first.should.equal(135);
  });

  it('fail to sum different currencies', () => {
    should.throws(() => new TakeHomeCalculator(10).netAmount(new Pair<number, string>(4, "GBP"), new Pair<number, string>(5, "USD")), Incalculable);
  });
});
