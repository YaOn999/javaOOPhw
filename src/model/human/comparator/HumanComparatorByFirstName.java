package model.human.comparator;

import FamilyTree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByFirstName<T extends FamilyTreeItem> implements Comparator<T> {

    @Override
    public int compare(T h1, T h2) {
        return h1.getFirstName().compareTo(h2.getFirstName());
    }
}
