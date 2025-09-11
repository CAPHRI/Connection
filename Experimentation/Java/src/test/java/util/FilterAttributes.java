package util;

import bayes.Node;

import java.util.ArrayList;
import java.util.List;

public class FilterAttributes {

    public static List<String> generateManuscriptModelBaseline(){
        List<String> toBeKept = new ArrayList<>();
        toBeKept.add("aandoeningen_bewegingsapparaat");
        toBeKept.add("acquaintances");
        toBeKept.add("ADL_PERC_OVERALL_IMP");
        toBeKept.add("age");
        toBeKept.add("ambivalent_relationship_care");
        toBeKept.add("Bibliotheekdichtstbijzijnde");
        toBeKept.add("BMI_cat");
        toBeKept.add("Cafedichtstbijzijnde");
        toBeKept.add("Cafetariadichtstbijzijnde");
        toBeKept.add("caregivers");
        toBeKept.add("C_IPAQ_SCORE");
        toBeKept.add("C_PHQ9_TOTAL");
        toBeKept.add("C_ROKEN");
        toBeKept.add("emotional_support_decisions_incl_care");
        toBeKept.add("emotional_support_talk_about_my_health_incl_care");
        toBeKept.add("family_members");
        toBeKept.add("friends");
        toBeKept.add("GEZONDHEID_NU_CBS");
        toBeKept.add("geslacht_totaal");
        toBeKept.add("good_plus_relationship_total_incl_care");
        toBeKept.add("Greenspace.r1000m_all");
        toBeKept.add("hart_en_vaatziekten");
        toBeKept.add("Herfindahl");
        toBeKept.add("Huisartspraktijkdichtstbijzijnde");
        toBeKept.add("Huurcoporatie");
        toBeKept.add("informational_support_incl_care");
        toBeKept.add("lbm");
        toBeKept.add("LID_CLUBS");
        toBeKept.add("lonelinessBinary");
        toBeKept.add("luchtwegaandoeningen");
        toBeKept.add("LYING_HoursPerDay");
        toBeKept.add("metabole_aandoeningen");
        toBeKept.add("Museadichtstbijzijnde");
        toBeKept.add("Nederlandseachtergond");
        toBeKept.add("network_size_care");
        toBeKept.add("nearness_more_than_30_min");
        toBeKept.add("neurologische_aandoeningen");
        toBeKept.add("Nietwestersemigratieachtergrond");
        toBeKept.add("OPLEIDINGSNIVEAU");
        toBeKept.add("overige_aandoeningen");
        toBeKept.add("phone_internet_video_call_contact");
        toBeKept.add("physical_contact");
        toBeKept.add("pov_p_17");
        toBeKept.add("practical_support_incl_care");
        toBeKept.add("psychische_aandoeningen");
        toBeKept.add("RELATIE");
        toBeKept.add("Restaurantdichtstbijzijnde");
        toBeKept.add("same_sex");
        toBeKept.add("single_person_household");
        toBeKept.add("SITTING_HoursPerDay");
        toBeKept.add("strain_critique_incl_care");
        toBeKept.add("strain_demanding_incl_care");
        toBeKept.add("strain_taxing_incl_care");
        toBeKept.add("Supermarktdichtstbijzijnde");
        toBeKept.add("support_do_fun_things_incl_care");
        toBeKept.add("Treinstationdichtstbijzijnde");
        toBeKept.add("urbanization_cat");
        toBeKept.add("Walkability.WI7c_1719_500z");
        toBeKept.add("Westersemigratieachtergrond");



        return toBeKept;
    }

    public static List<String> generateManuscriptModelBeperktNetwerk(){
        List<String> toBeKept = new ArrayList<>();
        toBeKept.add("aandoeningen_bewegingsapparaat");
        toBeKept.add("ADL_PERC_OVERALL_IMP");
        toBeKept.add("age");
        toBeKept.add("ambivalent_relationship_care");
        toBeKept.add("Bibliotheekdichtstbijzijnde");
        toBeKept.add("BMI_cat");
        toBeKept.add("Cafedichtstbijzijnde");
        toBeKept.add("Cafetariadichtstbijzijnde");
        toBeKept.add("C_IPAQ_SCORE");
        toBeKept.add("C_PHQ9_TOTAL");
        toBeKept.add("C_ROKEN");
        toBeKept.add("GEZONDHEID_NU_CBS");
        toBeKept.add("geslacht_totaal");
        toBeKept.add("good_plus_relationship_total_incl_care");
        toBeKept.add("Greenspace.r1000m_all");
        toBeKept.add("hart_en_vaatziekten");
        toBeKept.add("Huisartspraktijkdichtstbijzijnde");
        toBeKept.add("Huurcoporatie");
        toBeKept.add("lbm");
        toBeKept.add("LID_CLUBS");
        toBeKept.add("lonelinessBinary");
        toBeKept.add("luchtwegaandoeningen");
        toBeKept.add("LYING_HoursPerDay");
        toBeKept.add("metabole_aandoeningen");
        toBeKept.add("Museadichtstbijzijnde");
        toBeKept.add("Nederlandseachtergond");
        toBeKept.add("neurologische_aandoeningen");
        toBeKept.add("Nietwestersemigratieachtergrond");
        toBeKept.add("OPLEIDINGSNIVEAU");
        toBeKept.add("overige_aandoeningen");
        toBeKept.add("pov_p_17");
        toBeKept.add("psychische_aandoeningen");
        toBeKept.add("RELATIE");
        toBeKept.add("Restaurantdichtstbijzijnde");
        toBeKept.add("same_sex");
        toBeKept.add("single_person_household");
        toBeKept.add("SITTING_HoursPerDay");
        toBeKept.add("strain_critique_incl_care");
        toBeKept.add("strain_demanding_incl_care");
        toBeKept.add("strain_taxing_incl_care");
        toBeKept.add("Supermarktdichtstbijzijnde");
        toBeKept.add("Treinstationdichtstbijzijnde");
        toBeKept.add("urbanization_cat");
        toBeKept.add("Walkability.WI7c_1719_500z");
        toBeKept.add("Westersemigratieachtergrond");

        return toBeKept;
    }

    public static List<String> generateManuscriptModelGeenAandoeningen(){
        List<String> toBeKept = new ArrayList<>();
        toBeKept.add("acquaintances");
        toBeKept.add("ADL_PERC_OVERALL_IMP");
        toBeKept.add("age");
        toBeKept.add("ambivalent_relationship_care");
        toBeKept.add("Bibliotheekdichtstbijzijnde");
        toBeKept.add("BMI_cat");
        toBeKept.add("Cafedichtstbijzijnde");
        toBeKept.add("Cafetariadichtstbijzijnde");
        toBeKept.add("caregivers");
        toBeKept.add("C_IPAQ_SCORE");
        toBeKept.add("C_PHQ9_TOTAL");
        toBeKept.add("C_ROKEN");
        toBeKept.add("emotional_support_decisions_incl_care");
        toBeKept.add("emotional_support_talk_about_my_health_incl_care");
        toBeKept.add("family_members");
        toBeKept.add("friends");
        toBeKept.add("GEZONDHEID_NU_CBS");
        toBeKept.add("geslacht_totaal");
        toBeKept.add("good_plus_relationship_total_incl_care");
        toBeKept.add("Greenspace.r1000m_all");
        toBeKept.add("Herfindahl");
        toBeKept.add("Huisartspraktijkdichtstbijzijnde");
        toBeKept.add("Huurcoporatie");
        toBeKept.add("informational_support_incl_care");
        toBeKept.add("lbm");
        toBeKept.add("LID_CLUBS");
        toBeKept.add("lonelinessBinary");
        toBeKept.add("LYING_HoursPerDay");
        toBeKept.add("Museadichtstbijzijnde");
        toBeKept.add("Nederlandseachtergond");
        toBeKept.add("network_size_care");
        toBeKept.add("nearness_more_than_30_min");;
        toBeKept.add("Nietwestersemigratieachtergrond");
        toBeKept.add("OPLEIDINGSNIVEAU");
        toBeKept.add("phone_internet_video_call_contact");
        toBeKept.add("physical_contact");
        toBeKept.add("pov_p_17");
        toBeKept.add("practical_support_incl_care");
        toBeKept.add("RELATIE");
        toBeKept.add("Restaurantdichtstbijzijnde");
        toBeKept.add("same_sex");
        toBeKept.add("single_person_household");
        toBeKept.add("SITTING_HoursPerDay");
        toBeKept.add("strain_critique_incl_care");
        toBeKept.add("strain_demanding_incl_care");
        toBeKept.add("strain_taxing_incl_care");
        toBeKept.add("Supermarktdichtstbijzijnde");
        toBeKept.add("support_do_fun_things_incl_care");
        toBeKept.add("Treinstationdichtstbijzijnde");
        toBeKept.add("urbanization_cat");
        toBeKept.add("Walkability.WI7c_1719_500z");
        toBeKept.add("Westersemigratieachtergrond");

        return toBeKept;
    }

    public static List<String> generateManuscriptModelNoCaregivers(){
        List<String> toBeKept = new ArrayList<>();
        toBeKept.add("aandoeningen_bewegingsapparaat");
        toBeKept.add("acquaintances");
        toBeKept.add("ADL_PERC_OVERALL_IMP");
        toBeKept.add("age");
        toBeKept.add("ambivalent_relationship_care");
        toBeKept.add("Bibliotheekdichtstbijzijnde");
        toBeKept.add("BMI_cat");
        toBeKept.add("Cafedichtstbijzijnde");
        toBeKept.add("Cafetariadichtstbijzijnde");
        toBeKept.add("C_IPAQ_SCORE");
        toBeKept.add("C_PHQ9_TOTAL");
        toBeKept.add("C_ROKEN");
        toBeKept.add("emotional_support_decisions_incl_care");
        toBeKept.add("emotional_support_talk_about_my_health_incl_care");
        toBeKept.add("family_members");
        toBeKept.add("friends");
        toBeKept.add("GEZONDHEID_NU_CBS");
        toBeKept.add("geslacht_totaal");
        toBeKept.add("good_plus_relationship_total_incl_care");
        toBeKept.add("Greenspace.r1000m_all");
        toBeKept.add("hart_en_vaatziekten");
        toBeKept.add("Herfindahl");
        toBeKept.add("Huisartspraktijkdichtstbijzijnde");
        toBeKept.add("Huurcoporatie");
        toBeKept.add("informational_support_incl_care");
        toBeKept.add("lbm");
        toBeKept.add("LID_CLUBS");
        toBeKept.add("lonelinessBinary");
        toBeKept.add("luchtwegaandoeningen");
        toBeKept.add("LYING_HoursPerDay");
        toBeKept.add("metabole_aandoeningen");
        toBeKept.add("Museadichtstbijzijnde");
        toBeKept.add("Nederlandseachtergond");
        toBeKept.add("nearness_more_than_30_min");
        toBeKept.add("neurologische_aandoeningen");
        toBeKept.add("Nietwestersemigratieachtergrond");
        toBeKept.add("OPLEIDINGSNIVEAU");
        toBeKept.add("overige_aandoeningen");
        toBeKept.add("phone_internet_video_call_contact");
        toBeKept.add("physical_contact");
        toBeKept.add("pov_p_17");
        toBeKept.add("practical_support_incl_care");
        toBeKept.add("psychische_aandoeningen");
        toBeKept.add("RELATIE");
        toBeKept.add("Restaurantdichtstbijzijnde");
        toBeKept.add("same_sex");
        toBeKept.add("single_person_household");
        toBeKept.add("SITTING_HoursPerDay");
        toBeKept.add("strain_critique_incl_care");
        toBeKept.add("strain_demanding_incl_care");
        toBeKept.add("strain_taxing_incl_care");
        toBeKept.add("Supermarktdichtstbijzijnde");
        toBeKept.add("support_do_fun_things_incl_care");
        toBeKept.add("Treinstationdichtstbijzijnde");
        toBeKept.add("urbanization_cat");
        toBeKept.add("Walkability.WI7c_1719_500z");
        toBeKept.add("Westersemigratieachtergrond");

        return toBeKept;
    }

    public static List<String> generateManuscriptModelNoDemographics(){
        List<String> toBeKept = new ArrayList<>();
        toBeKept.add("aandoeningen_bewegingsapparaat");
        toBeKept.add("acquaintances");
        toBeKept.add("ADL_PERC_OVERALL_IMP");
        toBeKept.add("ambivalent_relationship_care");
        toBeKept.add("Bibliotheekdichtstbijzijnde");
        toBeKept.add("Cafedichtstbijzijnde");
        toBeKept.add("Cafetariadichtstbijzijnde");
        toBeKept.add("caregivers");
        toBeKept.add("C_IPAQ_SCORE");
        toBeKept.add("C_PHQ9_TOTAL");
        toBeKept.add("C_ROKEN");
        toBeKept.add("emotional_support_decisions_incl_care");
        toBeKept.add("emotional_support_talk_about_my_health_incl_care");
        toBeKept.add("family_members");
        toBeKept.add("friends");
        toBeKept.add("GEZONDHEID_NU_CBS");
        toBeKept.add("good_plus_relationship_total_incl_care");
        toBeKept.add("Greenspace.r1000m_all");
        toBeKept.add("hart_en_vaatziekten");
        toBeKept.add("Herfindahl");
        toBeKept.add("Huisartspraktijkdichtstbijzijnde");
        toBeKept.add("Huurcoporatie");
        toBeKept.add("informational_support_incl_care");
        toBeKept.add("lbm");
        toBeKept.add("LID_CLUBS");
        toBeKept.add("lonelinessBinary");
        toBeKept.add("luchtwegaandoeningen");
        toBeKept.add("LYING_HoursPerDay");
        toBeKept.add("metabole_aandoeningen");
        toBeKept.add("Museadichtstbijzijnde");
        toBeKept.add("Nederlandseachtergond");
        toBeKept.add("network_size_care");
        toBeKept.add("nearness_more_than_30_min");
        toBeKept.add("neurologische_aandoeningen");
        toBeKept.add("Nietwestersemigratieachtergrond");
        toBeKept.add("overige_aandoeningen");
        toBeKept.add("phone_internet_video_call_contact");
        toBeKept.add("physical_contact");
        toBeKept.add("pov_p_17");
        toBeKept.add("practical_support_incl_care");
        toBeKept.add("psychische_aandoeningen");
        toBeKept.add("Restaurantdichtstbijzijnde");
        toBeKept.add("same_sex");
        toBeKept.add("SITTING_HoursPerDay");
        toBeKept.add("strain_critique_incl_care");
        toBeKept.add("strain_demanding_incl_care");
        toBeKept.add("strain_taxing_incl_care");
        toBeKept.add("Supermarktdichtstbijzijnde");
        toBeKept.add("support_do_fun_things_incl_care");
        toBeKept.add("Treinstationdichtstbijzijnde");
        toBeKept.add("urbanization_cat");
        toBeKept.add("Walkability.WI7c_1719_500z");
        toBeKept.add("Westersemigratieachtergrond");

        return toBeKept;
    }

    public static List<String> generateManuscriptModelNoLBM(){
        List<String> toBeKept = new ArrayList<>();
        toBeKept.add("aandoeningen_bewegingsapparaat");
        toBeKept.add("acquaintances");
        toBeKept.add("ADL_PERC_OVERALL_IMP");
        toBeKept.add("age");
        toBeKept.add("ambivalent_relationship_care");
        toBeKept.add("Bibliotheekdichtstbijzijnde");
        toBeKept.add("BMI_cat");
        toBeKept.add("Cafedichtstbijzijnde");
        toBeKept.add("Cafetariadichtstbijzijnde");
        toBeKept.add("caregivers");
        toBeKept.add("C_IPAQ_SCORE");
        toBeKept.add("C_PHQ9_TOTAL");
        toBeKept.add("C_ROKEN");
        toBeKept.add("emotional_support_decisions_incl_care");
        toBeKept.add("emotional_support_talk_about_my_health_incl_care");
        toBeKept.add("family_members");
        toBeKept.add("friends");
        toBeKept.add("GEZONDHEID_NU_CBS");
        toBeKept.add("geslacht_totaal");
        toBeKept.add("good_plus_relationship_total_incl_care");
        toBeKept.add("Greenspace.r1000m_all");
        toBeKept.add("hart_en_vaatziekten");
        toBeKept.add("Herfindahl");
        toBeKept.add("Huisartspraktijkdichtstbijzijnde");
        toBeKept.add("Huurcoporatie");
        toBeKept.add("informational_support_incl_care");
        toBeKept.add("LID_CLUBS");
        toBeKept.add("lonelinessBinary");
        toBeKept.add("luchtwegaandoeningen");
        toBeKept.add("LYING_HoursPerDay");
        toBeKept.add("metabole_aandoeningen");
        toBeKept.add("Museadichtstbijzijnde");
        toBeKept.add("Nederlandseachtergond");
        toBeKept.add("network_size_care");
        toBeKept.add("nearness_more_than_30_min");
        toBeKept.add("neurologische_aandoeningen");
        toBeKept.add("Nietwestersemigratieachtergrond");
        toBeKept.add("OPLEIDINGSNIVEAU");
        toBeKept.add("overige_aandoeningen");
        toBeKept.add("phone_internet_video_call_contact");
        toBeKept.add("physical_contact");
        toBeKept.add("pov_p_17");
        toBeKept.add("practical_support_incl_care");
        toBeKept.add("psychische_aandoeningen");
        toBeKept.add("RELATIE");
        toBeKept.add("Restaurantdichtstbijzijnde");
        toBeKept.add("same_sex");
        toBeKept.add("single_person_household");
        toBeKept.add("SITTING_HoursPerDay");
        toBeKept.add("strain_critique_incl_care");
        toBeKept.add("strain_demanding_incl_care");
        toBeKept.add("strain_taxing_incl_care");
        toBeKept.add("Supermarktdichtstbijzijnde");
        toBeKept.add("support_do_fun_things_incl_care");
        toBeKept.add("Treinstationdichtstbijzijnde");
        toBeKept.add("urbanization_cat");
        toBeKept.add("Walkability.WI7c_1719_500z");
        toBeKept.add("Westersemigratieachtergrond");

        return toBeKept;
    }

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

    public static List<String> generateLogRegModel(){
        List<String> toBeKept = new ArrayList<>();
        toBeKept.add("lbm");
        toBeKept.add("OPLEIDINGSNIVEAU");
        toBeKept.add("age");
        toBeKept.add("acquaintances");
        toBeKept.add("caregivers");
        toBeKept.add("emotional_support_talk_about_my_health_incl_care");
        toBeKept.add("density");
        toBeKept.add("C_PHQ9_TOTAL");
        toBeKept.add("GEZONDHEID_NU_CBS");
        toBeKept.add("lonelinessBinary");

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
