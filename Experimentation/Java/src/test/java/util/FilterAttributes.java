package util;

import bayes.Node;

import java.util.ArrayList;
import java.util.List;

public class FilterAttributes {

    public static List<String> generateSunbeltModel(){
        List<String> toBeKept = new ArrayList<>();
        toBeKept.add("acquaintances");
        toBeKept.add("age");
        toBeKept.add("Bibliotheekdichtstbijzijnde");
        toBeKept.add("Bioscoopdichtstbijzijnde");
        toBeKept.add("Cafedichtstbijzijnde");
        toBeKept.add("caregivers");
        toBeKept.add("density");
        toBeKept.add("emotional_support_decisions_incl_care");
        toBeKept.add("emotional_support_talk_about_my_health_incl_care");
        toBeKept.add("extra_members");
        toBeKept.add("family_members");
        toBeKept.add("friends");
        toBeKept.add("GEZONDHEID_NU_CBS");
        toBeKept.add("geslacht_totaal");
        toBeKept.add("good_plus_relationship_total_incl_care");
        toBeKept.add("Greenspace.r1000m_all");
        toBeKept.add("Huisartspraktijkdichtstbijzijnde");
        toBeKept.add("Huishoudgrootte");
        toBeKept.add("Huurcoporatie");
        toBeKept.add("informational_support_incl_care");
        toBeKept.add("lbm");
        toBeKept.add("LID_CLUBS");
        toBeKept.add("Nederlandseachtergond");
        toBeKept.add("network_size_care");
        toBeKept.add("OPLEIDINGSNIVEAU");
        toBeKept.add("phone_internet_video_call_contact");
        toBeKept.add("physical_contact");
        toBeKept.add("practical_support_incl_care");
        toBeKept.add("RELATIE");
        toBeKept.add("Restaurantdichtstbijzijnde");
        toBeKept.add("same_sex");
        toBeKept.add("Supermarktdichtstbijzijnde");
        toBeKept.add("support_do_fun_things_incl_care");
        toBeKept.add("Treinstationdichtstbijzijnde");
        toBeKept.add("urbanization_cat");
        toBeKept.add("Walkability.WI7c_1719_500z");

        toBeKept.add("C_PHQ9_TOTAL");
        toBeKept.add("emotional_loneliness");
        toBeKept.add("lonelinessBinary");
        toBeKept.add("social_loneliness");

        return toBeKept;
    }

    public static List<String> generateFirstModel() {
        List<String> toBeKept = new ArrayList<>();
        toBeKept.add("acquaintances");
        toBeKept.add("age");
        toBeKept.add("Bibliotheekdichtstbijzijnde");
        toBeKept.add("Bioscoopdichtstbijzijnde");
        toBeKept.add("Cafedichtstbijzijnde");
        toBeKept.add("caregivers");
        toBeKept.add("density");
        toBeKept.add("difficult_relationship_total_incl_care");
        toBeKept.add("diversity_type_N");
        toBeKept.add("emotional_support_decisions_incl_care");
        toBeKept.add("emotional_support_talk_about_my_health_incl_care");
        toBeKept.add("extra_members");
        toBeKept.add("family_members");
        toBeKept.add("friends");
        toBeKept.add("GEZONDHEID_NU_CBS");
        toBeKept.add("good_plus_relationship_total_incl_care");
        toBeKept.add("Greenspace.r1000m_all");
        toBeKept.add("Huisartspraktijkdichtstbijzijnde");
        toBeKept.add("Huishoudgrootte");
        toBeKept.add("Huurcoporatie");
        toBeKept.add("informational_support_incl_care");
        toBeKept.add("lbm");
        toBeKept.add("LID_CLUBS");
        toBeKept.add("nearness_house");
        toBeKept.add("nearness_less_than_15_min");
        toBeKept.add("nearness_walking_distance");
        toBeKept.add("Nederlandseachtergond");
        toBeKept.add("network_size_care");
        toBeKept.add("Nietwestersemigratieachtergrond");
        toBeKept.add("OPLEIDINGSNIVEAU");
        toBeKept.add("phone_internet_video_call_contact");
        toBeKept.add("physical_contact");
        toBeKept.add("physical_phone_internet_video_call_contact");
        toBeKept.add("practical_support_incl_care");
        toBeKept.add("RELATIE");
        toBeKept.add("Restaurantdichtstbijzijnde");
        toBeKept.add("same_age");
        toBeKept.add("same_sex");
        toBeKept.add("Supermarktdichtstbijzijnde");
        toBeKept.add("support_do_fun_things_incl_care");
        toBeKept.add("support_give_care_incl_care");
        toBeKept.add("support_receive_care_incl_care");
        toBeKept.add("Treinstationdichtstbijzijnde");
        toBeKept.add("urbanization_cat");
        toBeKept.add("Walkability.WI7c_1719_500z");
        toBeKept.add("WERKSITUATIE");
        toBeKept.add("Westersemigratieachtergrond");

        toBeKept.add("C_PHQ9_TOTAL");
        toBeKept.add("emotional_loneliness");
        toBeKept.add("lonelinessBinary");
        toBeKept.add("mental_health_conditions");
        toBeKept.add("social_loneliness");
        return toBeKept;
    }

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
