# Support function to merge multiple multiply exclusive binary attributes into 1 attribute
# e.g. is_man, is_female, is_other into gender {is_man, is_female, is_other}
# Function to determine the 'combined' column
def merge_multiple_columns(df, cols):
    df_replaced = df[cols].replace("?", None)

    # Create a new DataFrame with column names where value is 1
    merged = df_replaced.apply(lambda row: next((col for col in cols if row[col] == 1), "?"), axis=1)

    return merged


def mergeBinary(columns, name, data):
    data[name] = merge_multiple_columns(data, columns)
    return data

def merge(data):
    #  Merge booster into 1 attribute
    binary_cols = ['F1_BOOSTER_A1', 'F1_BOOSTER_A2', 'F1_BOOSTER_A3', 'F1_BOOSTER_A4']
    data = mergeBinary(binary_cols, "F1_booster", data)
    data = data.drop(columns=binary_cols)

    #  Merge opleiding into 1 attribute
    binary_cols = ['F1_OPLEIDING_A1', 'F1_OPLEIDING_A2', 'F1_OPLEIDING_A3', 'F1_OPLEIDING_A4', 'F1_OPLEIDING_A5', 'F1_OPLEIDING_A6', 'F1_OPLEIDING_A7']
    data = mergeBinary(binary_cols, "F1_OPLEIDING", data)
    data = data.drop(columns=binary_cols)

    #  Merge vaccinatie into 1 attribute
    binary_cols = ['F1_VACCINATIE_A1', 'F1_VACCINATIE_A2', 'F1_VACCINATIE_A3', 'F1_VACCINATIE_A4']
    data = mergeBinary(binary_cols, "F1_vaccinatie", data)
    data = data.drop(columns=binary_cols)

    #  Merge afdelingen into 1 attribute
    binary_cols = ['F1_AFDELING_ZIEKENHUIS_A1', 'F1_AFDELING_ZIEKENHUIS_A2', 'F1_AFDELING_ZIEKENHUIS_A3', 'F1_AFDELING_ZIEKENHUIS_A4', 'F1_AFDELING_ZIEKENHUIS_A5', 'F1_AFDELING_ZIEKENHUIS_A6', 'F1_AFDELING_ZIEKENHUIS_A7']  # Explicitly define the columns to merge
    data = mergeBinary(binary_cols, "afdeling_ziekenhuis", data)
    data = data.drop(columns=binary_cols)

    #  Merge woonsituatie into 1 attribute
    binary_cols = ['WOONSITUATIE_A1', 'WOONSITUATIE_A2', 'WOONSITUATIE_A3',
                   'WOONSITUATIE_A4', 'WOONSITUATIE_A5', 'WOONSITUATIE_A6']  # Explicitly define the columns to merge
    data = mergeBinary(binary_cols, "woonsituatie", data)
    data = data.drop(columns=binary_cols)

    #  Merge f1 woonsituatie into 1 attribute
    binary_cols = ['F1_WOONSITUATIE_A1', 'F1_WOONSITUATIE_A2', 'F1_WOONSITUATIE_A3',
                   'F1_WOONSITUATIE_A4', 'F1_WOONSITUATIE_A5', 'F1_WOONSITUATIE_A6']  # Explicitly define the columns to merge
    data = mergeBinary(binary_cols, "F1_woonsituatie", data)
    data = data.drop(columns=binary_cols)
    return data

def mergeInfectiousDisease(data):
    data['URI'] = data['KLACHTEN_TWEE_MAANDEN_2']=='1' | data['KLACHTEN_TWEE_MAANDEN_3']=='1'
    return data

def mergeAandoening(data):
    aandoening_cols = [col for col in data.columns if (("AANDOENING" in col) and not ("_AANDOENING" in col))]
    data["has_aandoening"] = data[aandoening_cols].eq(1).any(axis=1)
    return data

def mergeF1Aandoening(data):
    aandoening_cols = [col for col in data.columns if ("F1_AANDOENING" in col)]
    data["has_F1_aandoening"] = data[aandoening_cols].eq(1).any(axis=1)
    return data