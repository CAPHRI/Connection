# Support function to merge multiple multiply exclusive binary attributes into 1 attribute
# e.g. is_man, is_female, is_other into gender {is_man, is_female, is_other}
# Function to determine the 'combined' column
import pandas

import preprocessing


def merge_multiple_columns(df, cols):
    df_replaced = df[cols].replace("?", None)

    # Create a new DataFrame with column names where value is 1
    merged = df_replaced.apply(lambda row: next((col for col in cols if row[col] == 1), "?"), axis=1)

    return merged


def mergeBinary(columns, name, data):
    data[name] = merge_multiple_columns(data, columns)
    return data


def merge(data):
    # #  Merge booster into 1 attribute
    # binary_cols = ['F1_BOOSTER_A1', 'F1_BOOSTER_A2', 'F1_BOOSTER_A3', 'F1_BOOSTER_A4']
    # data = mergeBinary(binary_cols, "F1_booster", data)
    # data = data.drop(columns=binary_cols)

    #  Merge opleiding into 1 attribute
    # binary_cols = ['F1_OPLEIDING_A1', 'F1_OPLEIDING_A2', 'F1_OPLEIDING_A3', 'F1_OPLEIDING_A4', 'F1_OPLEIDING_A5',
    #                'F1_OPLEIDING_A6', 'F1_OPLEIDING_A7']
    # data = mergeBinary(binary_cols, "F1_OPLEIDING", data)
    # data = data.drop(columns=binary_cols)

    #  Merge vaccinatie into 1 attribute
    # binary_cols = ['F1_VACCINATIE_A1', 'F1_VACCINATIE_A2', 'F1_VACCINATIE_A3', 'F1_VACCINATIE_A4']
    # data = mergeBinary(binary_cols, "F1_vaccinatie", data)
    # data = data.drop(columns=binary_cols)

    #  Merge afdelingen into 1 attribute
    # binary_cols = ['F1_AFDELING_ZIEKENHUIS_A1', 'F1_AFDELING_ZIEKENHUIS_A2', 'F1_AFDELING_ZIEKENHUIS_A3',
    #                'F1_AFDELING_ZIEKENHUIS_A4', 'F1_AFDELING_ZIEKENHUIS_A5', 'F1_AFDELING_ZIEKENHUIS_A6',
    #                'F1_AFDELING_ZIEKENHUIS_A7']  # Explicitly define the columns to merge
    # data = mergeBinary(binary_cols, "afdeling_ziekenhuis", data)
    # data = data.drop(columns=binary_cols)

    #  Merge woonsituatie into 1 attribute
    binary_cols = ['WOONSITUATIE_A1', 'WOONSITUATIE_A2', 'WOONSITUATIE_A3',
                   'WOONSITUATIE_A4', 'WOONSITUATIE_A5', 'WOONSITUATIE_A6']  # Explicitly define the columns to merge
    data = mergeBinary(binary_cols, "woonsituatie", data)
    data = data.drop(columns=binary_cols)

    #  Merge f1 woonsituatie into 1 attribute
    # binary_cols = ['F1_WOONSITUATIE_A1', 'F1_WOONSITUATIE_A2', 'F1_WOONSITUATIE_A3',
    #                'F1_WOONSITUATIE_A4', 'F1_WOONSITUATIE_A5',
    #                'F1_WOONSITUATIE_A6']  # Explicitly define the columns to merge
    # data = mergeBinary(binary_cols, "F1_woonsituatie", data)
    # data = data.drop(columns=binary_cols)
    return data


def mergeInfectiousDisease(data):
    data['URI'] = data['KLACHTEN_TWEE_MAANDEN_2'] == '1' | data['KLACHTEN_TWEE_MAANDEN_3'] == '1'
    return data


def mergeAandoening(data):
    aandoening_cols = [col for col in data.columns if (("AANDOENING" in col) and not ("_AANDOENING" in col))]
    data["has_aandoening"] = data[aandoening_cols].eq(1).any(axis=1)
    return data


def mergeF1Aandoening(data):
    aandoening_cols = [col for col in data.columns if ("F1_AANDOENING" in col)]
    data["has_F1_aandoening"] = data[aandoening_cols].eq(1).any(axis=1)
    return data


def mergeGoodVeryGoodRelationship(data):
    data["good_plus_relationship_total_incl_care"] = data["very_good_relationship_total_incl_care"] + data[
        "good_relationship_total_incl_care"]
    data = data.drop("very_good_relationship_total_incl_care", axis=1)
    data = data.drop("good_relationship_total_incl_care", axis=1)
    return data


def mergeNeareness(data):
    data["nearness_more_than_30_min"] = data["nearness_30_min_to_2h"] + data["nearness_more_than_2h"]
    data = data.drop("nearness_30_min_to_2h", axis=1)
    data = data.drop("nearness_more_than_2h", axis=1)
    return data


def createFindaIndex(data):
    data["proportion_family_members_incl_care"] = data["proportion_family_members_incl_care"].astype(str).str.replace(
        '?', '0').astype(float)
    data["proportion_friends_incl_care"] = data["proportion_friends_incl_care"].astype(str).str.replace('?',
                                                                                                        '0').astype(
        float)
    data["proportion_acquaintances_incl_care"] = data["proportion_acquaintances_incl_care"].astype(str).str.replace('?',
                                                                                                                    '0').astype(
        float)
    data["proportion_extra_members_incl_care"] = data["proportion_extra_members_incl_care"].astype(str).str.replace('?',
                                                                                                                    '0').astype(
        float)
    data["proportion_caregivers"] = data["proportion_caregivers"].astype(str).str.replace('?', '0').astype(float)

    data["Herfindahl"] = data["proportion_family_members_incl_care"] ** 2 + data[
        "proportion_friends_incl_care"] ** 2 + data["proportion_acquaintances_incl_care"] ** 2 + data[
                             "proportion_extra_members_incl_care"] ** 2 + data["proportion_caregivers"] ** 2

    return data


def combineBinary(data, cols):
    temp = data[cols].replace("?", pandas.NA)
    # Step 2: Compute OR across non-NA values
    c_val = temp.astype("boolean").any(axis=1)

    # Step 3: Restore "?" if all were "?"
    return c_val.mask(temp.notna().any(axis=1) == False, "?")


def mergeChronicStuff(data):
    cols = [col for col in data.columns if (("AANDOENING" in col))]
    for col in cols:
        # check both {0,1,?} and {0.0,1.0,?} because python randomly adds 0's
        if set(data[col].unique()).issubset({"0", "1", "?"}) or set(data[col].unique()).issubset({"0.0", "1.0", "?"}):
            data[col] = data[col].map(preprocessing.ternary_convert)

    # A21 = fimbormilagie
    # A22 = Nek- en/of rugklachten
    # A23 = Gewrichtsartrose of reuma
    # A24 = osteoperose
    data["aandoeningen_bewegingsapparaat"] = combineBinary(data, ["AANDOENING_A21", "AANDOENING_A22",
                                                                  "AANDOENING_A23", "AANDOENING_A24"])
    # A6 = Hoge bloeddruk (hypertensie)
    # A8 = Hartziekte (bijv. hartaanval minder dan 12 maanden geleden, hartfalen, hartritmestoornissen)
    # A9 = (Situatie na) beroerte/CVA (herseninfarct, hersenbloeding, TIA
    # A10 = Trombose
    # A11 = Perifeer vaatlijden (aandoening van de bloedvaten van bijv. de benen of grote lichaamsslagader; geen spataders)
    data["hart_en_vaatziekten"] = combineBinary(data, ["AANDOENING_A6", "AANDOENING_A8",
                                                       "AANDOENING_A9", "AANDOENING_A10", "AANDOENING_A11"])

    # A1 = COPD
    # A2 = Astma
    # A3 = (Situatie na) longembolie
    data["luchtwegaandoeningen"] = combineBinary(data, ["AANDOENING_A1", "AANDOENING_A2",
                                                        "AANDOENING_A3"])
    # A5 = Suikerziekte (diabetes mellitus)
    # A7 = Zwaarlijvigheid (obesitas)
    data["metabole_aandoeningen"] = combineBinary(data, ["AANDOENING_A5", "AANDOENING_A7"])

    # A16 = Migraine
    # A17 = Chronisch vermoeidheidssyndroom (ME/CVS)
    # A18 = Dementie
    # A19 = Ziekte van Parkinson
    # A20 = Multiple sclerose
    data["neurologische_aandoeningen"] = combineBinary(data, ["AANDOENING_A16", "AANDOENING_A17", "AANDOENING_A18",
                                                               "AANDOENING_A19", "AANDOENING_A20"])
    # A12 = Angststoornis
    # A13 = Depressie (stemmingsstoornis)
    # A14 = Overspannenheid, burn-out
    # A15 = Concentratiestoornissen
    data["psychische_aandoeningen"] = combineBinary(data, ["AANDOENING_A12", "AANDOENING_A13", "AANDOENING_A14",
                                                               "AANDOENING_A15"])
    # A25 = (Situatie na) kanker
    # A26 = Nierziekte
    # A27 = Leverziekte
    # A28 = Contacteczeem
    # A29 = Anders
    data["overige_aandoeningen"] = combineBinary(data, ["AANDOENING_A25", "AANDOENING_A26", "AANDOENING_A27",
                                                             "AANDOENING_A28", "AANDOENING_A29"])
    return data
