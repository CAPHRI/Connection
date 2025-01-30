package util;

import bayes.Node;
import bayes.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static bayes.util.Util.createNode;

public class DAGBuilder {

    public static List<Node> createNoSymptomsNetworkLooseSymptomNodes() throws Exception {
        List<Node> nodes = new ArrayList<>();

//        Symptoms still need to be added as nodes in case they're present in the dataset, but they are lose and thus
//        ignored.
        nodes.add(Util.createNode("caugh", Node.AttributeType.bool));
        nodes.add(Util.createNode("dysonoea", Node.AttributeType.bool));
        nodes.add(Util.createNode("headache", Node.AttributeType.bool));
        nodes.add(Util.createNode("hemoptysis", Node.AttributeType.bool));
        nodes.add(Util.createNode("weightloss", Node.AttributeType.bool));
        nodes.add(Util.createNode("fatigue", Node.AttributeType.bool));
        nodes.add(Util.createNode("fever", Node.AttributeType.bool));
        nodes.add(Util.createNode("heatflash", Node.AttributeType.bool));
        nodes.add(Util.createNode("horseness", Node.AttributeType.bool));
        nodes.add(Util.createNode("angina", Node.AttributeType.bool));
        nodes.add(Util.createNode("backpain", Node.AttributeType.bool));
        nodes.add(Util.createNode("otherpain", Node.AttributeType.bool));
        nodes.add(Util.createNode("dizziness", Node.AttributeType.bool));
        nodes.add(Util.createNode("oedema", Node.AttributeType.bool));

        nodes.add(Util.createNode("abscess", Node.AttributeType.bool));
        nodes.add(Util.createNode("age", Node.AttributeType.real));
        nodes.add(Util.createNode("alat", Node.AttributeType.real, Arrays.asList("liver_disease")));
        nodes.add(Util.createNode("albumin", Node.AttributeType.real,
                Arrays.asList("lc", "metastatic_disease", "other_malig")));
        nodes.add(Util.createNode("alkaline_phosphatase", Node.AttributeType.real,
                Arrays.asList("liver_disease", "metastatic_disease")));
        nodes.add(Util.createNode("amylase", Node.AttributeType.real, Arrays.asList("liver_disease")));
        nodes.add(
                Util.createNode("antibiotics", Node.AttributeType.bool, Arrays.asList("abscess", "crp", "pneumonia")));
        nodes.add(Util.createNode("antidepressants", Node.AttributeType.bool, Arrays.asList("COPD", "dementia")));
        nodes.add(Util.createNode("antihypertensives", Node.AttributeType.bool,
                Arrays.asList("congestive_cardiac_failure", "periferal_vascular_disease")));

        nodes.add(Util.createNode("basophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("bilirubine", Node.AttributeType.real, Arrays.asList("liver_disease")));

        nodes.add(Util.createNode("calcium", Node.AttributeType.real,
                Arrays.asList("lc", "metastatic_disease", "other_malig")));
        nodes.add(Util.createNode("cerebrovascular_disease", Node.AttributeType.bool));
        nodes.add(Util.createNode("congestive_cardiac_failure", Node.AttributeType.bool,
                Arrays.asList("age", "smoking_binary")));
        nodes.add(Util.createNode("COPD", Node.AttributeType.bool, Arrays.asList("smoking_binary")));
        nodes.add(Util.createNode("copd_inhalations", Node.AttributeType.bool, Arrays.asList("COPD")));
        nodes.add(Util.createNode("creatinine", Node.AttributeType.real, Arrays.asList("renal_disease")));
        nodes.add(Util.createNode("crp", Node.AttributeType.real,
                Arrays.asList("lc", "abscess", "COPD", "metastatic_disease", "NR_CRP_GP",
                        "other_malig", "pneumonia")));

        nodes.add(Util.createNode("dementia", Node.AttributeType.bool));
        nodes.add(Util.createNode("diabetes_melitus", Node.AttributeType.bool, Arrays.asList("smoking_binary")));
        nodes.add(Util.createNode("dispositions", Node.AttributeType.bool));

        nodes.add(Util.createNode("eosinophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("expositions", Node.AttributeType.bool));

        nodes.add(Util.createNode("glucocorticoids", Node.AttributeType.bool,
                Arrays.asList("COPD", "interstitial_disease", "sarcoidosis")));

        nodes.add(Util.createNode("hemiplegia", Node.AttributeType.bool));
        nodes.add(Util.createNode("hemoglobin", Node.AttributeType.real,
                Arrays.asList("lc", "metastatic_disease", "other_malig")));

        nodes.add(Util.createNode("inr", Node.AttributeType.real, Arrays.asList("liver_disease")));
        nodes.add(Util.createNode("interstitial_disease", Node.AttributeType.bool));

        nodes.add(createNode("lc", Node.AttributeType.bool,
                Arrays.asList("age", "dispositions", "expositions", "other_malig",
                        "smoking_binary")));
        nodes.add(Util.createNode("ldh", Node.AttributeType.real, Arrays.asList("liver_disease")));
        nodes.add(Util.createNode("leucocytes", Node.AttributeType.real, Arrays.asList("lc", "COPD")));
        nodes.add(Util.createNode("liver_disease", Node.AttributeType.bool));
        nodes.add(Util.createNode("lymphocytes", Node.AttributeType.real, Arrays.asList("lc")));

        nodes.add(Util.createNode("marevan", Node.AttributeType.bool, Arrays.asList("periferal_vascular_disease")));
        nodes.add(
                Util.createNode("metastatic_disease", Node.AttributeType.bool,
                        Arrays.asList("age", "lc", "smoking_binary")));
        nodes.add(Util.createNode("metformin", Node.AttributeType.bool, Arrays.asList("diabetes_melitus")));
        nodes.add(Util.createNode("monocytes", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("myocardial_infarction", Node.AttributeType.bool, Arrays.asList("smoking_binary")));

        nodes.add(Util.createNode("neutrophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("NR_CRP_GP", Node.AttributeType.real,
                Arrays.asList("COPD", "Nr_visits_GP", "pneumonia")));
        nodes.add(Util.createNode("Nr_visits_GP", Node.AttributeType.real,
                Arrays.asList("age", "COPD", "pneumonia", "reumatological_disease", "sex")));

        nodes.add(Util.createNode("other_malig", Node.AttributeType.bool,
                Arrays.asList("age", "metastatic_disease", "smoking_binary")));

        nodes.add(Util.createNode("periferal_vascular_disease", Node.AttributeType.bool,
                Arrays.asList("smoking_binary")));
        nodes.add(Util.createNode("platelets", Node.AttributeType.real,
                Arrays.asList("lc", "metastatic_disease", "other_malig")));
        nodes.add(Util.createNode("pneumonia", Node.AttributeType.bool));
        nodes.add(Util.createNode("potassium", Node.AttributeType.real, Arrays.asList("renal_disease")));

        nodes.add(Util.createNode("renal_disease", Node.AttributeType.bool,
                Arrays.asList("diabetes_melitus", "periferal_vascular_disease")));
        nodes.add(Util.createNode("reumatological_disease", Node.AttributeType.bool));

        nodes.add(Util.createNode("sarcoidosis", Node.AttributeType.bool));
        nodes.add(Util.createNode("sex", Node.AttributeType.string));
        nodes.add(Util.createNode("smoking_binary", Node.AttributeType.string));
        nodes.add(Util.createNode("sodium", Node.AttributeType.real, Arrays.asList("lc", "renal_disease")));
        nodes.add(Util.createNode("sumcci", Node.AttributeType.real,
                Arrays.asList("age", "COPD", "cerebrovascular_disease", "congestive_cardiac_failure",
                        "dementia", "diabetes_melitus", "hemiplegia", "liver_disease",
                        "metastatic_disease", "myocardial_infarction", "other_malig",
                        "periferal_vascular_disease", "renal_disease",
                        "reumatological_disease")));

//        lose leftover attributes that aren't connected to the rest need to be included as they are present in the
//        dataset.
//        If they are not present in the network weka will complain
        nodes.add(Util.createNode("smoking_multilabel", Node.AttributeType.string));
        nodes.add(Util.createNode("pneumonias", Node.AttributeType.real));
        nodes.add(Util.createNode("aids_hiv", Node.AttributeType.bool));
        nodes.add(Util.createNode("tuberculosis", Node.AttributeType.bool));
        nodes.add(Util.createNode("pleural_disease", Node.AttributeType.bool));

        return nodes;
    }

    public static List<Node> createNoSymptomsNetwork() throws Exception {
        List<Node> nodes = new ArrayList<>();

        nodes.add(Util.createNode("age", Node.AttributeType.real));
        nodes.add(Util.createNode("alat", Node.AttributeType.real));
        nodes.add(Util.createNode("albumin", Node.AttributeType.real,
                Arrays.asList("lc")));
        nodes.add(Util.createNode("alkaline_phosphatase", Node.AttributeType.real));
        nodes.add(Util.createNode("amylase", Node.AttributeType.real));
        nodes.add(
                Util.createNode("antibiotics", Node.AttributeType.bool, Arrays.asList("crp")));
        nodes.add(Util.createNode("antidepressants", Node.AttributeType.bool, Arrays.asList("dementia")));
        nodes.add(Util.createNode("antihypertensives", Node.AttributeType.bool,
                Arrays.asList("congestive_cardiac_failure", "periferal_vascular_disease")));

        nodes.add(Util.createNode("basophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("bilirubine", Node.AttributeType.real));

        nodes.add(Util.createNode("calcium", Node.AttributeType.real,
                Arrays.asList("lc")));
        nodes.add(Util.createNode("cerebrovascular_disease", Node.AttributeType.bool));
        nodes.add(Util.createNode("congestive_cardiac_failure", Node.AttributeType.bool,
                Arrays.asList("age", "smoking_binary")));
        nodes.add(Util.createNode("copd_inhalations", Node.AttributeType.bool));
        nodes.add(Util.createNode("creatinine", Node.AttributeType.real));
        nodes.add(Util.createNode("crp", Node.AttributeType.real,
                Arrays.asList("lc")));

        nodes.add(Util.createNode("dementia", Node.AttributeType.bool));
        nodes.add(Util.createNode("diabetes_melitus", Node.AttributeType.bool, Arrays.asList("smoking_binary")));

        nodes.add(Util.createNode("eosinophils", Node.AttributeType.real, Arrays.asList("lc")));

        nodes.add(Util.createNode("glucocorticoids", Node.AttributeType.bool,
                Arrays.asList("interstitial_disease", "sarcoidosis")));

        nodes.add(Util.createNode("hemiplegia", Node.AttributeType.bool));
        nodes.add(Util.createNode("hemoglobin", Node.AttributeType.real,
                Arrays.asList("lc")));

        nodes.add(Util.createNode("inr", Node.AttributeType.real));
        nodes.add(Util.createNode("interstitial_disease", Node.AttributeType.bool));

        nodes.add(createNode("lc", Node.AttributeType.bool,
                Arrays.asList("age", "smoking_binary")));
        nodes.add(Util.createNode("ldh", Node.AttributeType.real));
        nodes.add(Util.createNode("leucocytes", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("lymphocytes", Node.AttributeType.real, Arrays.asList("lc")));

        nodes.add(Util.createNode("marevan", Node.AttributeType.bool, Arrays.asList("periferal_vascular_disease")));
        nodes.add(Util.createNode("metformin", Node.AttributeType.bool, Arrays.asList("diabetes_melitus")));
        nodes.add(Util.createNode("monocytes", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("myocardial_infarction", Node.AttributeType.bool, Arrays.asList("smoking_binary")));

        nodes.add(Util.createNode("neutrophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("Nr_visits_GP", Node.AttributeType.real,
                Arrays.asList("age", "reumatological_disease", "sex")));

        nodes.add(Util.createNode("periferal_vascular_disease", Node.AttributeType.bool,
                Arrays.asList("smoking_binary")));
        nodes.add(Util.createNode("platelets", Node.AttributeType.real,
                Arrays.asList("lc")));
        nodes.add(Util.createNode("potassium", Node.AttributeType.real));

        nodes.add(Util.createNode("reumatological_disease", Node.AttributeType.bool));

        nodes.add(Util.createNode("sarcoidosis", Node.AttributeType.bool));
        nodes.add(Util.createNode("sex", Node.AttributeType.string));
        nodes.add(Util.createNode("smoking_binary", Node.AttributeType.string));
        nodes.add(Util.createNode("sodium", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("sumcci", Node.AttributeType.real,
                Arrays.asList("age", "cerebrovascular_disease", "congestive_cardiac_failure",
                        "dementia", "diabetes_melitus", "hemiplegia", "myocardial_infarction",
                        "periferal_vascular_disease",
                        "reumatological_disease")));

//        lose leftover attributes that aren't connected to the rest need to be included as they are present in the
//        dataset.
//        If they are not present in the network weka will complain
        nodes.add(Util.createNode("smoking_multilabel", Node.AttributeType.string));
        nodes.add(Util.createNode("pneumonias", Node.AttributeType.real));
        nodes.add(Util.createNode("aids_hiv", Node.AttributeType.bool));
        nodes.add(Util.createNode("tuberculosis", Node.AttributeType.bool));
        nodes.add(Util.createNode("pleural_disease", Node.AttributeType.bool));

        return nodes;
    }

    public static List<Node> createWithSymptomsNetwork() throws Exception {
        List<Node> nodes = new ArrayList<>();

        nodes.add(Util.createNode("age", Node.AttributeType.real));
        nodes.add(Util.createNode("alat", Node.AttributeType.real, Arrays.asList("liver_disease", "lc", "age", "sex")));
        nodes.add(Util.createNode("albumin", Node.AttributeType.real,
                Arrays.asList("lc", "metastatic_disease", "other_malig", "crp", "age")));
        nodes.add(Util.createNode("alkaline_phosphatase", Node.AttributeType.real,
                Arrays.asList("liver_disease", "metastatic_disease", "age", "lc")));
        nodes.add(Util.createNode("amylase", Node.AttributeType.real, Arrays.asList("liver_disease", "age", "lc")));
        nodes.add(Util.createNode("angina", Node.AttributeType.bool, Arrays.asList("myocardial_infarction")));
        nodes.add(
                Util.createNode("antibiotics", Node.AttributeType.bool, Arrays.asList("crp", "pneumonia")));
        nodes.add(Util.createNode("antidepressants", Node.AttributeType.bool, Arrays.asList("COPD", "dementia")));
        nodes.add(Util.createNode("antihypertensives", Node.AttributeType.bool,
                Arrays.asList("congestive_cardiac_failure", "periferal_vascular_disease")));

        nodes.add(Util.createNode("backpain", Node.AttributeType.bool,
                Arrays.asList("age", "lc", "reumatological_disease")));
        nodes.add(Util.createNode("basophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("bilirubine", Node.AttributeType.real, Arrays.asList("liver_disease", "lc")));

        nodes.add(Util.createNode("calcium", Node.AttributeType.real,
                Arrays.asList("lc", "metastatic_disease", "other_malig")));
        nodes.add(Util.createNode("caugh", Node.AttributeType.bool,
                Arrays.asList("COPD", "lc", "interstitial_disease", "pneumonia", "tuberculosis")));
        nodes.add(Util.createNode("cerebrovascular_disease", Node.AttributeType.bool,
                Arrays.asList("smoking_binary", "age")));
        nodes.add(Util.createNode("congestive_cardiac_failure", Node.AttributeType.bool,
                Arrays.asList("age", "smoking_binary")));
        nodes.add(Util.createNode("COPD", Node.AttributeType.bool, Arrays.asList("smoking_binary")));
        nodes.add(Util.createNode("copd_inhalations", Node.AttributeType.bool, Arrays.asList("COPD")));
        nodes.add(Util.createNode("creatinine", Node.AttributeType.real, Arrays.asList("renal_disease", "age", "sex")));
        nodes.add(Util.createNode("crp", Node.AttributeType.real,
                Arrays.asList("COPD", "lc", "metastatic_disease", "NR_CRP_GP",
                        "other_malig", "pneumonia", "smoking_binary")));

        nodes.add(Util.createNode("dementia", Node.AttributeType.bool));
        nodes.add(Util.createNode("diabetes_melitus", Node.AttributeType.bool, Arrays.asList("smoking_binary")));
        nodes.add(Util.createNode("dispositions", Node.AttributeType.bool));
        nodes.add(Util.createNode("dizziness", Node.AttributeType.bool, Arrays.asList("cerebrovascular_disease")));
        nodes.add(Util.createNode("dyspnoea", Node.AttributeType.bool,
                Arrays.asList("COPD", "lc", "pneumonia", "tuberculosis")));

        nodes.add(Util.createNode("eosinophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("expositions", Node.AttributeType.bool));

        nodes.add(
                Util.createNode("fatigue", Node.AttributeType.bool,
                        Arrays.asList("calcium", "hemoglobin", "pneumonia", "reumatological_disease", "lc",
                                "other_malig", "metastatic_disease", "renal_disease")));
        nodes.add(Util.createNode("fever", Node.AttributeType.bool,
                Arrays.asList("lc", "pneumonia", "reumatological_disease", "other_malig", "metastatic_disease")));

        nodes.add(Util.createNode("glucocorticoids", Node.AttributeType.bool,
                Arrays.asList("COPD", "interstitial_disease", "sarcoidosis")));
        nodes.add(Util.createNode("headache", Node.AttributeType.bool, Arrays.asList("cerebrovascular_disease")));
        ;
        nodes.add(Util.createNode("heatflash", Node.AttributeType.bool,
                Arrays.asList("lc", "reumatological_disease", "other_malig", "metastatic_disease")));
        nodes.add(Util.createNode("hemiplegia", Node.AttributeType.bool, Arrays.asList("cerebrovascular_disease")));
        nodes.add(Util.createNode("hemoglobin", Node.AttributeType.real,
                Arrays.asList("lc", "metastatic_disease", "other_malig", "smoking_binary", "sex")));
        nodes.add(Util.createNode("hemoptysis", Node.AttributeType.bool, Arrays.asList("caugh", "lc")));
        nodes.add(Util.createNode("horseness", Node.AttributeType.bool, Arrays.asList("caugh", "lc")));

        nodes.add(Util.createNode("inr", Node.AttributeType.real, Arrays.asList("liver_disease", "lc")));
        nodes.add(Util.createNode("interstitial_disease", Node.AttributeType.bool));

        nodes.add(createNode("lc", Node.AttributeType.bool,
                Arrays.asList("age", "COPD", "dispositions", "expositions", "other_malig", "smoking_binary")));
        nodes.add(Util.createNode("ldh", Node.AttributeType.real, Arrays.asList("liver_disease", "lc", "age")));
        nodes.add(Util.createNode("leucocytes",
                Node.AttributeType.real, Arrays.asList("COPD", "lc", "smoking_binary")));
        nodes.add(Util.createNode("liver_disease", Node.AttributeType.bool));
        nodes.add(Util.createNode("lymphocytes", Node.AttributeType.real, Arrays.asList("lc", "smoking_binary")));

        nodes.add(Util.createNode("marevan", Node.AttributeType.bool, Arrays.asList("periferal_vascular_disease")));
        nodes.add(Util.createNode("metastatic_disease", Node.AttributeType.bool,
                Arrays.asList("age", "lc", "smoking_binary")));
        nodes.add(Util.createNode("metformin", Node.AttributeType.bool, Arrays.asList("diabetes_melitus")));
        nodes.add(Util.createNode("monocytes", Node.AttributeType.real, Arrays.asList("lc", "smoking_binary")));
        nodes.add(Util.createNode("myocardial_infarction", Node.AttributeType.bool, Arrays.asList("smoking_binary")));

        nodes.add(Util.createNode("neutrophils", Node.AttributeType.real, Arrays.asList("lc", "smoking_binary")));
        nodes.add(Util.createNode("NR_CRP_GP", Node.AttributeType.real,
                Arrays.asList("COPD", "Nr_visits_GP", "pneumonia")));
        nodes.add(Util.createNode("Nr_visits_GP", Node.AttributeType.real,
                Arrays.asList("age", "caugh", "COPD", "dyspnoea", "fatigue", "heatflash", "pneumonia",
                        "reumatological_disease", "sex", "weightloss")));

        nodes.add(Util.createNode("oedema", Node.AttributeType.bool,
                Arrays.asList("congestive_cardiac_failure", "renal_disease", "reumatological_disease")));
        nodes.add(Util.createNode("other_malig", Node.AttributeType.bool,
                Arrays.asList("age", "metastatic_disease", "smoking_binary")));
        nodes.add(Util.createNode("otherpain", Node.AttributeType.bool, Arrays.asList("reumatological_disease")));

        nodes.add(Util.createNode("periferal_vascular_disease", Node.AttributeType.bool,
                Arrays.asList("smoking_binary")));
        nodes.add(Util.createNode("platelets", Node.AttributeType.real,
                Arrays.asList("lc", "metastatic_disease", "other_malig", "sex", "smoking_binary")));
        nodes.add(Util.createNode("pneumonia", Node.AttributeType.bool, Arrays.asList("COPD", "smoking_binary")));

        nodes.add(Util.createNode("potassium", Node.AttributeType.real, Arrays.asList("renal_disease", "creatinine")));

        nodes.add(Util.createNode("renal_disease", Node.AttributeType.bool,
                Arrays.asList("diabetes_melitus", "periferal_vascular_disease")));
        nodes.add(Util.createNode("reumatological_disease", Node.AttributeType.bool));

        nodes.add(Util.createNode("sarcoidosis", Node.AttributeType.bool));
        nodes.add(Util.createNode("sex", Node.AttributeType.string));
        nodes.add(Util.createNode("smoking_binary", Node.AttributeType.string));
        nodes.add(Util.createNode("sodium", Node.AttributeType.real,
                Arrays.asList("lc", "renal_disease", "creatinine")));
        nodes.add(Util.createNode("sumcci", Node.AttributeType.real,
                Arrays.asList("age", "COPD", "cerebrovascular_disease", "congestive_cardiac_failure",
                        "dementia", "diabetes_melitus", "hemiplegia", "liver_disease",
                        "metastatic_disease", "myocardial_infarction", "other_malig",
                        "periferal_vascular_disease", "renal_disease",
                        "reumatological_disease")));

        nodes.add(Util.createNode("tuberculosis", Node.AttributeType.string));

        nodes.add(Util.createNode("weightloss", Node.AttributeType.bool,
                Arrays.asList("lc", "metastatic_disease", "other_malig", "reumatological_disease")));

        return nodes;
    }

    public static List<Node> createNaiveBayesNetwork() throws Exception {
        List<Node> nodes = new ArrayList<>();
        nodes.add(createNode("lc", Node.AttributeType.bool));
        nodes.add(Util.createNode("sex", Node.AttributeType.string, Arrays.asList("lc")));
        nodes.add(Util.createNode("age", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("smoking_binary", Node.AttributeType.string, Arrays.asList("lc")));
        nodes.add(Util.createNode("smoking_multilabel", Node.AttributeType.string, Arrays.asList("lc")));
        nodes.add(Util.createNode("expositions", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("dispositions", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("pneumonia", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("caugh", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("dysonoea", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("headache", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("hemoptysis", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("weightloss", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("fatigue", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("fever", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("heatflash", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("horseness", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("angina", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("backpain", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("otherpain", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("dizziness", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("oedema", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("alat", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("albumin", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("amylase", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("alkaline_phosphatase", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("basophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("bilirubine", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("crp", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("calcium", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("eosinophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("hemoglobin", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("inr", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("potassium", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("creatinine", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("ldh", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("leucocytes", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("lymphocytes", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("monocytes", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("sodium", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("neutrophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("platelets", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("pneumonias", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("myocardial_infarction", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("congestive_cardiac_failure", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("periferal_vascular_disease", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("cerebrovascular_disease", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("dementia", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("COPD", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("reumatological_disease", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("liver_disease", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("diabetes_melitus", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("hemiplegia", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("renal_disease", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("other_malig", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("metastatic_disease", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("aids_hiv", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("tuberculosis", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("sarcoidosis", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("interstitial_disease", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("abscess", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("pleural_disease", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("sumcci", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("Nr_visits_GP", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("NR_CRP_GP", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("antibiotics", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("glucocorticoids", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("copd_inhalations", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("metformin", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("marevan", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("antidepressants", Node.AttributeType.bool, Arrays.asList("lc")));
        nodes.add(Util.createNode("antihypertensives", Node.AttributeType.bool, Arrays.asList("lc")));

        return nodes;
    }

    public static List<Node> createOnlylab_Network() throws Exception {
        List<Node> nodes = new ArrayList<>();

        nodes.add(createNode("lc", Node.AttributeType.bool,
                Arrays.asList("age", "smoking_binary")));

        nodes.add(Util.createNode("sex", Node.AttributeType.string));
        nodes.add(Util.createNode("smoking_binary", Node.AttributeType.string));
        nodes.add(Util.createNode("age", Node.AttributeType.real));

        nodes.add(Util.createNode("alat", Node.AttributeType.real));
        nodes.add(Util.createNode("amylase", Node.AttributeType.real));
        nodes.add(Util.createNode("alkaline_phosphatase", Node.AttributeType.real));
        nodes.add(Util.createNode("bilirubine", Node.AttributeType.real));
        nodes.add(Util.createNode("creatinine", Node.AttributeType.real));
        nodes.add(Util.createNode("inr", Node.AttributeType.real));
        nodes.add(Util.createNode("ldh", Node.AttributeType.real));
        nodes.add(Util.createNode("potassium", Node.AttributeType.real));

        nodes.add(Util.createNode("albumin", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("basophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("calcium", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("crp", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("eosinophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("hemoglobin", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("leucocytes", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("lymphocytes", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("monocytes", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("neutrophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("platelets", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("sodium", Node.AttributeType.real, Arrays.asList("lc")));

        return nodes;
    }

    public static List<Node> createDESNetwork() throws Exception {
        List<Node> nodes = new ArrayList<>();
        nodes.add(Util.createNode("age", Node.AttributeType.real));
        nodes.add(Util.createNode("alat", Node.AttributeType.real, Arrays.asList("age", "lc", "sex")));
        nodes.add(Util.createNode("albumin", Node.AttributeType.real, Arrays.asList("age", "crp", "lc")));
        nodes.add(Util.createNode("alkaline_phosphatase", Node.AttributeType.real, Arrays.asList("age", "lc")));
        nodes.add(Util.createNode("amylase", Node.AttributeType.real, Arrays.asList("age", "lc")));

        nodes.add(Util.createNode("basophils", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("bilirubine", Node.AttributeType.real, Arrays.asList("lc")));

        nodes.add(Util.createNode("calcium", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(Util.createNode("creatinine", Node.AttributeType.real, Arrays.asList("age", "sex")));
        nodes.add(Util.createNode("crp", Node.AttributeType.real, Arrays.asList("lc", "smoking_binary")));

        nodes.add(Util.createNode("eosinophils", Node.AttributeType.real, Arrays.asList("lc")));

        nodes.add(Util.createNode("hemoglobin", Node.AttributeType.real, Arrays.asList("lc", "sex", "smoking_binary")));

        nodes.add(Util.createNode("inr", Node.AttributeType.real, Arrays.asList("lc")));
        nodes.add(createNode("lc", Node.AttributeType.bool, Arrays.asList("age", "smoking_binary")));
        nodes.add(Util.createNode("ldh", Node.AttributeType.real, Arrays.asList("age", "lc")));
        nodes.add(Util.createNode("leucocytes", Node.AttributeType.real, Arrays.asList("lc", "smoking_binary")));
        nodes.add(Util.createNode("lymphocytes", Node.AttributeType.real, Arrays.asList("lc", "smoking_binary")));

        nodes.add(Util.createNode("monocytes", Node.AttributeType.real, Arrays.asList("lc", "smoking_binary")));

        nodes.add(Util.createNode("neutrophils", Node.AttributeType.real, Arrays.asList("lc", "smoking_binary")));

        nodes.add(Util.createNode("platelets", Node.AttributeType.real, Arrays.asList("lc", "sex", "smoking_binary")));

        nodes.add(Util.createNode("potassium", Node.AttributeType.real, Arrays.asList("creatinine")));

        nodes.add(Util.createNode("sex", Node.AttributeType.string));
        nodes.add(Util.createNode("smoking_binary", Node.AttributeType.string));
        nodes.add(Util.createNode("sodium", Node.AttributeType.real, Arrays.asList("creatinine", "lc")));
        return nodes;

    }

    public static List<Node> createSimpleNetwork() throws Exception {
        List<Node> nodes = new ArrayList<>();
        nodes.add(Util.createNode("age", Node.AttributeType.real));
        nodes.add(createNode("lc", Node.AttributeType.bool, Arrays.asList("age", "smoking_binary")));
        nodes.add(Util.createNode("sex", Node.AttributeType.string));
        nodes.add(Util.createNode("smoking_binary", Node.AttributeType.string));
        return nodes;

    }


}
