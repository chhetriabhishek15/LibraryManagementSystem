package interfaces;

import models.BorrowerRecord;

public interface FineService {
    double calculateFine(BorrowerRecord record);
}
