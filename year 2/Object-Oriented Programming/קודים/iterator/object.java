package iterator;

public interface object {
    public long getId();
    public int getNum();
    public String getInfo();

    default double getSum() {
        return 0;
    }
}
