import pandas


def discretize(data):
    data = discretizeNetworkSize(data)
    data = discretizeAcquaintances(data)
    data = discretizeAge(data)
    data= discretizeBMI(data)
    data = discretize_C_Roken(data)
    data = discretize_C_IPAQ_SCORE(data)
    data = discretizeDichstbijzijnde(data, "Bibliotheek")
    data = discretizeDichstbijzijnde(data, "Bioscoop")
    data = discretizeDichstbijzijnde(data, "Cafe")
    data = discretizeDichstbijzijnde(data, "Cafetaria")
    data = discretizeCaregivers(data)
    data = discretizeDifficult_relationship_total_incl_care(data)
    data = discretizeEmotional_support_decisions_incl_care(data)
    data = discretizeEmotional_support_talk_about_my_health_incl_care(data)
    data = discretizeExtra_members(data)
    data = discretizeFriends(data)
    data = discretizeGEZONDHEID_NU_CBS(data)
    data = discretizeDichstbijzijnde(data, "Huisartspraktijk")
    data = discretizeHuishoudgrootte(data)
    data = discretizeHuurcoporatie(data)
    data = discretizeInformational_support_incl_care(data)
    data = discretizeLBM(data)
    data = discretizeNearness_house(data)
    data = discretizeNearness_less_than_15_min(data)
    data = discretizeNearness_more_than_30_min(data)
    data = discretizeNearness_walking_distance(data)
    data = discretizeNederlandseachtergrond(data)
    data = discretizeNietwestersemigratieachtergrond(data)
    data = discretizePhysical_contact(data)
    data = discretizePhone_internet_video_call_contact(data)
    data = discretizePhysical_phone_internet_video_call_contact(data)
    data = discretizePractical_support_incl_care(data)
    data = discretizeDichstbijzijnde(data, "Restaurant")
    data = discretizeDichstbijzijnde(data, "Supermarkt")
    data = discretizeSupport_do_fun_things_incl_care(data)
    data = discretizeSupport_give_care_incl_care(data)
    data = discretizeSupport_recieve_care_incl_care(data)
    data = discretizeDichstbijzijnde(data, "Treinstation")
    data = discretizeWestersemigratieachtergrond(data)
    data = quarterize(data, "Walkability.WI7c_1719_500z")
    data = quarterize(data, "ADL_PERC_OVERALL_IMP")
    data = discretizeDichstbijzijnde(data, "Musea")
    data = discretizeFamily_members(data)
    data = quarterize(data, "Walkability.sw19_density_500r")
    data = discretizeWerksituatie(data);
    data = discretizeDiversity_type_N(data)
    data = discretizeLID_CLUBS(data)
    data = discretizeUrbanization_cat(data)
    data = discretizeRELATIE(data)
    data = discretizeOPLEIDINGSNIVEAU(data)
    data = discretizeGood_plus_relationship_total_incl_care(data)
    data = discretizeGreenspace(data)
    data = discretizeC_PHQ9_TOTAL(data)
    data = discretizePHQ9_TOTAL(data)
    data = discretizeLonelinessBinary(data)
    data = discretizeLoneliness(data)
    data = discretizeSex_network_members(data)
    data = discretizeSame_age(data)
    data = discretizeStrain_critique_incl_care(data)
    data = discretizeStrain_demanding_incl_care(data)
    data = discretizeStrain_taxing_incl_care(data)
    data = quarterize(data, "Herfindahl")
    data = discretizeLYING_HoursPerDay(data)
    data = quarterize(data, "pov_p_17")
    data = discretizeSITTING_HoursPerDay(data)
    data = discretizeAmbivalent_relationship_care(data)
    print(data["strain_critique_incl_care"].unique())

    return data

def discretizeSITTING_HoursPerDay  (data):
    data["SITTING_HoursPerDay"] = data["SITTING_HoursPerDay"].map(
        discretize_SITTING_HoursPerDay)
    return data

def discretize_SITTING_HoursPerDay(value):
    if value == "?":
        return value
    elif float(value) <= 4:
        return "low (<=4)"
    elif float(value) <= 6:
        return "medium (4-6)"
    else:
        return "high (>6)"

def discretizeLYING_HoursPerDay  (data):
    data["LYING_HoursPerDay"] = data["LYING_HoursPerDay"].map(
        discretize_LYING_HoursPerDay)
    return data

def discretize_LYING_HoursPerDay(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "zero"
    elif float(value) <= 2:
        return "1-2"
    else:
        return ">2"

def discretizeAmbivalent_relationship_care  (data):
    data["ambivalent_relationship_care"] = data["ambivalent_relationship_care"].map(
        discretize_ambivalent_relationship_care)
    print(data["ambivalent_relationship_care"])
    return data

def discretize_ambivalent_relationship_care(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "1"
    elif float(value) <= 2:
        return "2"
    elif float(value) <= 4:
        return "3-4"
    else:
        return ">=5"

def discretizeStrain_taxing_incl_care  (data):
    data["strain_taxing_incl_care"] = data["strain_taxing_incl_care"].map(
        discretize_strain_taxing_incl_care)
    return data

def discretize_strain_taxing_incl_care(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "1"
    elif float(value) <= 2:
        return "2"
    else:
        return ">2"

def discretizeStrain_demanding_incl_care  (data):
    data["strain_demanding_incl_care"] = data["strain_demanding_incl_care"].map(
        discretize_strain_demanding_incl_care)
    return data

def discretize_strain_demanding_incl_care(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "1"
    elif float(value) <= 2:
        return "2"
    else:
        return ">2"

def discretizeStrain_critique_incl_care  (data):
    data["strain_critique_incl_care"] = data["strain_critique_incl_care"].map(
        discretize_strain_critique_incl_care)
    return data

def discretize_strain_critique_incl_care(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "1"
    elif float(value) <= 2:
        return "2"
    else:
        return ">2"

def discretize_C_IPAQ_SCORE  (data):
    data["C_IPAQ_SCORE"] = data["C_IPAQ_SCORE"].map(
        discretize_c_IPAQ_SCORE)
    return data

def discretize_c_IPAQ_SCORE(value):
    if value == "?":
        return value
    elif float(value) <= 1:
        return "inactive"
    elif float(value) <= 2:
        return "minimally active"
    else:
        return "hepa active"

def discretize_C_Roken  (data):
    data["C_ROKEN"] = data["C_ROKEN"].map(
        discretize_c_roken)
    return data

def discretize_c_roken(value):
    if value == "?":
        return value
    elif float(value) <= 1:
        return "never smoker"
    elif float(value) <= 2:
        return "former smoker"
    else:
        return "current smoker"

def discretizeBMI  (data):
    data["BMI_cat"] = data["BMI_cat"].map(
        discretize_BMI)
    return data

def discretize_BMI(value):
    if value == "?":
        return value
    elif float(value) <= 1:
        return "=<18"
    elif float(value) <= 2:
        return "18-25"
    elif float(value) <= 3:
        return "=25-30"
    else:
        return ">30"

def discretizeSame_age  (data):
    data["same_age"] = data["same_age"].map(
        discretize_same_age)
    return data




def discretize_same_age(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 5:
        return "3-5"
    else:
        return ">5"

def discretizeSex_network_members  (data):
    data["sex_network_members_incl_care"] = data["sex_network_members_incl_care"].map(
        discretize_same_sex)
    return data


def discretize_same_sex(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 5:
        return "3-5"
    else:
        return ">5"

def discretizeLonelinessBinary  (data):
    data["lonelinessBinary"] = data["loneliness"].map(
        discretize_LonelinessBinary)
    return data


def discretize_LonelinessBinary(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "not lonely"
    else:
        return "lonely"

def discretizeLoneliness  (data):
    data["loneliness"] = data["loneliness"].map(
        discretize_Loneliness)
    return data


def discretize_Loneliness(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "not lonely"
    elif float(value) <= 1:
        return "Moderately lonely"
    else:
        return "(extremely) severly lonely"

def discretizePHQ9_TOTAL  (data):
    data["PHQ9_TOTAL"] = data["PHQ9_TOTAL"].map(
        discretize_PHQ9_TOTAL)
    return data

def discretizeC_PHQ9_TOTAL  (data):
    data["C_PHQ9_TOTAL"] = data["C_PHQ9_TOTAL"].map(
        discretize_C_PHQ9_TOTAL)
    return data


def discretize_C_PHQ9_TOTAL(value):
    if value == "?":
        return value
    elif float(value) <= 1:
        return "Geen tot minimale depressie"
    elif float(value) <= 2:
        return "Milde depressie"
    elif float(value) <= 3:
        return "Matige depressie"
    elif float(value) <= 4:
        return "Matig ernstige depressie"
    else:
        return "Ernstige depressie"

def discretizePHQ9_TOTAL  (data):
    data["PHQ9_TOTAL"] = data["PHQ9_TOTAL"].map(
        discretize_PHQ9_TOTAL)
    return data


def discretize_PHQ9_TOTAL(value):
    if value == "?":
        return value
    elif float(value) <= 4:
        return "Geen tot minimale depressie"
    elif float(value) <= 9:
        return "Milde depressie"
    elif float(value) <= 14:
        return "Matige depressie"
    elif float(value) <= 19:
        return "Matig ernstige depressie"
    else:
        return "Ernstige depressie"

def discretizeGreenspace (data):
    selected = [col for col in data.columns if ("Greenspace" in col)]
    data[selected[0]] = data[selected[0]].map(
        discretize_Greenspace)
    return data


def discretize_Greenspace(value):
    if value == "?":
        return value
    elif float(value) <= 50:
        return "<=50"
    elif float(value) <= 60:
        return "51-60"
    elif float(value) <= 70:
        return "61-70"
    elif float(value) <= 80:
        return "71-80"
    else:
        return ">80"

def discretizeGood_plus_relationship_total_incl_care (data):
    data["good_plus_relationship_total_incl_care"] = data["good_plus_relationship_total_incl_care"].map(
        discretize_Good_plus_relationship_total_incl_care)
    return data


def discretize_Good_plus_relationship_total_incl_care(value):
    if value == "?":
        return value
    elif float(value) == 0:
        return "Zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 4:
        return "3-4"
    else:
        return ">5"

def discretizeDiversity_type_N(data):
    data["diversity_type_N"] = data["diversity_type_N"].map(
        discretize_diversity_type_N)
    return data


def discretize_diversity_type_N(value):
    if value == "?":
        return value
    elif float(value) == 0:
        return "no family, but friends or acquaintances"
    elif float(value) == 1:
        return "only family, no friends or acquaintances"
    elif float(value) == 2:
        return "family and friends, but no acquaintances"
    elif float(value) == 3:
        return "family and friends, and acquaintances or other"
    elif float(value) == 4:
        return "family and acquaintances, but no friends"

def quarterize(data, column):
    Q1 = None
    Q2 = None
    Q3 = None
    notMissing = data[data[column] != '?']
    total = len(notMissing)
    unique = sorted(data[column].unique())
    for v in unique:
        if Q1 == None and (notMissing[column].astype(float) <= float(v)).sum() / (total) >= 0.25:
            Q1 = v
        elif Q2 == None and (notMissing[column].astype(float) <= float(v)).sum() / (total) >= 0.5:
             Q2 = v
        elif Q3 == None and (notMissing[column].astype(float) <= float(v)).sum() / (total) >= 0.75:
            Q3 = v
    data[column] = data[column].map(lambda x: quarters(x, Q1,Q2,Q3))
    return data

def quarters(value, Q1, Q2, Q3):
    if value == "?":
        return value
    elif float(value) <= float(Q1):
        return "<="+Q1
    elif float(value) <= float(Q2):
        return Q1+"-"+Q2
    elif float(value) <= float(Q3):
        return Q2+"-"+Q3
    else:
        return ">"+Q3

def discretizeWerksituatie(data):
    data["WERKSITUATIE"] = data["WERKSITUATIE"].map(
        discretize_Werksituatie)
    return data


def discretize_Werksituatie(value):
    if value == "?":
        return value
    elif float(value) == 1:
        return "True"
    else:
        return "False"

def discretizeWestersemigratieachtergrond(data):
    data["Westersemigratieachtergrond"] = data["Westersemigratieachtergrond"].map(
        discretize_Westersemigratieachtergrond)
    return data


def discretize_Westersemigratieachtergrond(value):
    if value == "?":
        return value
    elif float(value) == 0:
        return "Zero"
    elif float(value) <= 10:
        return "ten"
    elif float(value) <= 30:
        return "20-30"
    else:
        return ">30"


def discretizeUrbanization_cat(data):
    data["urbanization_cat"] = data["urbanization_cat"].map(discretize_urbanization_cat)
    return data


def discretize_urbanization_cat(value):
    if value == "?":
        return value
    elif float(value) == 1:
        return "one"
    elif float(value) <= 2:
        return "two"
    elif float(value) <= 3:
        return "three"
    else:
        return "four"


def discretizeSupport_recieve_care_incl_care(data):
    data["support_receive_care_incl_care"] = data["support_receive_care_incl_care"].map(
        discretize_support_recieve_care_incl_care)
    return data


def discretize_support_recieve_care_incl_care(value):
    if value == "?":
        return value
    elif float(value) == 0:
        return "zero"
    elif float(value) <= 1:
        return "one"
    elif float(value) <= 2:
        return "two"
    else:
        return ">2"


def discretizeSupport_give_care_incl_care(data):
    data["support_give_care_incl_care"] = data["support_give_care_incl_care"].map(
        discretize_support_give_care_incl_care)
    return data


def discretize_support_give_care_incl_care(value):
    if value == "?":
        return value
    elif float(value) == 0:
        return "Zero"
    elif float(value) <= 1:
        return "one"
    elif float(value) <= 2:
        return "two"
    else:
        return ">2"


def discretizeSupport_do_fun_things_incl_care(data):
    data["support_do_fun_things_incl_care"] = data["support_do_fun_things_incl_care"].map(
        discretize_support_do_fun_things_incl_care)
    return data


def discretize_support_do_fun_things_incl_care(value):
    if value == "?":
        return value
    elif float(value) == 0:
        return "Zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 5:
        return "3-5"
    elif float(value) <= 9:
        return "6-9"
    else:
        return ">9"


def discretizeRELATIE(data):
    data["RELATIE"] = data["RELATIE"].map(discretize_RELATIE)
    return data


def discretize_RELATIE(value):
    if value == "?":
        return value
    elif float(value) == 1:
        return "true"
    elif float(value) == 2:
        return "false"


def discretizePractical_support_incl_care(data):
    data["practical_support_incl_care"] = data["practical_support_incl_care"].map(
        discretize_practical_support_incl_care)
    return data


def discretize_practical_support_incl_care(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 5:
        return "3-5"
    elif float(value) <= 9:
        return "6-9"
    else:
        return ">9"


def discretizePhysical_phone_internet_video_call_contact(data):
    data["physical_phone_internet_video_call_contact"] = data["physical_phone_internet_video_call_contact"].map(
        discretize_physical_phone_internet_video_call_contact)
    return data


def discretize_physical_phone_internet_video_call_contact(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "zero"
    elif float(value) <= 1:
        return "one"
    elif float(value) <= 2:
        return "two"
    elif float(value) <= 3:
        return "three"
    elif float(value) <= 6:
        return "4-6"
    elif float(value) <= 10:
        return "7-10"
    else:
        return ">10"


def discretizePhysical_contact(data):
    data["physical_contact"] = data["physical_contact"].map(discretize_physical_contact)
    return data


def discretize_physical_contact(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "one"
    elif float(value) <= 2:
        return "two"
    elif float(value) <= 3:
        return "three"
    elif float(value) <= 6:
        return "4-6"
    elif float(value) <= 10:
        return "7-10"
    else:
        return ">10"


def discretizePhone_internet_video_call_contact(data):
    data["phone_internet_video_call_contact"] = data["phone_internet_video_call_contact"].map(
        discretize_phone_internet_video_call_contact)
    return data


def discretize_phone_internet_video_call_contact(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "zero"
    elif float(value) <= 1:
        return "one"
    elif float(value) <= 3:
        return "two"
    else:
        return ">2"


def discretizeOPLEIDINGSNIVEAU(data):
    data["OPLEIDINGSNIVEAU"] = data["OPLEIDINGSNIVEAU"].map(discretize_OPLEIDINGSNIVEAU)
    return data


def discretize_OPLEIDINGSNIVEAU(value):
    # 1 = -Ik volg momenteel een opleiding
    # 2 = -Geen / onvolledig basisonderwijs
    # 3= -Basisonderwijs
    # 4= -Lagere beroepsopleiding / voorbereidend beroepsonderwijs(bv.LTS, VMBO)
    # 5= -Middelbaar algemeen voortgezet onderwijs(bv.MAVO, MULO, ULO, MBO - kort, VMBO - t)
    # 6=-Middelbaar    beroepsonderwijs / beroepsbegeleidend    onderwijs(bv.MBO, MTS, MEAO, BOL, BBL)
    # 7=-Hoger    algemeen    voortgezet    onderwijs / voorbereidend    wetenschappelijk    onderwijs(bv.HAVO, VWO, Atheneum, Gymnasium, HBS)
    # 8=-Hogere    beroepsopleiding(bv.HBO, HTS, HEAO, HBO - V, PABO)
    # 9=-Wetenschappelijk    onderwijs(universiteit)    of    hoger
    if value == "?":
        return value
    elif float(value) == 1:
        return "Ik volg momenteel een opleiding"
    elif float(value) <= 5:
        return "Onderwijsniveau 1"
    elif float(value) <= 7:
        return "Onderwijsniveau 2"
    else:
        return "Onderwijsniveau 3"


def discretizeNietwestersemigratieachtergrond(data):
    data["Nietwestersemigratieachtergrond"] = data["Nietwestersemigratieachtergrond"].map(
        discretize_Nietwestersemigratieachtergrond)
    return data


def discretize_Nietwestersemigratieachtergrond(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 10:
        return "ten"
    elif float(value) <= 30:
        return "20-30"
    else:
        return ">30"


def discretizeNederlandseachtergrond(data):
    data["Nederlandseachtergond"] = data["Nederlandseachtergond"].map(discretize_Nederlandseachtergrond)
    return data


def discretize_Nederlandseachtergrond(value):
    if value == "?":
        return value
    elif float(value) <= 50:
        return "0-50"
    elif float(value) == 60:
        return "sixty"
    elif float(value) == 70:
        return "seventy"
    elif float(value) == 80:
        return "eighty"
    elif float(value) == 90:
        return "ninety"
    elif float(value) == 100:
        return "hundred"
    else:
        return "invalid?"


def discretizeNearness_walking_distance(data):
    data["nearness_walking_distance"] = data["nearness_walking_distance"].map(discretize_nearness_walking_distance)
    return data


def discretize_nearness_walking_distance(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "one"
    elif float(value) <= 2:
        return "two"
    elif float(value) <= 4:
        return "3-4"
    else:
        return ">4"

def discretizeNearness_more_than_30_min(data):
    data["nearness_more_than_30_min"] = data["nearness_more_than_30_min"].map(discretize_nearness_more_than_30_min)
    return data


def discretize_nearness_more_than_30_min(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "one"
    elif float(value) <= 2:
        return "two"
    elif float(value) <= 4:
        return "3-4"
    else:
        return ">4"

def discretizeNearness_less_than_15_min(data):
    data["nearness_less_than_15_min"] = data["nearness_less_than_15_min"].map(discretize_nearness_less_than_15_min)
    return data


def discretize_nearness_less_than_15_min(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "one"
    elif float(value) <= 2:
        return "two"
    elif float(value) <= 3 - 4:
        return "3-4"
    else:
        return ">4"


def discretizeNearness_house(data):
    data["nearness_house"] = data["nearness_house"].map(discretize_nearness_house)
    return data


def discretize_nearness_house(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "one"
    elif float(value) <= 2:
        return "two"
    else:
        return ">2"


def discretizeLID_CLUBS(data):
    data["LID_CLUBS"] = data["LID_CLUBS"].map(discretize_LID_CLUBS)
    return data


def discretize_LID_CLUBS(value):
    if value == "?":
        return value
    elif float(value) ==1:
        return "True"
    else:
        return "False"


def discretizeLBM(data):
    data["lbm"] = data["lbm"].map(discretize_lbm)
    return data


def discretize_lbm(value):
    if value == "?":
        return value
    elif float(value) < 4:
        return "klasse 3"
    else:
        return "klasse 4"


def discretizeInformational_support_incl_care(data):
    data["informational_support_incl_care"] = data["informational_support_incl_care"].map(
        discretize_informational_support_incl_care)
    return data


def discretize_informational_support_incl_care(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 5:
        return "3-5"
    elif float(value) <= 9:
        return "6-9"
    else:
        return ">9"


def discretizeHuurcoporatie(data):
    data["Huurcoporatie"] = data["Huurcoporatie"].map(discretize_Huurcoporatie)
    return data


def discretize_Huurcoporatie(value):
    if value == "?":
        return value
    elif float(value) <= 10:
        return "0-10"
    elif float(value) <= 20:
        return "10-20"
    elif float(value) <= 40:
        return "20-40"
    else:
        return ">40"


def discretizeHuishoudgrootte(data):
    data["Huishoudgrootte"] = data["Huishoudgrootte"].map(discretize_Huishoudgrootte)
    return data


def discretize_Huishoudgrootte(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "1"
    elif float(value) <= 2:
        return "2"
    else:
        return ">2"


def discretizeGEZONDHEID_NU_CBS(data):
    data["GEZONDHEID_NU_CBS"] = data["GEZONDHEID_NU_CBS"].map(discretize_GEZONDHEID_NU_CBS)
    return data


def discretize_GEZONDHEID_NU_CBS(value):
    if value == "?":
        return value
    elif float(value) == 1:
        return "one"
    elif float(value) == 2:
        return "two"
    elif float(value) == 3:
        return "three"
    elif float(value) == 4:
        return "four"
    else:
        return "five"


def discretizeFriends(data):
    data["friends"] = data["friends"].map(discretize_friends)
    return data


def discretize_friends(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 4:
        return "3-4"
    else:
        return ">4"


def discretizeFamily_members(data):
    data["family_members"] = data["family_members"].map(discretize_family_members)
    return data


def discretize_family_members(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 4:
        return "3-4"
    elif float(value) <= 6:
        return "5-6"
    else:
        return ">7"


def discretizeExtra_members(data):
    data["extra_members"] = data["extra_members"].map(discretize_extra_members)
    return data


def discretize_extra_members(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "1"
    else:
        return ">1"


def discretizeEmotional_support_talk_about_my_health_incl_care(data):
    data["emotional_support_talk_about_my_health_incl_care"] = data[
        "emotional_support_talk_about_my_health_incl_care"].map(
        discretize_emotional_support_talk_about_my_health_incl_care)
    return data


def discretize_emotional_support_talk_about_my_health_incl_care(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 5:
        return "3-5"
    elif float(value) <= 9:
        return "6-9"
    else:
        return ">9"


def discretizeEmotional_support_decisions_incl_care(data):
    data["emotional_support_decisions_incl_care"] = data["emotional_support_decisions_incl_care"].map(
        discretize_emotional_support_decisions_incl_care)
    return data


def discretize_emotional_support_decisions_incl_care(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 5:
        return "3-5"
    elif float(value) <= 9:
        return "6-9"
    else:
        return ">9"


def discretizeDifficult_relationship_total_incl_care(data):
    data["difficult_relationship_total_incl_care"] = data["difficult_relationship_total_incl_care"].map(
        discretize_difficult_relationship_total_incl_care)
    return data


def discretize_difficult_relationship_total_incl_care(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "zero"
    elif float(value) <= 1:
        return "one"
    else:
        return ">1"


def discretizeCaregivers(data):
    data["caregivers"] = data["caregivers"].map(discretize_caregivers)
    return data


def discretize_caregivers(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "zero"
    elif float(value) <= 1:
        return "one"
    else:
        return ">1"


def discretizeDichstbijzijnde(data, type):
    data[type + "dichtstbijzijnde"] = data[type + "dichtstbijzijnde"].map(discretize_dichstbijzijnde)
    return data


def discretize_dichstbijzijnde(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 1:
        return "0-1"
    else:
        return ">1"


def discretizeAge(data):
    data["age"] = data["age"].map(discretize_age)
    return data


def discretize_age(value):
    if value == "?":
        return value
    elif float(value) <= 30:
        return "18-30"
    elif float(value) <= 40:
        return "31-40"
    elif float(value) <= 50:
        return "41-50"
    elif float(value) <= 60:
        return "51-60"
    elif float(value) <= 70:
        return "61-70"
    elif float(value) <= 80:
        return "71-80"
    else:
        return ">80"


def discretizeNetworkSize(data):
    data["network_size_care"] = data["network_size_care"].map(discretize_network_size)
    return data


# Function to discretize network size values
def discretize_network_size(value):
    if value == "?":
        return value
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 5:
        return "3-5"
    elif float(value) <= 8:
        return "6-8"
    elif float(value) <= 12:
        return "9-12"
    elif float(value) <= 20:
        return "13-20"
    else:
        return ">21"

def discretizeAcquaintances(data):
    data["acquaintances"] = data["acquaintances"].map(discretize_acquaintances)
    return data


def discretize_acquaintances(value):
    if value == "?":
        return value
    elif float(value) <= 0:
        return "Zero"
    elif float(value) <= 2:
        return "1-2"
    elif float(value) <= 4:
        return "3-4"
    else:
        return ">4"
