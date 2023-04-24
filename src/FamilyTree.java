import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> allHumans;

    public FamilyTree() {
        this.allHumans = new ArrayList<>();
    }

    public FamilyTree(List<Human> allHumans) {
        this.allHumans = allHumans;
    }

    public void addHuman(Human human) {
        if (!allHumans.contains(human)){
            allHumans.add(human);
            if (human.getFather() != null){
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
        }
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("In a tree");
        sb.append(allHumans.size());
        sb.append("obj: \n");
        for (Human human: allHumans){
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
}
