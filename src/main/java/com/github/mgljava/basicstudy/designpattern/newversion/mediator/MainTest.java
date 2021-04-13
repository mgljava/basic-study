package com.github.mgljava.basicstudy.designpattern.newversion.mediator;

public class MainTest {

    public static void main(String[] args) {
        UnitedNationsSecurityCouncil unitedNations = new UnitedNationsSecurityCouncil();
        USACountry usaCountry = new USACountry(unitedNations);
        IraqCountry iraqCountry = new IraqCountry(unitedNations);

        unitedNations.setUsaCountry(usaCountry);
        unitedNations.setIraqCountry(iraqCountry);

        usaCountry.declare("我是USA，不允许做操作");
        iraqCountry.declare("我是Iraq，我没有做操作");
    }
}
