/**
 *
 */
package edu.ncsu.csc216.train_travel.transportation;

/**
 * @author kavitpatel
 */
public class Seat implements Comparable<Seat> {

    private String label;
    private int trainCarID;
    private boolean reserved;

    public Seat(String label, int trainCarID) {
        this.label = label;
        this.trainCarID = trainCarID;
        this.reserved = false;
    }

    public static String printListOfSeats(Seat[] x) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < x.length; ++i ) {
            sb.append(x[i].toString() + " ");
        }
        return sb.toString();
    }

    public void reserve() {
        this.setReserved(true);
    }

    public void release() {
        this.setReserved(false);

    }

    public boolean isReserved() {
        return this.reserved;

    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getTrainCarNumber() {
        return this.trainCarID;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String toString() {
        return this.trainCarID + "-" + this.label;
    }

    public int getTrainCarID() {
        return trainCarID;
    }

    public void setTrainCarID(int trainCarID) {
        this.trainCarID = trainCarID;
    }

    public int compareTo(Seat toCompare) {

        Integer thisId = Integer.valueOf(this.trainCarID);
        Integer toCompareId = Integer.valueOf(toCompare.getTrainCarNumber());

        if (thisId.compareTo(toCompareId) == 0) {
            return this.label.compareTo(toCompare.getLabel());
        } else {
            return thisId.compareTo(toCompareId);
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        result = prime * result + (reserved ? 1231 : 1237);
        result = prime * result + trainCarID;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Seat other = (Seat) obj;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.equals(other.label))
            return false;
        if (reserved != other.reserved)
            return false;
        if (trainCarID != other.trainCarID)
            return false;
        return true;
    }
}
