package by.prohorov.price.kg;

import by.prohorov.validate.ValidatorPrice;
import by.prohorov.validate.ValidatorPriceImpl;
import by.prohorov.validate.ValidatorUser;

import java.math.BigDecimal;

/**
 * Created by Artsiom Prokharau 10.02.2021
 */

public abstract class CostByPriceKgAll implements CostByPriceKg {

    protected BigDecimal costWeight;
    protected ValidatorPrice validatorPrice;

    protected CostByPriceKgAll(ValidatorUser validatorUser) {
        this.costWeight = validatorUser.checkValue("Please, enter weight (kg) : =>  ");
        this.validatorPrice = new ValidatorPriceImpl();
    }

    protected CostByPriceKgAll() {
        this.validatorPrice = new ValidatorPriceImpl();
    }

    public BigDecimal getCostWeight() {
        return costWeight;
    }

    public void setCostWeight(BigDecimal costWeight) {
        this.costWeight = costWeight;
    }

}
