package com.apcomputerscience.piggamenew.events.eventBusEvents;

/**
 *
 * @author briajbarn42
 */
public class DoubleSixEventBusEvent {
    private final int amount;
    public DoubleSixEventBusEvent(int amountTransfered) {
        amount = amountTransfered;
    }
    public int getAmount() {
        return amount;
    }
}
