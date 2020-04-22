import * as should from 'should';
import TakeHomeCalculator, {Money, Incalculable} from '../../src/hole3';

describe('Hole 3: Take Home Calculator should', () => {
  it('calculate tax', async () => {
    const first = new TakeHomeCalculator(10).netAmount(
      new Money(40, 'GBP'),
      new Money(50, 'GBP'),
      new Money(60, 'GBP')
    ).value;
    first.should.equal(135);
  });

  it('fail to sum different currencies', () => {
    should.throws(
      () =>
        new TakeHomeCalculator(10).netAmount(
          new Money(4, 'GBP'),
          new Money(5, 'USD')
        ),
      Incalculable
    );
  });
});
