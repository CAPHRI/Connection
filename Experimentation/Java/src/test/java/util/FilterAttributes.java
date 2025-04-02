package util;

import bayes.Node;

import java.util.ArrayList;
import java.util.List;

public class FilterAttributes {


    public static List<String> generateSmallSet() {
        List<String> toBeKept = new ArrayList<>();
        toBeKept.add("age");
        toBeKept.add("Bibliotheekdichtstbijzijnde");
        toBeKept.add("Buitenschoolseopvangdichtsbijzijnde");
        toBeKept.add("emotional_support_decisions_incl_care");
        toBeKept.add("emotional_support_talk_about_my_health_incl_care");
        toBeKept.add("GEZONDHEID_NU_CBS");
        toBeKept.add("Greenspace.r1500m_all");
        toBeKept.add("informational_support_incl_care");
        toBeKept.add("Nederlandseachtergond");
        toBeKept.add("network_size_care");
        toBeKept.add("no_support_incl_care");
        toBeKept.add("practical_support_incl_care");
        toBeKept.add("RELATIE");
        toBeKept.add("STUDEREN");
        toBeKept.add("Supermarktdichtstbijzijnde");
        toBeKept.add("support_do_fun_things_incl_care");
        toBeKept.add("support_receive_care_incl_care");
        toBeKept.add("Treinstationdichtstbijzijnde");
        toBeKept.add("urbanization");
        toBeKept.add("Walkability.gs17_a_density_3000r");

        return toBeKept;

    }

    public static List<String> generateModelFromNodes(List<Node> nodes) {
        //List of attributes present in the Symptoms model
        List<String> list = new ArrayList<>();
        for (Node n : nodes) {
            list.add(n.getName());
        }
        return list;
    }
}
