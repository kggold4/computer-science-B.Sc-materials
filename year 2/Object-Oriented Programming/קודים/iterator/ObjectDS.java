package iterator;

public class ObjectDS implements object {

    private long id;
    private int num;
    private String info;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public int getNum() {
        return this.num;
    }

    @Override
    public String getInfo() {
        return this.info;
    }
}
