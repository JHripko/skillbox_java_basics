public class IndividualBusinessman extends Client {

    @Override
    protected double getAmount() {
        return super.getAmount();
    }

    @Override
    protected void put(double amountToPut) {

        if (amountToPut < 1000.0) {
            double percent = amountToPut * 0.01;
            amountToPut -= percent;
            super.put(amountToPut);
        } else if (amountToPut >= 1000.0) {
            double percent = amountToPut * 0.005;
            amountToPut -= percent;
            super.put(amountToPut);
        }
    }

    @Override
    protected void take(double amountToTake) {
        double percent = amountToTake * 0.01;
        amountToTake += percent;
        super.take(amountToTake);
    }
}
