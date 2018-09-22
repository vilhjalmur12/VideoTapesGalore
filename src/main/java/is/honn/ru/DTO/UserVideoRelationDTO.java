package is.honn.ru.DTO;

import java.util.Date;

public class UserVideoRelationDTO {
    private int userId;
    private int tapeId;
    private Date borrowDate;
    private Date returnDate;

    public UserVideoRelationDTO() {}

    public UserVideoRelationDTO(int userId, int tapeId, Date borrowDate, Date returnDate) {
        this.userId = userId;
        this.tapeId = tapeId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTapeId() {
        return tapeId;
    }

    public void setTapeId(int tapeId) {
        this.tapeId = tapeId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        UserVideoRelationDTO rel = (UserVideoRelationDTO) o;

        return this.tapeId == rel.tapeId;
    }

    @Override
    public int hashCode() {
        return this.tapeId;
    }

    @Override
    public String toString() {
        String val = String.format("%d\t %d\t", this.userId, this.tapeId);
        return val;
    }
}
