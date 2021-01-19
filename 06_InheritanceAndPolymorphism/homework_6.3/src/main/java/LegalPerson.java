public class LegalPerson extends Client {

    @Override
    protected double getAmount() {
        return super.getAmount();
    }

    @Override
    protected void put(double amountToPut) {
        super.put(amountToPut);
    }

    @Override
    protected void take(double amountToTake) {
        double percent = amountToTake * 0.01;
        amountToTake += percent;
        super.take(amountToTake);
    }
}
