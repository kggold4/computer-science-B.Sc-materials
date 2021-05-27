package design_patterns.creational.prototype;

public class PineTree extends Tree {

    public PineTree(Object mass, Object height) {
        super();
    }

    @Override
    public Tree copy() {
        PineTree pineTreeClone = new PineTree(this.getMass(), this.getHeight());
        pineTreeClone.setPosition(this.getPosition());
        return pineTreeClone;
    }

    Object getMass(){return null;}

    Object getHeight(){return null;}

    Object getPosition(){return null;}

    void setPosition(Object position){return;}

}
