package util;

import bayes.Node;

import java.util.ArrayList;
import java.util.List;

public class FilterAttributes {

    public static List<String> generateDESmodel() {
        //List of attributes present in the DES model
        List<String> list = new ArrayList<>();
        list.add("age");
        list.add("alat");
        list.add("albumin");
        list.add("amylase");
        list.add("alkaline_phosphatase");

        list.add("basophils");
        list.add("bilirubine");

        list.add("calcium");
        list.add("creatinine");
        list.add("crp");

        list.add("eosinophils");

        list.add("hemoglobin");
        list.add("inr");

        list.add("lc");
        list.add("ldh");
        list.add("leucocytes");
        list.add("lymphocytes");

        list.add("monocytes");

        list.add("neutrophils");

        list.add("platelets");
        list.add("potassium");

        list.add("sex");
        list.add("smoking_binary");
        list.add("sodium");

        return list;
    }

    public static List<String> generateSymptomsmodel() {
        //List of attributes present in the Symptoms model
        List<String> list = new ArrayList<>();
        list.add("age");
        list.add("alat");
        list.add("albumin");
        list.add("alkaline_phosphatase");
        list.add("amylase");
        list.add("angina");
        list.add("antibiotics");
        list.add("antidepressants");
        list.add("antihypertensives");

        list.add("backpain");
        list.add("basophils");
        list.add("bilirubine");

        list.add("calcium");
        list.add("caugh");
        list.add("cerebrovascular_disease");
        list.add("congestive_cardiac_failure");
        list.add("COPD");
        list.add("copd_inhalations");
        list.add("creatinine");
        list.add("crp");

        list.add("dementia");
        list.add("diabetes_melitus");
        list.add("dispositions");
        list.add("dizziness");
        list.add("dyspnoea");

        list.add("eosinophils");
        list.add("expositions");

        list.add("fatigue");
        list.add("fever");

        list.add("glucocorticoids");
        list.add("headache");
        list.add("heatflash");
        list.add("hemiplegia");
        list.add("hemoglobin");
        list.add("hemoptysis");
        list.add("horseness");

        list.add("inr");
        list.add("interstitial_disease");

        list.add("lc");
        list.add("ldh");
        list.add("leucocytes");
        list.add("liver_disease");
        list.add("lymphocytes");

        list.add("metastatic_disease");
        list.add("metformin");
        list.add("monocytes");
        list.add("myocardial_infarction");

        list.add("neutrophils");
        list.add("NR_CRP_GP");
        list.add("Nr_visits_GP");

        list.add("oedema");
        list.add("other_malig");
        list.add("otherpain");

        list.add("periferal_vascular_disease");
        list.add("platelets");
        list.add("pneumonia");
        list.add("potassium");

        list.add("renal_disease");
        list.add("reumatological_disease");

        list.add("tuberculosis");

        list.add("sarcoidosis");
        list.add("sex");
        list.add("smoking_binary");
        list.add("sodium");
        list.add("sumcci");

        list.add("weightloss");

        return list;
    }

    public static List<String> generateSimplemodel() {
        List<String> list = new ArrayList<>();
        list.add("age");
        list.add("lc");
        list.add("sex");
        list.add("smoking_binary");
        return list;
    }

    public static List<String> generateGeneral() {
        List<String> list = new ArrayList<>();
        list.add("age");
        list.add("lc");
        list.add("sex");
        return list;
    }

    public static List<String> generateSmoking() {
        List<String> list = new ArrayList<>();
        list.add("smoking_binary");
        return list;
    }

    public static List<String> generateSymptoms() {
        //List of attributes that are symptoms
        List<String> list = new ArrayList<>();
        list.add("angina");
        list.add("backpain");
        list.add("caugh");
        list.add("dispositions");
        list.add("dizziness");
        list.add("dyspnoea");
        list.add("expositions");
        list.add("fatigue");
        list.add("fever");
        list.add("headache");
        list.add("heatflash");
        list.add("hemoptysis");
        list.add("horseness");
        list.add("oedema");
        list.add("otherpain");
        list.add("pneumonia");
        list.add("weightloss");
        return list;
    }

    public static List<String> generateLabValues() {
        //List of attributes that are lab values
        List<String> list = new ArrayList<>();
        list.add("alat");
        list.add("albumin");
        list.add("alkaline_phosphatase");
        list.add("basophils");
        list.add("bilirubine");
        list.add("calcium");
        list.add("creatinine");
        list.add("crp");
        list.add("eosinophils");
        list.add("hemoglobin");
        list.add("inr");
        list.add("ldh");
        list.add("leucocytes");
        list.add("lymphocytes");
        list.add("monocytes");
        list.add("sodium");
        list.add("neutrophils");
        list.add("platelets");
        list.add("potassium");
        return list;
    }

    public static List<String> generateComorbs() {
        //List of attributes that are comorbs
        List<String> list = new ArrayList<>();
        list.add("antibiotics");
        list.add("antidepressants");
        list.add("antihypertensives");
        list.add("cerebrovascular_disease");
        list.add("congestive_cardiac_failure");
        list.add("COPD");
        list.add("copd_inhalations");
        list.add("dementia");
        list.add("diabetes_melitus");
        list.add("glucocorticoids");
        list.add("hemiplegia");
        list.add("interstitial_disease");
        list.add("liver_disease");
        list.add("metastatic_disease");
        list.add("metformin");
        list.add("myocardial_infarction");
        list.add("NR_CRP_GP");
        list.add("Nr_visits_GP");
        list.add("periferal_vascular_disease");
        list.add("other_malig");
        list.add("renal_disease");
        list.add("reumatological_disease");
        list.add("sarcoidosis");
        list.add("sumcci");
        list.add("tuberculosis");
        return list;
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
