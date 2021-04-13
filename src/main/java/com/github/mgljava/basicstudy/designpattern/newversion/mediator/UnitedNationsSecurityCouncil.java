package com.github.mgljava.basicstudy.designpattern.newversion.mediator;

public class UnitedNationsSecurityCouncil implements UnitedNations {

    private USACountry usaCountry;
    private IraqCountry iraqCountry;

    public void setUsaCountry(USACountry usaCountry) {
        this.usaCountry = usaCountry;
    }

    public void setIraqCountry(IraqCountry iraqCountry) {
        this.iraqCountry = iraqCountry;
    }

    @Override
    public void declare(String message, Country country) {
        if (country == usaCountry) {
            iraqCountry.getMessage(message);
        } else {
            usaCountry.getMessage(message);
        }
    }
}
