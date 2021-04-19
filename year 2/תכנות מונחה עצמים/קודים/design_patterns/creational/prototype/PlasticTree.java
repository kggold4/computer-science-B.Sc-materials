package design_patterns.creational.prototype;

public class PlasticTree extends Tree {

    public PlasticTree(Object mass, Object height) {
        super();
    }

    @Override
    public Tree copy() {
        PlasticTree plasticTreeClone = new PlasticTree(this.getMass(), this.getHeight());
        plasticTreeClone.setPosition(this.getPosition());
        return plasticTreeClone;
    }

    Object getMass(){return null;}

    Object getHeight(){return null;}

    Object getPosition(){return null;}

    void setPosition(Object position){return;}
}
