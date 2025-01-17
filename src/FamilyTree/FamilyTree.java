package FamilyTree;

import model.human.Human;
import model.human.comparator.HumanComparatorByFirstName;
import model.human.comparator.HumanComparatorByLastName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private List<E> allHumans;

    public FamilyTree() {
        this.allHumans = new ArrayList<>();
    }

    public FamilyTree(List<E> allHumans) {
        this.allHumans = allHumans;
    }

    public void addHuman(E human) {
        if (!allHumans.contains(human)){
            allHumans.add(human);
            if (human.getFather() != null){
                human.getFather().addChild((Human) human);
            }
            if (human.getMother() != null){
                human.getMother().addChild((Human) human);
            }
        }
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("In a tree");
        sb.append(allHumans.size());
        sb.append("obj: \n");
        for (E human: allHumans){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Iterator<E> iterator(){
        return new HumanIterator(allHumans);
    }

    public void sortByFirstName() {
        allHumans.sort(new HumanComparatorByFirstName());
    }

    public void sortByLastName() {
        allHumans.sort(new HumanComparatorByLastName());
    }

    public E getHumanById(int id){
        for (E human: allHumans) {
            if (human.getId() == (id)){
                return human;
            }
        }
        return null;
    }

    public FamilyTreeItem getMother(E human){
        return human.getMother();
    }

    public FamilyTreeItem getFather(E human){
        return human.getFather();
    }
}


