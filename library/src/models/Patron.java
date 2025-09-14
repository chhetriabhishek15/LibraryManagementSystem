package models;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Patron {
    private String patronId;
    private String patronName;
    private final List<BorrowerRecord> borrowerRecordList;

    public Patron(String patronId, String patronName, List<BorrowerRecord> borrowerRecordList) {
        this.patronId = patronId;
        this.patronName = patronName;
        this.borrowerRecordList = new ArrayList<>();
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public List<BorrowerRecord> getBorrowerRecordList() {
        return borrowerRecordList;
    }

    public void addBorrowing(BorrowerRecord borrowerRecord){
        borrowerRecordList.add(borrowerRecord);
    }

    public boolean returnBook(String bookISBN){
        Optional<BorrowerRecord> activeRecord = borrowerRecordList.stream()
                .filter(record -> record.isActiveForBook(bookISBN))
                .findFirst();

        if (activeRecord.isPresent()){
            activeRecord.get().markAsReturned();
            return true;
        }

        return false;
    }
}
