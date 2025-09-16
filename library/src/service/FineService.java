package service;

import constants.FineConfig;
import models.BorrowerRecord;

import java.util.concurrent.TimeUnit;

public class FineService implements interfaces.Fine {

    @Override
    public double calculateFine(BorrowerRecord record) {
        if (record.getReturnDate()==null){
            return 0;
        }

        long diffInMillis = record.getReturnDate().getTime() - record.getCheckoutDate().getTime();
        long daysBorrowed = TimeUnit.DAYS.convert(diffInMillis,TimeUnit.MILLISECONDS);

        if (daysBorrowed < FineConfig.GRACE_PERIOD_DAYS.getValue()){
            return 0;
        }
        else {
            return (daysBorrowed - FineConfig.GRACE_PERIOD_DAYS.getValue())*FineConfig.FINE_PER_DAY.getValue();
        }
    }
}
