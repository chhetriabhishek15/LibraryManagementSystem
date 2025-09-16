package interfaces;

import models.BorrowerRecord;

public interface Fine {
    double calculateFine(BorrowerRecord record);
}
