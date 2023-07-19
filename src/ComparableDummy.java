import java.util.Objects;

public class ComparableDummy implements Comparable<ComparableDummy> {
    private long id;
    private String aData;

    public ComparableDummy(long id) {
        this.id = id;
    }

    public ComparableDummy(long id, String aData) {
        this.id = id;
        this.aData = aData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getaData() {
        return aData;
    }

    public void setaData(String aData) {
        this.aData = aData;
    }

    @Override
    public int compareTo(ComparableDummy o) {
        if (this.id > o.id) {
            return 1;
        } else if (this.id < o.id) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComparableDummy that = (ComparableDummy) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
