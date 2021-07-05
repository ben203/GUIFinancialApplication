package implement;

 

public class Calculation implements CalculationEngine {

	public double principal;
	public  int investmentLength;
	public int contribution;
	public double dividend;
	public double tax;
	public double rateOfReturn;
	
	 

	/**
	 * 
	 * Constructor
	 * 
	 * 
	 * @param principal
	 * @param investmentLength
	 * @param contribution
	 * @param dividend
	 * @param tax
	 * @param rateOfReturn
	 */
	public Calculation(double principal, int investmentLength, int contribution, double dividend, double tax) {

		this.principal = principal;
		this.investmentLength = investmentLength;
		this.contribution = contribution;
		this.dividend = dividend;
		this.tax = tax;
	 

	}

	/**
	 * 
	 * Updates the value for the principal based on contributions and dividends.
	 * Once the stock is sold the capital gain tax is applied and the final value is
	 * returned
	 * 
	 */

	@Override
	public double updatePrincipalValue(boolean yearlyContributions, boolean monthlyContributions,
			boolean weeklyContributions, boolean dailyContributions, boolean reninvestdividend) {
		 
		 
		for (int x = 0; x <= investmentLength; x++) {

			if (yearlyContributions) {
				principal += contribution * Contribution.ANNUAL.getValue();

			}
			if (monthlyContributions) {
				principal += contribution * Contribution.MONTHLY.getValue();

			}
			if (weeklyContributions) {
				principal += contribution*Contribution.WEEKLY.getValue();
			}
			if (dailyContributions) {
				principal += contribution* Contribution.DAILY.getValue();

			}
			if (reninvestdividend) {
				principal += dividend * 4;
			}
		}

		principal -= (principal * (tax/100));
		


		return principal;
	}

	/**
	 * 
	 * The decimal value of the rate of return is obtained using r = n((A/P)^(1/nt)- 1)
	 * 
	 * The final result is multiplied by a hundred to get the percentage value
	 * 
	 * 
	 */

	@Override
	public void calculateRateOfReturn(int time, int compund, int goal) {
		
	 
		
		double input1= (double)goal/principal;
		
		double input2= (double)1/(compund*investmentLength);

		rateOfReturn = (compund * (Math.pow(input1,input2 ) - 1)) *100;

	}

	/**
	 * 
	 * Returns the daily target interest value
	 * 
	 * @return
	 */
	public double getDailyRateOfReturn() {

		return rateOfReturn / 360;

	}

	/**
	 * 
	 * Returns the weekly target interest value
	 * 
	 * @return
	 */

	public double getWeeklyRateOfReturn() {

		return rateOfReturn / 52;

	}

	/**
	 * 
	 * Returns the monthly target interest value
	 * 
	 * @return
	 */
	public double getMonthlyRateOfReturn() {

		return rateOfReturn / 12;

	}

	/**
	 * 
	 * Returns the annual target interest value
	 * 
	 * @return
	 */
	public double getAnnualRateOfReturn() {

		return rateOfReturn;

	}
	
	
 

}
