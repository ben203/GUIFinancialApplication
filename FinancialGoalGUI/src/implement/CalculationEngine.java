package implement;

public interface CalculationEngine {

	/**
	 * 
	 * Update the principal value based on contributions and dividends
	 * 
	 * @param yearlyContributions
	 * @param monthlyContributions
	 * @param weeklyContributions
	 * @param dailyContributions
	 * @param reninvestdividend
	 * @return
	 */
	public double updatePrincipalValue(boolean yearlyContributions, boolean monthlyContributions,
			boolean weeklyContributions, boolean dailyContributions, boolean reninvestdividend);

	/**
	 * 
	 * Calculate the rate of interest
	 * 
	 * @param time
	 * @param compund
	 * @param goal
	 */

	public void calculateRateOfReturn(int time, int compund, int goal);

}
